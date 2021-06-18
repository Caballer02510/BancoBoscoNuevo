/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cuota;
import modelo.Prestamo;
import modelo.Utilidades;

/**
 *
 * @author SergioCaballeroSáez
 */
public class servletBanco extends HttpServlet {
ArrayList<String> lista;
    @Override
    public void init() throws ServletException {
        lista = Utilidades.llenarLista();
    }

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("formulario.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Prestamo tmp = new Prestamo(
                Double.parseDouble(request.getParameter("capital")),
                Double.parseDouble(request.getParameter("interes")),
                Integer.parseInt(request.getParameter("tiempo")));
        
        
        request.setAttribute("nombre", request.getParameter("nombre"));
        
        request.setAttribute("tmp", tmp);
        request.setAttribute("lista", lista);
        
        ArrayList<Cuota> cuotas = new ArrayList();
        cuotas = Utilidades.generaListaCuotas(tmp.getTiempo(), tmp.getImportePrestamo());
        request.setAttribute("cuotas", cuotas);
        
        request.getRequestDispatcher("formulario.jsp").forward(request, response);
        
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
