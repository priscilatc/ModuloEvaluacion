package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DTPreguntaA;
import entidades.PreguntaAbierta;

/**
 * Servlet implementation class SLeliminarPreguntaA
 */
@WebServlet("/SLeliminarPreguntaA")
public class SLeliminarPreguntaA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLeliminarPreguntaA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try 
		{
			PreguntaAbierta pa = new PreguntaAbierta();
			DTPreguntaA dtpa = new DTPreguntaA();
			
			int idpreguntaabierta = 0;
			
			idpreguntaabierta = Integer.parseInt(request.getParameter("id"));
			pa.setIdPreguntaAbierta(idpreguntaabierta);
			if(dtpa.eliminarPreguntaA(idpreguntaabierta))
			{
				response.sendRedirect("ListaPreguntaAbierta.jsp?msj=5");
			}
			else
			{
				response.sendRedirect("ListaPreguntaAbierta.jsp?msj=6");
			}
		} 
		catch (Exception e) 
		{
			System.err.println("SL Pregunta Abierta: Error al eliminar pregunta abierta " +e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}