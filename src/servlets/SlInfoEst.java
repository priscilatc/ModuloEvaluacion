package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vistas.VW_estinfo;
import datos.DTInfoEst;

public class SlInfoEst extends HttpServlet {
 private static final long serialVersionUID = 1L;

    public SlInfoEst() {
    }

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String usuario=request.getParameter("usuario");
  VW_estinfo infoEst=DTInfoEst.consultarEst(usuario);
  if(infoEst!=null){
   request.setAttribute("infoEst", infoEst);
   request.getRequestDispatcher("ViewPerfil.jsp").forward(request, response);
   System.out.println("Thanks");
  }else{
   PrintWriter out=response.getWriter();
   out.println("Error, no se encontro el usuario.");
  }
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 }
}