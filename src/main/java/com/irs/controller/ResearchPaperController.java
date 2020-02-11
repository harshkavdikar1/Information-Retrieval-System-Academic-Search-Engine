package com.irs.controller;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.irs.service.IAddResearchPapers;
import com.irs.service.ISearchResearchPapers;

@Controller
public class ResearchPaperController {

	@Autowired
	private IAddResearchPapers addResearchPapers;

	@Autowired
	private ISearchResearchPapers searchResearchPapers;

	@GetMapping("/add")
	public String addResearchPapersToSolr() throws IOException {
		addResearchPapers.addResearchPapersToSolr();
		return "results";
	}

	@PostMapping("/search")
	public String searchForReseacrhPapers(@RequestParam String content, ModelMap model)
			throws SolrServerException, IOException {
		List<Object> results = searchResearchPapers.search(content);
		model.put("content", content);
		model.put("responsetime", results.get(0));
		model.put("numberofmatches", results.get(1));
		model.put("result", results.get(2));
		model.put("file", results.get(3));
		return "results";
	}

	@GetMapping("/")
	public String setHomePage() {
		return "results";
	}

	@GetMapping("/error")
	public String setErrorPage() {
		return "results";
	}
}
