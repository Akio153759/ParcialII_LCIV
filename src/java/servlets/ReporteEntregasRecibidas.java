/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.ReportController;
import controllers.SucursalController;
import dtos.DespachoDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Sucursal;

/**
 *
 * @author Tama
 */
@WebServlet(name = "ReporteEntregasRecibidas", urlPatterns = {"/ReporteEntregasRecibidas"})
public class ReporteEntregasRecibidas extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReporteEntregasRecibidas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReporteEntregasRecibidas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        SucursalController _controllerSucursal = new SucursalController();

        ArrayList<Sucursal> _lstSucursales = _controllerSucursal.getSucursales();
        

        request.setAttribute("sucursales", _lstSucursales);
       
        RequestDispatcher _dispatcher = getServletContext().getRequestDispatcher("/reporte_entregas_recibidas.jsp");
        
        _dispatcher.forward(request, response);
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
        
        String codSucursal = request.getParameter("codSucursal");
        
        ReportController _controller = new ReportController();
        
        ArrayList<DespachoDto> reporte = _controller.rptEntregasRecibidas(codSucursal);
        
        request.setAttribute("reporte", reporte);
        
        RequestDispatcher _dispatcher = getServletContext().getRequestDispatcher("/rpt_entregas_recibidas_resultado.jsp");
        
        _dispatcher.forward(request, response);
        
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
