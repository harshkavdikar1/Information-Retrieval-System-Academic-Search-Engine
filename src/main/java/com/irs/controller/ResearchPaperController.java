package com.irs.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.irs.service.IAddResearchPapers;
import com.irs.service.ISearchResearchPapers;

@Controller
@SessionAttributes("result")
public class ResearchPaperController {

//	@Autowired
//	private IAddResearchPapers addResearchPapers;

	@Autowired
	private ISearchResearchPapers searchResearchPapers;

	@PostMapping("/search")
	public String show(@RequestParam String content, ModelMap model) throws SolrServerException, IOException {
		List<Object> results = searchResearchPapers.search(content);
		model.put("content", content);
		model.put("responsetime", results.get(0));
		model.put("numberofmatches", results.get(1));
		model.put("result", results.get(2));
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
