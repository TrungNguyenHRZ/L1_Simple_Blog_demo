/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.article;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author MY PC
 */
public class ArticleDTO implements Serializable {
    
    private int titleId;
    private String titleName;
    private String shortDescription;
    private String content;
    private String author;
    private String date;
    private String status;

    public ArticleDTO() {
    }

    public ArticleDTO(int titleId, String titleName, String shortDescription, String content, String author, String date, String status) {
        this.titleId = titleId;
        this.titleName = titleName;
        this.shortDescription = shortDescription;
        this.content = content;
        this.author = author;
        this.date = date;
        this.status = status;
    }

    public ArticleDTO(String titleName, String shortDescription, String content, String author, String date, String status) {
        this.titleName = titleName;
        this.shortDescription = shortDescription;
        this.content = content;
        this.author = author;
        this.date = date;
        this.status = status;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    


    
    
}
