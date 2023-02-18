<%-- 
    Document   : article
    Created on : Jan 17, 2023, 1:36:00 PM
    Author     : MY PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1><a style="text-decoration: none; color: blue" href="MainController?search=&action=SearchArticle">Home</a></h1>
        <h1>Article List</h1>
        <c:if test="${sessionScope.LOGIN_ACC != null}">
            <h2>Welcome ${sessionScope.LOGIN_ACC.name}</h2>

            <form action="MainController">
                <input style="font-size: 15px; text-decoration: none; font-family: serif" type="submit" name="action" value="Logout"/>
            </form>
        </c:if>
        <c:if test="${sessionScope.LOGIN_ACC == null}">
            <a style="font-size: 20px; text-decoration: none; color: blue" href="login.html">Login</a>
        </c:if>

        <hr/>
        <font style="font-size: 20px">
        <form action="MainController">
            Search <input type="text" name="search" value="${param.search}"/>
            <input style="font-size: 20px; font-family: serif" type="submit" name="action" value="SearchArticle"/>
        </form> <br/>
        <c:if test="${sessionScope.LOGIN_ACC.role =='member'}">
            <a style="text-decoration: none; color: blue" href="postArticle.jsp">Post new article</a><br/>

        </c:if>

        <h5 style="color: green">${requestScope.INSERT_MSG}</h5>
        <c:if test="${requestScope.LIST_ARTICLE != null}">
            <c:if test="${not empty requestScope.LIST_ARTICLE}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Title Name</th>
                            <th>Short Description</th>
                            <th>Author</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="article" varStatus="counter" items="${requestScope.LIST_ARTICLE}">
                            <tr>
                        <form action="MainController">
                            <input type="text" name="titleId" value="${article.titleId}" hidden=""/>
                            <td>${counter.count}</td>
                            <td><input style="border: none; font-size: 20px; font-family: serif" type="text" name="titleName" value="${article.titleName}" readonly=""/></td>
                            <td>${article.shortDescription}</td>
                            <td>${article.author}</td>
                            <td>${article.date}</td>
                            <td>
                                <input style="font-size: 20px; font-family: serif" type="submit" name="action" value="ViewDetail"/>
                            </td>
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
