package com.irs.service;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
//import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irs.model.ResearchPaper;
import com.irs.repository.ResearchPapersRepository;

@Service
public class AddResearchPapers implements IAddResearchPapers {

	@Autowired
	private ResearchPapersRepository repository;

	private static int count = 0;

	private ArrayList<ResearchPaper> researchPaper = new ArrayList<ResearchPaper>();

	private void formatDoc(String file) throws IOException {
		String paper = new String(Files.readAllBytes(Paths.get(file)));
		String title = "NA";
		String author = "NA";
		count++;
		ResearchPaper rp = new ResearchPaper(Integer.toString(count), title, author, paper);
		researchPaper.add(rp);
	}

	@Override
	public void addResearchPapersToSolr() throws IOException {
		Path path = Paths.get("C:\\Users\\Hp-pc\\Downloads\\IRS\\data");
		Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				formatDoc(file.toFile().toString());
				if (count % 100 == 0) {
					repository.saveAll(researchPaper);
					System.out.println("No. of papers done = " + count + " file = " + file.toFile().toString());
					researchPaper = new ArrayList<ResearchPaper>();
				}
				return FileVisitResult.CONTINUE;
			}
		});
		repository.saveAll(researchPaper);
	}
}
