package org.mql.om.models.ged;

import java.util.GregorianCalendar;

public class Document {
	
	private int id;
	private String path;
	private String title;
	private String ceator;
	private String subject;
	private String description;
	private String publisher;
	private String contributor;
	private GregorianCalendar date;
	private Type type;
	private Format format;
	private String source;
	private Language language;
	private String relation;
	private String coverage;
	private String rights;

	public Document() {
		
	}

	public Document(int id, String path, String title, String ceator, String subject, String description,
			String publisher, String contributor, GregorianCalendar date, Type type, Format format, String source,
			Language language, String relation, String coverage, String rights) {
		super();
		this.id = id;
		this.path = path;
		this.title = title;
		this.ceator = ceator;
		this.subject = subject;
		this.description = description;
		this.publisher = publisher;
		this.contributor = contributor;
		this.date = date;
		this.type = type;
		this.format = format;
		this.source = source;
		this.language = language;
		this.relation = relation;
		this.coverage = coverage;
		this.rights = rights;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCeator() {
		return ceator;
	}

	public void setCeator(String ceator) {
		this.ceator = ceator;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getContributor() {
		return contributor;
	}

	public void setContributor(String contributor) {
		this.contributor = contributor;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	
}
