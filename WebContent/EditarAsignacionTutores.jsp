<%@page import="vistas.VW_tutor_tecnico" %>
<%@page import="vistas.VW_estudiante" %>
<%@page import="vistas.VW_docente" %>
<%@page import="datos.DTTutorTecnico" %>
<%@page import="datos.DTEstudiante" %>
<%@page import="datos.DTDocente" %>
<%@page import="datos.DTAsignacion" %>
<%@page import="entidades.AsignacionTutores" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<%
    //Limpia la CACHE del navegador
	    response.setHeader("Pragma", "no-cache");
	    response.setHeader("Cache-Control", "no-store");
	    response.setDateHeader("Expires", 0);
	    response.setDateHeader("Expires", -1);
	      
		
		String loginUser = "";
		loginUser = (String)session.getAttribute("login");
		loginUser = loginUser==null?"":loginUser;
		
		if(loginUser.equals(""))
		{
			response.sendRedirect("login.jsp");
		}
    %>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Modulo Evaluación- Editar de Asignaciones de Tutores</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">


<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<jsp:include page="WEB-INF/layout/sidebar.jsp"></jsp:include>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->

				<jsp:include page="WEB-INF/layout/header.jsp"></jsp:include>

				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Editar a Asignacion de Tutores </h1>
					
					<hr>						
						<a href="index.jsp">Inicio</a> /
						<a href="ListaAsignacionTutores.jsp">Lista de Asignación de Tutores</a> /
						<a href="EditarAsignacionTutores.jsp">Editar Asignación de Tutores</a>	
					<hr>
                     
					<%
					  String idasignacion = request.getParameter("idasignacion");
					
					AsignacionTutores a = new AsignacionTutores();
					DTAsignacion dta = new DTAsignacion();
					a = dta.getAsignacion(Integer.parseInt(idasignacion));
            		 %>
					<form class="form-group" method="post" action="./SLgestionAsignacion">
						<div class="form-group">
						<input hidden="true" name="idasignacion" value="<%=idasignacion%>">
						<input type="hidden" id="opcion" name="opcion" value="2" required />
						<label class="col-sm-2 control-label text-rpromedix">Tutor Técnico</label>
						    <div class="col-sm-6">
						      <select id="idtutor" name="idtutor" class="form-control" requied>
						      <%
						  		DTTutorTecnico dtt = new DTTutorTecnico();
								ArrayList<VW_tutor_tecnico> listaTutorT = new ArrayList<VW_tutor_tecnico>();
								listaTutorT = dtt.listarTutoresT();
								for(VW_tutor_tecnico t : listaTutorT){
								if(t.getIdTutor()==a.getIdTutor()){
								%>
                              		<option selected="true" value="<%=t.getIdTutor()%>"><%=t.getNombre()%> </option>                               			
                              		<%
                              		}else{
                              		%>
                              		<option value="<%=t.getIdTutor()%>"><%=t.getNombre()%> </option>
                                	    <%
                              		}
                              		}
                              		%>
						      </select>
						      <div>
							    <a href="https://github.com/danielfarrell/bootstrap-combobox"></a>
							  </div>
						    </div>
								
								<label class="col-sm-2 control-label text-rpromedix">Docente</label>
								    <div class="col-sm-6">
								      <select id="id_docente" name="id_docente"class="form-control" required>

										<%
								  		DTDocente dtd = new DTDocente();
										ArrayList<VW_docente> listaDocentes = new ArrayList<VW_docente>();
										listaDocentes = dtd.listarDocentes();
										for(VW_docente d : listaDocentes){
										if(d.getId_docente()==a.getId_docente()){
										%>
                                		<option selected="true" value="<%=d.getId_docente()%>"><%=d.getNombre()%> </option>                               			
                                		<%
                                		}else{
                                		%>
                                		<option value="<%=d.getId_docente()%>"><%=d.getNombre()%> </option>
                                  	   <%
                                		}
                                		}
                                		%>
								      </select>
								      <div>
									    <a href="https://github.com/danielfarrell/bootstrap-combobox"></a>
									  </div>
								    </div>
								
								<label class="col-sm-2 control-label text-rpromedix">Estudiante</label>
								    <div class="col-sm-6">
								      <select id="idestudiante" name="idestudiante" class="form-control" required>
										<%
								  		DTEstudiante dte = new DTEstudiante();
										ArrayList<VW_estudiante> listaEstudiantes = new ArrayList<VW_estudiante>();
										listaEstudiantes = dte.listarEstudiantes();
										for(VW_estudiante d : listaEstudiantes){
										if(d.getIdestudiante()==a.getIdEstudiante()){
										%>
                                		<option selected="true" value="<%=d.getIdestudiante()%>"><%=d.getNombre()%> </option>                                			
                                		<%
                                		}else{
                                		%>
                                		<option value="<%=d.getIdestudiante()%>"><%=d.getNombre()%> </option>
                                  	   <%
                                		}
                                		}
                                		%>
								      </select>
								       <div>
									    <a href="https://github.com/danielfarrell/bootstrap-combobox"></a>
									  </div>
								    </div>
								
							
							<label class="col-sm-2 control-label text-rpromedix">Comentario</label>
							<div class="col-sm-6">
								<input id="comentario" name="comentario" type="text" class="form-control has-rpromedix" 
								placeholder="Ej:Excelente estudiante" data-toggle="tooltip"  minlength="10" maxlength="50"
								data-placement="bottom" title="Min:10 Max:100" value="<%=a.getComentario()%>">
							</div>
					</div>
					
					<div class="form-group has-feedback middle">
					


						<div class="col-sm-12">
							<h4 class="page-header">Acciones</h4>
							
							<div class="col-sm-6 text-center">
								<a style="cursor: pointer;"
									id="regresar" onclick="regresar();" title="Regresar"> <i
									class="fa fa-undo fa-2x"></i>
								</a>
							</div>
							<div class="col-sm-6 text-center">
								<button class="btn btn-outline-primary" type="submit" title="Guardar Registro">
									<i class="fas fa-save fa-2x"> </i>
								</button>
							</div>							
						</div>
					</div>
				</form>
					
				</div>

				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->

			<jsp:include page="WEB-INF/layout/footer.jsp"></jsp:include>

			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->
	</div>

		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>

		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">¿Listo para irte?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">Seleccione "Cerrar sesión" si está listo para finalizar su sesión actual.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancelar</button>
						<a class="btn btn-primary" href="login.jsp">Cerrar sesión</a>
					</div>
				</div>
			</div>
		</div>


		<!-- Bootstrap core JavaScript-->
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="js/sb-admin-2.min.js"></script>

		<!-- Page level plugins -->
		<script src="vendor/datatables/jquery.dataTables.min.js"></script>
		<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

		<!-- Page level custom scripts -->
		<script src="js/demo/datatables-demo.js"></script>
		
</body>

</html>