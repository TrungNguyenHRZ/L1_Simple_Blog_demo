/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Trung Nguyen
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String REGISTRATION = "Register";
    private static final String REGISTRATION_CONTROLLER = "RegisterController";
    private static final String SEARCH_ARTICLE = "SearchArticle";
    private static final String SEARCH_ARTICLE_CONTROLLER = "SearchArticleController";
    private static final String VIEW_ARTICLE_DETAIL = "ViewDetail";
    private static final String VIEW_ARTICLE_DETAIL_CONTROLLER = "ViewDetailArticleController";
    private static final String INSERT_ARTICLE = "Post";
    private static final String INSERT_ARTICLE_CONTROLLER = "PostArticleController";
    private static final String COMMENT = "Comment";
    private static final String COMMENT_CONTROLLER = "CommentController";
    private static final String GET_LIST_ARTICLE = "GetArticle";
    private static final String GET_LIST_ARTICLE_CONTROLLER = "GetArticleController";
    private static final String APPROVAL_ARTICLE = "Approval";
    private static final String APPROVAL_ARTICLE_CONTROLLER = "ApprovalController";
    private static final String DELETE_ARTICLE = "Delete";
    private static final String DELETE_ARTICLE_CONTROLLER = "DeleteController";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (REGISTRATION.equals(action)) {
                url = REGISTRATION_CONTROLLER;
            } else if (SEARCH_ARTICLE.equals(action)) {
                url = SEARCH_ARTICLE_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (VIEW_ARTICLE_DETAIL.equals(action)) {
                url = VIEW_ARTICLE_DETAIL_CONTROLLER;
            } else if (INSERT_ARTICLE.equals(action)) {
                url = INSERT_ARTICLE_CONTROLLER;
            } else if (COMMENT.equals(action)) {
                url = COMMENT_CONTROLLER;
            } else if (GET_LIST_ARTICLE.equals(action)) {
                url = GET_LIST_ARTICLE_CONTROLLER;
            } else if (APPROVAL_ARTICLE.equals(action)) {
                url = APPROVAL_ARTICLE_CONTROLLER;
            }else if (DELETE_ARTICLE.equals(action)) {
                url = DELETE_ARTICLE_CONTROLLER;
            } else {
                request.setAttribute("ERROR", "Your action is not supported!!!");
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
