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
 * Servlet implementation class SLgestionPreguntaA
 */
@WebServlet("/SLgestionPreguntaA")
public class SLgestionPreguntaA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLgestionPreguntaA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		
		//Objetos de Rol
		DTPreguntaA dtpa =  new DTPreguntaA();
		PreguntaAbierta pa = new PreguntaAbierta();
		
		pa.setDescripcion(request.getParameter("descripcion"));
		pa.setIdNivel(Integer.parseInt(request.getParameter("idnivel")));
		pa.setIdPeriodoPPP(Integer.parseInt(request.getParameter("idperiodoppp")));
		
		switch (opc) 
		{
			case 1: 
				try 
				{
					if(dtpa.guardarPreguntaA(pa))
					{
						response.sendRedirect("ListaPreguntaAbierta.jsp?msj=1");
					}
					else
					{
						response.sendRedirect("ListaPreguntaAbierta.jsp?msj=2");
					}
				} 
				catch (Exception e) 
				{
					System.err.println("SLgestionPreguntaA el error es: " +e.getLocalizedMessage());
					e.printStackTrace();
				}
			
				break;
				
			case 2:
				try 
				{
					pa.setIdPreguntaAbierta(Integer.parseInt(request.getParameter("idpreguntaabierta")));
					if(dtpa.modificarPreguntaA(pa)) 
					{						
						response.sendRedirect("ListaPreguntaAbierta.jsp?msj=3");
					}
					else
					{
						response.sendRedirect("EditarPregunta_abierta.jsp?msj=4");
					}
				} 
				catch (Exception e) 
				{
					System.err.println("SLgestionPreguntaA el error es: " +e.getLocalizedMessage());
					e.printStackTrace();
				}
				break;

			default:
				break;
		}
		
	}

}