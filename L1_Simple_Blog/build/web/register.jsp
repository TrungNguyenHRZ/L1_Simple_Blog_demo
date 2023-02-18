<%-- 
    Document   : register
    Created on : Jan 12, 2023, 2:06:50 PM
    Author     : MY PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <h1>Registration Form</h1>
        <h3><a style="text-decoration: none; color: blue" href="login.html">Login</a></h3>
        <hr/>
        <form action="MainController" method="POST">
            Email <input type="text" name="email" required=""/>
            <font style="color: red">${requestScope.ACC_ERROR.email}</font><br/>
            
            Full Name <input type="text" name="name" required=""/>
            <font style="color: red">${requestScope.ACC_ERROR.name}</font><br/>
            
            Password <input type="password" name="password" required=""/><br/>           
            Password confirm <input type="password" name="confirm" required=""/>
            <font style="color: red">${requestScope.ACC_ERROR.confirm}</font><br/>
            
            Role <input type="text" name="role" value="member" readonly=""/><br/>  
            
            Status <input type="text" name="status" value="New" readonly=""/><br/>
            
            <br/><input type="submit" name="action" value="Register"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
