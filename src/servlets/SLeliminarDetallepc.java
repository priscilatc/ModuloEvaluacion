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
	 * Servlet implementation class SLeliminarDetallepc
	 */
	@WebServlet("/SLeliminarDetallepc")
	public class SLeliminarDetallepc extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public SLeliminarDetallepc() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try 
			{
				DetallePreguntaCerrada d = new DetallePreguntaCerrada();
				DTDetallepc dtd = new DTDetallepc();
				
				int iddetallepreguntacerrada = 0;
				
				iddetallepreguntacerrada = Integer.parseInt(request.getParameter("id"));
				d.setIdDetallePreguntaCerrada(iddetallepreguntacerrada);
				if(dtd.eliminarDetallePC(iddetallepreguntacerrada))
				{
					response.sendRedirect("ListaDetallePreguntaCerrada.jsp?msj=5");
				}
				else
				{
					response.sendRedirect("ListaDetallePreguntaCerrada.jsp?msj=6");
				}
			} 
			catch (Exception e) 
			{
				System.err.println("SL detalle: Error al eliminar opcion " +e.getMessage());
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
