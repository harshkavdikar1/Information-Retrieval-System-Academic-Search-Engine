package com.irs.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "researchpaper")
public class ResearchPaper {

	@Id
	@Field
	private String id;
	@Field
	private String title;
	@Field
	private String author;
	@Field
	private String paper;

	public ResearchPaper(String id, String title, String author, String paper) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.paper = paper;
	}

	@Override
	public String toString() {
		return "ResearchPaper [id=" + id + ", name=" + title + ", author=" + author + ", paper=" + paper + "]";
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
