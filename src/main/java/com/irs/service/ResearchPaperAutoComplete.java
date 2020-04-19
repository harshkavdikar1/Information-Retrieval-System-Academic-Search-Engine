package com.irs.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class ResearchPaperAutoComplete implements IResearchPaperAutoComplete {

	@Override
	public List<String> researchPaperSuggester(String term) throws Exception {
		List<String> suggestions = new ArrayList<String>();

		String input = term.replace(" ", "%20");

		String endPoint = "http://localhost:8983/solr/researchpaper/suggest?wt=json&suggest=true&suggest.dictionary=mySuggester&suggest.q="
				+ input;

		URL url = new URL(endPoint);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");

		conn.connect();

		Scanner sc = new Scanner(url.openStream());
		String inline = "";
		while (sc.hasNext()) {
			inline += sc.nextLine();
		}

		JSONParser parser = new JSONParser();

		JSONObject parserObj = (JSONObject) parser.parse(inline);

		JSONObject suggester = (JSONObject) parserObj.get("suggest");

		JSONObject data = (JSONObject) suggester.get("mySuggester");

		JSONObject suggestions1 = (JSONObject) data.get(term);

		Iterator it = ((JSONArray) suggestions1.get("suggestions")).iterator();

		while (it.hasNext()) {
			JSONObject sugg = (JSONObject) it.next();
			suggestions.add((String) sugg.get("term"));
		}

		if (suggestions.size() == 0) {
			suggestions.add(term);
		}

		return suggestions;
	}

}
