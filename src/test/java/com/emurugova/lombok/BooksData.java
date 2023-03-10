package com.emurugova.lombok;

import com.emurugova.models.Books;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BooksData {

    private String isbn;
    private String title;
    private String author;
    @JsonProperty("publish_date")
    private String publishDate;
    private Integer pages;
    private List<Books> books;
}