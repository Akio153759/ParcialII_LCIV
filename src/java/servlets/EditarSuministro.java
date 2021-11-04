/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.SuministroController;
import controllers.TipoSuministroController;
import controllers.UnidadesMedidaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Suministro;
import models.TipoSuministro;
import models.UnidadMedida;

/**
 *
 * @author Tama
 */
@WebServlet(name = "EditarSuministro", urlPatterns = {"/EditarSuministro"})
public class EditarSuministro extends HttpServlet {

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
            out.println("<title>Servlet EditarSuministro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditarSuministro at " + request.getContextPath() + "</h1>");
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
        String codigo = request.getParameter("id");
        
        SuministroController _controller = new SuministroController();
        
        Suministro _suministro = _controller.getSuministro(codigo);
        
        UnidadesMedidaController _UMController = new UnidadesMedidaController();
        TipoSuministroController _TSController = new TipoSuministroController();
        
        ArrayList<UnidadMedida> _lstUM = _UMController.getUnidadesMedida();
        ArrayList<TipoSuministro> _lstTS = _TSController.getTiposSuministro();
        
        request.setAttribute("unidades_medida", _lstUM);
        request.setAttribute("tipos_suministro", _lstTS);
        
        request.setAttribute("suministro", _suministro);
        
        request.setAttribute("action", "edit");
        
        RequestDispatcher _dispatcher = getServletContext().getRequestDispatcher("/suministro_form.jsp");
        
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
        
        String _codigo = request.getParameter("id");
        String _descripcion = request.getParameter("txtDescripcion").trim();
        boolean _ventaLibre = request.getParameter("chkVentaLibre") == "on" ? true: false;
        
        float _precio;
        
        try {
            _precio = Float.parseFloat(request.getParameter("txtPrecio").replace(",", "."));
        }
        catch (NumberFormatException ex) {
            _precio = 0; // mandar error
        }
        
        int _unidadMedida = Integer.parseInt(request.getParameter("cmbUnidadMedida"));
        float _contNeto = request.getParameter("txtContenidoNeto").equals("") ? 0 : Float.parseFloat(request.getParameter("txtContenidoNeto"));
        
         Suministro _suministro = new Suministro();
        
        _suministro.setCodigo(_codigo);
        _suministro.setDescripcion(_descripcion.equals("") ? null : _descripcion);
        _suministro.setVentaLibre(_ventaLibre);
        _suministro.setPrecioUnitario(_precio);
        _suministro.setContenidoNeto(_contNeto);
        _suministro.setUnidadMedida(new UnidadMedida(_unidadMedida, null, null));
        
        SuministroController _controller = new SuministroController();
        
        if (_controller.editarSuministro(_suministro)) {
            request.setAttribute("message", "Suministro modificado con éxito");
        }
        else {
            request.setAttribute("message", "No fué posible modificar suministro");
        }
        
        response.sendRedirect("/Parcial_II/ListadoSuministros");
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
