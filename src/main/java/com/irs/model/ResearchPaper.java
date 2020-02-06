package com.irs.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "researchpaper")
public class ResearchPaper {

	@Id
	@Field
	private int id;
	@Field
	private String title;
	@Field
	private String author;
	@Field
	private String paper;

	
	public ResearchPaper(int id, String title, String author, String paper) {
//		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.paper = paper;
	}
	@Override
	public String toString() {
		return "ResearchPaper [id=" + id + ", name=" + title + ", author=" + author + ", paper=" + paper + "]";
	}
	public String getName() {
		return title;
	}
	public void setName(String name) {
		this.title = name;
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
