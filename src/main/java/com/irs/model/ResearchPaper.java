package com.irs.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "research_papers")
public class ResearchPaper {

	@Id
	@Field
	private static int id = 0;
	@Field
	private String name;
	@Field
	private String author;
	@Field
	private String paper;

	
	public ResearchPaper(String name, String author, String paper) {
		super();
		ResearchPaper.id += 1;
		this.name = name;
		this.author = author;
		this.paper = paper;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
}
