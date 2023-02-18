/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.comment;

import java.io.Serializable;

/**
 *
 * @author MY PC
 */
public class CommentDTO implements Serializable{
    private int titleId;
    private String email;
    private String comment;

    public CommentDTO() {
    }

    public CommentDTO(int titleId, String email, String comment) {
        this.titleId = titleId;
        this.email = email;
        this.comment = comment;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    
    
    
}
