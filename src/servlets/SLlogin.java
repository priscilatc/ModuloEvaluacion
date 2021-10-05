package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.*;
import vistas.VW_usuario_rol;

/**
 * Servlet implementation class SLlogin
 */
@WebServlet("/SLlogin")
public class SLlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLlogin() {
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
		
		try {
			VW_usuario_rol vwr = new VW_usuario_rol();
			DTUsuarioRol dtur = new DTUsuarioRol();
			
			int idrol= 0;
			String usuario, pwd="";
			usuario = request.getParameter("usuario");
			pwd = request.getParameter("pwd");
			idrol = Integer.parseInt(request.getParameter("rol"));		
			
			vwr.setUsuario(usuario);
			vwr.setPwd(pwd);
			vwr.setIdrol(idrol);
			
			if(dtur.loginUsuario(vwr)) {
				System.out.println("EL USUARIO ES CORRECTO");
				HttpSession hts = request.getSession(true);
				hts.setAttribute("login", usuario);
				hts.setAttribute("idrolusuario", idrol);
				
				System.out.println("USUARIO: "+ usuario);
				
				response.sendRedirect("index.jsp");
			}else {
				System.err.println("ERROR AL AUTENTICAR EL USUARIO");
				response.sendRedirect("login.jsp?error=1");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("ERROR EN SL_LOGIN: "+e.getMessage());
		}
	}

}