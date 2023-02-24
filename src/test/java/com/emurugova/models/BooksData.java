package com.emurugova.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BooksData {

     private String isbn;
     private String title;
     private String author;
     @JsonProperty("publish_date")
     private String publishDate;
     private Integer pages;
     private List<Books> books;

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

     public List<Books> getBooks() {
          return books;
     }

     public void setBooks(List<Books> books) {
          this.books = books;
     }
}
