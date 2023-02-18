<%-- 
    Document   : admin
    Created on : Jan 9, 2023, 12:56:47 PM
    Author     : Trung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Page</title>
    </head>
    <body>
        <h1><a style="text-decoration: none; color: blue" href="MainController?search=&action=SearchArticle">Home</a></h1>
        <h2>Welcome ${sessionScope.LOGIN_ACC.name}</h2>
        <form action="MainController">
            <input style="font-size: 15px; text-decoration: none; font-family: serif" type="submit" name="action" value="Logout"/>
        </form>
        <hr/>
        <h1>Article List</h1>
        <font style="font-size: 20px">
        <c:if test="${requestScope.LIST_ALL_ARTICLE != null}">
            <c:if test="${not empty requestScope.LIST_ALL_ARTICLE}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Title name</th>
                            <th>Short description</th>
                            <th>Content</th>
                            <th>Author</th>
                            <th>Date</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="articleAll" varStatus="counter" items="${requestScope.LIST_ALL_ARTICLE}">                            
                            <tr>
                        <form action="MainController">
                            <input type="text" name="titleId" value="${articleAll.titleId}" hidden=""/>
                            <td>${counter.count}</td>
                            <td>${articleAll.titleName}</td>
                            <td>${articleAll.shortDescription}</td>
                            <td>${articleAll.content}</td>
                            <td>${articleAll.author}</td>
                            <td>${articleAll.date}</td>
                            <td>${articleAll.status}</td>
                            <td><input style="color: green; font-size: 20px; font-family: serif" type="submit" name="action" value="Approval"/></td>
                            <td><input style="color: red; font-size: 20px; font-family: serif" type="submit" name="action" value="Delete"/></td>
                        </form>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</c:if>
</font>
</body>
</html>
