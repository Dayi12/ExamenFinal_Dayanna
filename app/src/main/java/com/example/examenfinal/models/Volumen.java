package com.example.examenfinal.models;

public class Volumen {
    String section;
    String publication_id;
    String title;
    String doi;
    String abstrac;
    String date_published;
    String submission_id;
    String section_id;
    String seq;
    String galeys;
    String keywords;
    String authors;

    public Volumen(String section, String publication_id, String title, String doi, String abstrac, String date_published, String submission_id, String section_id, String seq, String galeys, String keywords, String authors) {
        this.section = section;
        this.publication_id = publication_id;
        this.title = title;
        this.doi = doi;
        this.abstrac = abstrac;
        this.date_published = date_published;
        this.submission_id = submission_id;
        this.section_id = section_id;
        this.seq = seq;
        this.galeys = galeys;
        this.keywords = keywords;
        this.authors = authors;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(String publication_id) {
        this.publication_id = publication_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getAbstrac() {
        return abstrac;
    }

    public void setAbstrac(String abstrac) {
        this.abstrac = abstrac;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getSubmission_id() {
        return submission_id;
    }

    public void setSubmission_id(String submission_id) {
        this.submission_id = submission_id;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getGaleys() {
        return galeys;
    }

    public void setGaleys(String galeys) {
        this.galeys = galeys;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
}
