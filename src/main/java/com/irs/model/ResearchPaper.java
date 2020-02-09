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
	private String content;
	@Field
	private String fileName;

	public ResearchPaper(String id, String title, String author, String content, String fileName) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
		this.fileName = fileName;
	}

	public ResearchPaper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ResearchPaper [id=" + id + ", title=" + title + ", author=" + author + ", content=" + content.substring(0, 20)
				+ ", fileName=" + fileName + "]";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String paper) {
		this.content = paper;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
