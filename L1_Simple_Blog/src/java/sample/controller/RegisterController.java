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
import sample.account.AccountDAO;
import sample.account.AccountDTO;
import sample.account.AccountError;

/**
 *
 * @author MY PC
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    private static final String ERROR = "register.jsp";
    private static final String SUCCESS = "login.html";

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
        AccountError accountError = new AccountError();
        boolean checkValidation = true;
        AccountDAO dao = new AccountDAO();
        try {
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            String role = request.getParameter("role");
            String status = request.getParameter("status");

            if (email.length() < 8) {
                accountError.setEmail("Email required over 8 characters!!!");
                checkValidation = false;
            }

            if (!password.equals(confirm)) {
                accountError.setConfirm("Confirm Password and Password are NOT SAME!!!");
                checkValidation = false;
            }

            if (name.length() < 5 || name.length() > 20) {
                accountError.setName("Full Name must be in [5,20]!!!");
                checkValidation = false;
            }

            if (checkValidation) {
                AccountDTO account = new AccountDTO(email, name, password, role, status);
                boolean checkInsert = dao.insert(account);
                if (checkInsert) { 
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("ACC_ERROR", accountError);
            }

        } catch (Exception e) {
            log("Error at RegisterController: " + e.toString());
            if (e.toString().contains("duplicate")) {
                accountError.setEmail("Email is already in use!!!");
                request.setAttribute("ACC_ERROR", accountError);
            }
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
