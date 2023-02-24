package com.emurugova.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//{
//        "isbn": "9781449325862",
//        "title": "Git Pocket Guide",
//        "subTitle": "A Working Introduction",
//        "author": "Richard E. Silverman",
//        "publish_date": "2020-06-04T08:48:39.000Z",
//        "publisher": "O'Reilly Media",
//        "pages": 234,
//        "description": "This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp",
//  }

@JsonIgnoreProperties(ignoreUnknown = true)
public class Books {

    private String isbn;
    private String title;
    private String author;
    @JsonProperty("publish_date")
    private String publishDate;
    private Integer pages;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}