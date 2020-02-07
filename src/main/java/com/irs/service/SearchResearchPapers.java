package com.irs.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irs.model.ResearchPaper;
import com.irs.repository.ResearchPapersRepository;

@Service
public class SearchResearchPapers implements ISearchResearchPapers {
	
	@Autowired
	private ResearchPapersRepository repository;
	
	@Override
	public List<ResearchPaper> search() {
		System.out.println("Hello---------------------");
		
		List<ResearchPaper> rp = repository.findByPaperContaining("Moreno-Navarro");
		System.out.println(rp.size());

		Iterator<ResearchPaper> iterator = rp.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}

		System.out.println("Kuch na mila");
		return rp;
	}
}
