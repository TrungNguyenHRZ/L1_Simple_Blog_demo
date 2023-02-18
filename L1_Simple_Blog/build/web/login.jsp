<%-- 
    Document   : login
    Created on : Jan 5, 2023, 2:07:05 PM
    Author     : Trung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1><a style="text-decoration: none; color: blue" href="MainController?search=&action=SearchArticle">Home</a></h1>
        <h2>Login Form</h2>
        <hr/>
        <form action="MainController" method="POST">
            Email <input type="text" name="email"/><br/><br/>
            Password <input type="password" name="password"/><br/><br/>
            <input type="submit" value="Login" name="action"/>       
        </form>
        <h4 style="color: red">${requestScope.ERROR}</h4>
        Don't have an account? <a style="text-decoration: none; color: blue" href="register.jsp">Register</a>
    
    </body>
</html>
