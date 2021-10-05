package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DTDetallepc;
import entidades.DetallePreguntaCerrada;

/**
 * Servlet implementation class SLgestionDetalle
 */
@WebServlet("/SLgestionDetalle")
public class SLgestionDetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLgestionDetalle() {
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
		
		
		DTDetallepc dtd =  new DTDetallepc();
		DetallePreguntaCerrada dpc = new DetallePreguntaCerrada();
				
		dpc.setDescripcion(request.getParameter("descripcion"));
		dpc.setIdPreguntaCerrada(Integer.parseInt(request.getParameter("idpreguntacerrada")));
		dpc.setIdNivel(Integer.parseInt(request.getParameter("idnivel")));

		switch (opc) 
		{
			case 1: 
				try 
				{
					if(dtd.guardarDetallePC(dpc))
					{
						response.sendRedirect("ListaDetallePreguntaCerrada.jsp?msj=1");
					}
					else
					{
						response.sendRedirect("ListaDetallePreguntaCerrada.jsp?msj=2");
					}
				} 
				catch (Exception e) 
				{
					System.err.println("SLgestionDetalle el error es: " +e.getLocalizedMessage());
					e.printStackTrace();
				}
			
				break;
				
			case 2:
				try 
				{
					dpc.setIdDetallePreguntaCerrada(Integer.parseInt(request.getParameter("iddetallepreguntacerrada")));
					if(dtd.modificarDetallePC(dpc)) 
					{
						response.sendRedirect("ListaDetallePreguntaCerrada.jsp?msj=3");
					}
					else
					{
						response.sendRedirect("ListaDetallePreguntaCerrada.jsp?msj=4");
					}
				} 
				catch (Exception e) 
				{
					System.err.println("SLgestionDetalle el error es: " +e.getLocalizedMessage());
					e.printStackTrace();
				}
				break;

			default:
				break;
		}
		
	}

}