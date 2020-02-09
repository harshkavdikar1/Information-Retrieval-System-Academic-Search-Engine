package com.irs.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.FieldStatsInfo;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Service;

@Service
public class SearchResearchPapers implements ISearchResearchPapers {

	@Override
	public List<Object> search(String content) throws SolrServerException, IOException {

		// Assign repository url
		String urlString = "http://localhost:8983/solr/researchpaper";

		// Create solr Client object
		HttpSolrClient solr = new HttpSolrClient.Builder().withBaseSolrUrl(urlString).build();
		solr.setParser(new XMLResponseParser());

		String searchQuery = "paper:\"" + content + "\"";

		SolrQuery query = new SolrQuery();

		// Set the number of rows to be displayed
		query.setStart(0);
		query.setRows(10);

		query.setQuery(searchQuery);

		// Set Highlight and field to be highlighted
		query.setHighlight(true);
		query.addHighlightField("paper");

		// Set statistics collection as true
		query.setGetFieldStatistics(true);
		query.setGetFieldStatistics("id");

		QueryResponse response = solr.query(query);

		// To find query execution time
		long responseTime = response.getElapsedTime();
		System.out.println("Query Resonse time = " + responseTime);

		// To find total number of records
		FieldStatsInfo stats = response.getFieldStatsInfo().get("id");
		long numberofmatches = stats.getCount();
		System.out.println("Total Number of records = " + numberofmatches);

		// First Field is the primary key in schema
		// Second field the field we are searching for
		// Third Field is the highlighted data
		Map<String, Map<String, List<String>>> hitHighlightedMap = response.getHighlighting();

		// List to store highlighted content from research papers
		List<String> highLightedTexts = new ArrayList<String>();

		// Iterate over each research paper and add highlighted text to list
		for (String key : hitHighlightedMap.keySet()) {
			Map<String, List<String>> highlightedFieldMap = hitHighlightedMap.get(key);
			List<String> highlightedList = highlightedFieldMap.get("paper");
			try {
				String highLightedText = highlightedList.get(0);
				highLightedTexts.add(highLightedText);
			} catch (NullPointerException e) {
			}
		}

		// To display entire content of research paper
//		List<ResearchPaper> rp = response.getBeans(ResearchPaper.class);

		List<Object> results = new ArrayList<Object>();

		results.add(responseTime);
		results.add(numberofmatches);
		results.add(highLightedTexts);

		return results;
	}
}
