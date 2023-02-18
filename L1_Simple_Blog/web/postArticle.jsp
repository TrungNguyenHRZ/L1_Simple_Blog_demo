<%-- 
    Document   : postArticle
    Created on : Feb 2, 2023, 12:45:12 PM
    Author     : Trung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post Article Page</title>
    </head>
    <body>
        <h1><a href="MainController?search=&action=SearchArticle" style="text-decoration: none; color: blue">Home</a></h1>
        <h1>Post Article Form</h1>
        <h2>Welcome ${sessionScope.LOGIN_ACC.name}</h2>
        <form action="MainController">
            <input style="font-size: 15px; text-decoration: none; font-family: serif" type="submit" name="action" value="Logout"/>
        </form>
        <hr/>
        <form action="MainController">
            <font style="font-size: 20px">
            Title name: <input style="font-size: 20px; font-family: serif" type="text" name="titleName" value="" required=""/><br/>
            Email: <input style="font-size: 20px; font-family: serif" type="text" name="email" value="${sessionScope.LOGIN_ACC.email}" readonly=""/><br/>
            Content: <input style="font-size: 20px; font-family: serif" type="text" name="content" value="" required=""><br/>
            Description: <input style="font-size: 20px; font-family: serif" type="text" name="description" value="" required=""/><br/><br/>
            <input style="font-size: 20px; font-family: serif" type="submit" name="action" value="Post"/><br/> 
            </font>
        </form>
            <h5 style="color: red">${requestScope.INSERT_MSG}</h5>
    </body>
</html>
