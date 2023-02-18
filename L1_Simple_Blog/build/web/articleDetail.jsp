<%-- 
    Document   : articleDetail
    Created on : Jan 28, 2023, 2:57:51 PM
    Author     : Trung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Article Detail Page</title>
    </head>
    <body>
        <h1><a href="MainController?search=&action=SearchArticle" style="text-decoration: none; color: blue">Home</a></h1>
        <h1>Article Detail</h1>
        <h2>Welcome ${sessionScope.LOGIN_ACC.name}</h2>

        <c:if test="${sessionScope.LOGIN_ACC != null}">         
            <form action="MainController">
                <input style="font-size: 15px; text-decoration: none; font-family: serif" type="submit" name="action" value="Logout"/>
            </form>
        </c:if>
        <hr/>
        <c:if test="${requestScope.ARTICLE_DETAIL != null}">
            <c:if test="${not empty requestScope.ARTICLE_DETAIL}">                
                <font style="font-size: 25px">
                <strong>Title: </strong>
                ${requestScope.ARTICLE_DETAIL.titleName}<br/>
                <strong>Short Description: </strong>
                ${requestScope.ARTICLE_DETAIL.shortDescription}<br/>
                <strong>Content: </strong><br/>
                ${requestScope.ARTICLE_DETAIL.content}<br/>
                <strong>Author: </strong>
                ${requestScope.ARTICLE_DETAIL.author}<br/>
                <strong>Posting Date: </strong>
                ${requestScope.ARTICLE_DETAIL.date}<br/>
                </font>
            </c:if>
        </c:if>
                
        <br/><br/><br/><br/>

        <h2>Comment this article</h2>
        <c:if test="${sessionScope.LOGIN_ACC == null}">
            <h3 style="color: red">Please <a style="text-decoration: none; color: blue" href="login.html">Login</a> to comment !!!</h3>
        </c:if>
            <c:if test="${sessionScope.LOGIN_ACC.role != 'member'}">
            <h3 style="color: red"><a style="text-decoration: none; color: blue" href="login.html">Login</a> with member role to comment !!!</h3>
        </c:if>
        <c:if test="${sessionScope.LOGIN_ACC != null}">
            <c:if test="${sessionScope.LOGIN_ACC.role == 'member'}">
            <br/>
            <form action="MainController">
                <input type="text" name="titleId" value="${requestScope.ARTICLE_DETAIL.titleId}" hidden=""/>
                <input type="text" name="titleName" value="${requestScope.ARTICLE_DETAIL.titleName}" hidden="">
                <input type="text" name="email" value="${sessionScope.LOGIN_ACC.email}" hidden=""/>
                <input style="font-family: serif; font-size: 20px" type="text" name="comment" value="" required=""/>
                <input style="font-family: serif; font-size: 20px" type="submit" name="action" value="Comment"/>
            </form>
            </c:if>
        </c:if><br/>
            <c:if test="${requestScope.LIST_COMMENT != null}">
                <c:if test="${not empty requestScope.LIST_COMMENT}">
                    <c:forEach var="comment" items="${requestScope.LIST_COMMENT}">
                        <strong style="color: blue; font-size: 20px">${comment.email}</strong>: 
                        <font style="font-size: 20px">${comment.comment}<br/></font>
                    </c:forEach>
                </c:if> 
            </c:if>
    </body>
</html>
