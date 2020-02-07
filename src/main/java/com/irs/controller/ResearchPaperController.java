package com.irs.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irs.model.ResearchPaper;
import com.irs.service.IAddResearchPapers;
import com.irs.service.ISearchResearchPapers;

@RestController
public class ResearchPaperController {

//	@Autowired
//	private IAddResearchPapers addResearchPapers;
	
	@Autowired
	private ISearchResearchPapers searchResearchPapers;

//	@PostConstruct
//	public void addResearchPapersToSolr() throws IOException {
//		addResearchPapers.addResearchPapersToSolr();
//	}

	@GetMapping("/findByTextInPaper")
	public List<ResearchPaper> searchResearchPapers() throws IOException {
		return searchResearchPapers.search();
	}
}
