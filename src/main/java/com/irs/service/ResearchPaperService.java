package com.irs.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irs.model.ResearchPaper;
import com.irs.repository.ResearchPapersRepository;

@Service
public class ResearchPaperService implements ResearchPaperServiceInterface{
	
//	@Autowired
//	private ResearchPapersRepository repository;
	
	@Override
	public ArrayList<ResearchPaper> addResearchPapers() throws IOException {
		ArrayList<ResearchPaper> researchPaper = new ArrayList<ResearchPaper>();
		
		String fileName = "C:\\Users\\Hp-pc\\Downloads\\IRS\\data\\1\\10.1.1.2.1.txt";
		String paper = new String(Files.readAllBytes(Paths.get(fileName)));
		String name = "A test research paper 1";
		String author = "Harsh";
		System.out.println(paper);

		ResearchPaper rp = new ResearchPaper(name, author, paper);

		researchPaper.add(rp);

		fileName = "C:\\Users\\Hp-pc\\Downloads\\IRS\\data\\2\\10.1.1.2.2.txt";
		paper = new String(Files.readAllBytes(Paths.get(fileName)));
		System.out.println(paper);
		name = "A test research paper 1";
		author = "Harsh";
		
		rp = new ResearchPaper(name, author, paper);
		
		researchPaper.add(rp);
		
		return researchPaper;
//		repository.saveAll(researchPaper);
	}
}
