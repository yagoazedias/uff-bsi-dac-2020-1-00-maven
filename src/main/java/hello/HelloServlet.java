/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private String defineBodyMessage(String lang, int hour, String nome, String tratamento) {
        String msg = "";

        if(lang==null)
            lang = "pt";

        switch (lang) {
            case "pt":
                if (hour < 12) {
                    msg = "Bom dia, ";
                } else if (hour > 12 && hour < 18) {
                    msg = "Boa tarde, ";
                } else {
                    msg = "Boa noite, ";
                }
                if (tratamento.equals("Sr.") || tratamento.equals("Sra.")) {
                    msg = msg + " " + tratamento + " ";
                }
                break;
            case "en":
                if (hour < 12) {
                    msg = "Good morning, ";
                } else if (hour > 12 && hour < 18) {
                    msg = "Good afternoon, ";
                } else {
                    msg = "Good evening, ";
                }
                if (tratamento.equals("Sr.")) {
                    msg = msg + " " + "Mr." + " ";
                } else if (tratamento.equals("Sra.")) {
                    msg = msg + " " + "Mrs" + " ";
                }
                break;
            case "fr":
                if (hour < 12) {
                    msg = "Bonjour, ";
                } else if (hour > 12 && hour < 18) {
                    msg = "Bon après-midi, ";
                } else {
                    msg = "Bonne soirée, ";
                }
                if (tratamento.equals("Sr.")) {
                    msg = msg + " " + "Monsieur." + " ";
                } else if (tratamento.equals("Sra.")) {
                    msg = msg + " " + "Mme." + " ";
                }
                break;
            case "de":
                if (hour < 12) {
                    msg = "Guten Morgen, ";
                } else if (hour > 12 && hour < 18) {
                    msg = "Guten Tag, ";
                } else {
                    msg = "Gute Nacht, ";
                }
                if (tratamento.equals("Sr.")) {
                    msg = msg + " " + "Herr." + " ";
                } else if (tratamento.equals("Sra.")) {
                    msg = msg + " " + "Frau." + " ";
                }
                break;
            case "su":
                if (hour < 12) {
                    msg = "Habari za asubuhi, ";
                } else if (hour > 12 && hour < 18) {
                    msg = "Habari za jioni, ";
                } else {
                    msg = "Usiku mwema, ";
                }
                if (tratamento.equals("Sr.")) {
                    msg = msg + " " + "Bwana." + " ";
                } else if (tratamento.equals("Sra.")) {
                    msg = msg + " " + "Bi." + " ";
                }
                break;
            case "ja":
                if (hour < 12) {
                    msg = "おはようございます, ";
                } else if (hour > 12 && hour < 18) {
                    msg = "こんにちは, ";
                } else {
                    msg = "おやすみなさい, ";
                }
                if (tratamento.equals("Sr.")) {
                    msg = msg + " " + "氏." + " ";
                } else if (tratamento.equals("Sra.")) {
                    msg = msg + " " + "夫人." + " ";
                }
                break;
        }

        if(nome==null)
            nome = "Fulano";

        msg = msg+nome+"!";
        return msg;
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

        String msg = "";
        int hour = LocalDateTime.now().getHour();
        String lang = request.getParameter("lang");

        String nome = request.getParameter("nome");
        String tratamento = request.getParameter("tratamento");
        String color = request.getParameter("color");

        msg = this.defineBodyMessage(lang, hour, nome, tratamento);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println(String.format("<p style=\"color:%s\">%s</p>", color, msg));
            out.println("</body>");
            out.println("</html>");
        }
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

        String msg = "";
        int hour = LocalDateTime.now().getHour();
        String lang = request.getParameter("lang");

        String nome = request.getParameter("nome");
        String tratamento = request.getParameter("tratamento");
        String color = request.getParameter("color");

        msg = this.defineBodyMessage(lang, hour, nome, tratamento);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println(String.format("<p style=\"color:%s\">%s</p>", color, msg));
            out.println("</body>");
            out.println("</html>");
        }
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
