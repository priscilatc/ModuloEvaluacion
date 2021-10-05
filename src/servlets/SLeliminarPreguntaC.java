package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DTPreguntaC;
import entidades.PreguntaCerrada;

/**
 * Servlet implementation class SLeliminarPreguntaC
 */
@WebServlet("/SLeliminarPreguntaC")
public class SLeliminarPreguntaC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLeliminarPreguntaC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try 
		{
			PreguntaCerrada pc = new PreguntaCerrada();
			DTPreguntaC dtpc = new DTPreguntaC();
			
			int idpreguntacerrada = 0;
			
			idpreguntacerrada = Integer.parseInt(request.getParameter("id"));
			pc.setIdPreguntaCerrada(idpreguntacerrada);
			if(dtpc.eliminarPreguntaC(idpreguntacerrada))
			{
				response.sendRedirect("ListaPreguntaCerrada.jsp?msj=5");
			}
			else
			{
				response.sendRedirect("ListaPreguntaCerrada.jsp?msj=6");
			}
		} 
		catch (Exception e) 
		{
			System.err.println("SL Pregunta Cerrada: Error al eliminar pregunta cerrada " +e.getMessage());
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