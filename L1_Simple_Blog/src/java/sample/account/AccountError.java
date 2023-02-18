/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.account;

import java.io.Serializable;

/**
 *
 * @author MY PC
 */
public class AccountError implements Serializable{
    private String email;
    private String name;
    private String password;
    private String confirm;
    private String role;
    private String status;

    public AccountError() {
        this.email = "";
        this.name = "";
        this.password = "";
        this.confirm = "";
        this.role = "";
        this.status = "";
    }

    public AccountError(String email, String name, String password, String confirm, String role, String status) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.confirm = confirm;
        this.role = role;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
