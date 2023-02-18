/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.article.ArticleDAO;
import sample.article.ArticleDTO;
import sample.comment.CommentDAO;
import sample.comment.CommentDTO;

/**
 *
 * @author Trung Nguyen
 */
@WebServlet(name = "ViewDetailArticleController", urlPatterns = {"/ViewDetailArticleController"})
public class ViewDetailArticleController extends HttpServlet {

    private static final String ERROR = "article.jsp";
    private static final String SUCCESS = "articleDetail.jsp";
    
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
            //acticle detail
            String titleName = request.getParameter("titleName");           
            ArticleDAO dao = new ArticleDAO();
            ArticleDTO dto = dao.getArticleDetail(titleName);
            if(dto != null) {
                request.setAttribute("ARTICLE_DETAIL", dto);
                url = SUCCESS;
            }
            //comment
            int titleId = Integer.parseInt(request.getParameter("titleId"));
            CommentDAO commentDAO = new CommentDAO();
            List<CommentDTO> listComment = commentDAO.getListComment(titleId);
            if(listComment.size() > 0) {
                request.setAttribute("LIST_COMMENT", listComment);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at ViewDetailArticleController: " + e.toString());
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
