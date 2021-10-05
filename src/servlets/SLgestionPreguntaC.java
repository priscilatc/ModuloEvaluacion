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
 * Servlet implementation class SLgestionPreguntaC
 */
@WebServlet("/SLgestionPreguntaC")
public class SLgestionPreguntaC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLgestionPreguntaC() {
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
		DTPreguntaC dtpc =  new DTPreguntaC();
		PreguntaCerrada pc = new PreguntaCerrada();
		
		pc.setDescripcion(request.getParameter("descripcion"));
		pc.setIdPeriodoPPP(Integer.parseInt(request.getParameter("idperiodoppp")));
		
		switch (opc) 
		{
			case 1: 
				try 
				{
					if(dtpc.guardarPreguntaC(pc))
					{
						response.sendRedirect("ListaPreguntaCerrada.jsp?msj=1");
					}
					else
					{
						response.sendRedirect("ListaPreguntaCerrada.jsp?msj=2");
					}
				} 
				catch (Exception e) 
				{
					System.err.println("SLgestionPreguntaC el error es: " +e.getLocalizedMessage());
					e.printStackTrace();
				}
			
				break;
				
			case 2:
				try 
				{
					pc.setIdPreguntaCerrada(Integer.parseInt(request.getParameter("idpreguntacerrada")));
					if(dtpc.modificarPreguntaC(pc)) 
					{						
						response.sendRedirect("ListaPreguntaCerrada.jsp?msj=3");
					}
					else
					{
						response.sendRedirect("EditarPregunta_cerrada.jsp?msj=4");
					}
				} 
				catch (Exception e) 
				{
					System.err.println("SLgestionPreguntaC el error es: " +e.getLocalizedMessage());
					e.printStackTrace();
				}
				break;

			default:
				break;
		}
		
	}

}