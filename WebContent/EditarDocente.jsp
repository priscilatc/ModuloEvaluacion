<%@page import="vistas.VW_coordinacion" %>
<%@page import="datos.DTCoordinacion" %>
<%@page import="vistas.VW_usuario" %>
<%@page import="datos.DTUsuario" %>
<%@page import="java.util.ArrayList"%>
<%@page import="datos.DTDocente" %>
<%@page import="entidades.Docente" %>
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

<title>Modulo Evaluación- Editar Docente</title>

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
					<h1 class="h3 mb-2 text-gray-800">Editar Docente </h1>
					<hr>
						
						<a href="index.jsp">Inicio</a> /
						<a href="ListaDocente.jsp">Lista de Docentes</a> /
						<a href="EditarDocente.jsp">Editar Docentes</a>
						
					<hr>
                     
					<%
					String id_docente = request.getParameter("id_docente");
					
					Docente d = new Docente();
					DTDocente dtd = new DTDocente();
					d= dtd.getDocente(Integer.parseInt(id_docente));
            		 %>
					<form class="form-group" method="post" action="./SLgestionDocente">
						<div class="form-group">
						<input hidden="true" name="id_docente" value="<%=id_docente%>">
						<input type="hidden" id="opcion" name="opcion" value="2" required/>
						
							
							<label class="col-sm-2 control-label text-rpromedix">Usuario</label>							
								    <div class="col-sm-6">							    
								      <select name="idusuario" id="idusuario" class="form-control" required>								    	
								      <%
								  		DTUsuario dtu = new DTUsuario();
										ArrayList<VW_usuario> listaUsuarios = new ArrayList<VW_usuario>();
										listaUsuarios = dtu.listarUsuarios();
										for(VW_usuario u: listaUsuarios){
                                		if(u.getIdUsuario()==d.getIdUsuario()){
                                		%>
                                			<option selected="true" value="<%=u.getIdUsuario()%>"><%=u.getUsuario()%> </option>
                                			
                                		<%
                                			}else{
                                		%>
                                			<option value="<%=u.getIdUsuario()%>"><%=u.getUsuario()%> </option>
                                    	<%
                                			}
                                		}
                                		%>
								      </select>
								      <div>
									    <a href="https://github.com/danielfarrell/bootstrap-combobox"></a>
									  </div>
								    </div>

							<label class="col-sm-2 control-label text-rpromedix">Coordinación</label>
							    <div class="col-sm-6">								    
							      <select id="idcoordinacion" name="idcoordinacion" class="form-control" required>								     
							      <%
							  		DTCoordinacion dtc = new DTCoordinacion();
									ArrayList<VW_coordinacion> listaCoordinaciones = new ArrayList<VW_coordinacion>();
									listaCoordinaciones = dtc.listarCoordinaciones();
									for(VW_coordinacion c: listaCoordinaciones){
                               		if(c.getIdcoordinacion()==d.getIdCoordinacion()){
                               		%>
                               			<option selected="true" value="<%=c.getIdcoordinacion()%>"><%=c.getNombre()%> </option>
                               			
                               		<%
                               			}else{
                               		%>
                               			<option value="<%=c.getIdcoordinacion()%>"><%=c.getNombre()%> </option>
                                 	   <%
                               			}
                               		}
                               	   %>
							      </select>
							      <div>
								    <a href="https://github.com/danielfarrell/bootstrap-combobox"></a>
								  </div>
							    </div>

							<label class="col-sm-2 control-label text-rpromedix">Nombres</label>
							<div class="col-sm-6">								
								<input id="nombres" name="nombres" type="text" class="form-control has-rpromedix" 
								placeholder="Ej:Julio Esteban" data-toggle="tooltip"  minlength="2" maxlength="30"
								data-placement="bottom" title="Min:2 Max:30" value="<%=d.getNombres()%>"required>
							
							</div>
							
							<label class="col-sm-2 control-label text-rpromedix">Apellidos</label>
							<div class="col-sm-6">
								<input id="apellidos" name="apellidos" type="text" class="form-control has-rpromedix" 
								placeholder="Ej:Romero Vega" data-toggle="tooltip" minlength="2" maxlength="30"
								data-placement="bottom" title="Min:2 Max:30" value="<%=d.getApellidos()%>" required>
								
							</div>
							
						<label class="col-sm-2 control-label text-gpromedix">Ciudad</label>
						<div class="col-sm-6">
							<input id="ciudad" name="ciudad" type="text" class="form-control has-gpromedix" 
							placeholder="Ej:Managua" data-toggle="tooltip" minlength="4" maxlength="30"
							data-placement="bottom" title="Min:4 Max:30" value="<%=d.getCiudad()%>" required>
						</div>
						
						<label class="col-sm-2 control-label text-gpromedix">Dirección</label>
						<div class="col-sm-6">
							<input id="direccion" name="direccion" type="text" class="form-control has-gpromedix" 
							placeholder="Ej:Frente al edificio E" data-toggle="tooltip" minlength="10" maxlength="50"
							data-placement="bottom" title="Min:10 Max:50" value="<%=d.getDireccion()%>" required>
						</div>	
						
						<label class="col-sm-2 control-label text-gpromedix">Celular</label>
						<div class="col-sm-6">
							<input id="celular" name="celular" type="tel" class="form-control has-gpromedix" 
							placeholder="Ej:77777777" data-toggle="tooltip"  minlength="8" maxlength="8"
							data-placement="bottom" title="Max:8" value="<%=d.getCelular()%>" required>
						</div>
						
						<label class="col-sm-2 control-label text-gpromedix">Cédula</label>
						<div class="col-sm-6">
							<input id="cedula" name="cedula" type="text" class="form-control has-gpromedix" 
							placeholder="Ej:001-200001-0000Y" data-toggle="tooltip" minlength="16" maxlength="20"
							data-placement="bottom" title="Min:16 Max:20" value="<%=d.getCedula()%>">
						</div>
						
						<label class="col-sm-2 control-label text-gpromedix">Carnet UCA</label>
						<div class="col-sm-6">
							<input id="carneUca" name="carneUca" type="text" class="form-control has-gpromedix" 
							placeholder="Ej:000022222" data-toggle="tooltip"  minlength="9" maxlength="10"
							data-placement="bottom" title="Min:9 Max:10" value="<%=d.getCarneUca()%>">
						</div>	
																			
						<label class="col-sm-2 control-label text-gpromedix">Cargo</label>
						<div class="col-sm-6">
							<input id="cargo" name="cargo" type="text" class="form-control has-gpromedix" 
							placeholder="Ej:Supervisor" data-toggle="tooltip" minlength="3" maxlength="20"
							data-placement="bottom" title="Min:4 Max:20" value="<%=d.getCargo()%>" required>
						</div>
						
						<label class="col-sm-2 control-label text-gpromedix">Trato</label>
						<div class="col-sm-6">
							<input id="trato" name="trato" type="text" class="form-control has-gpromedix" 
							placeholder="Ej:Licenciado" data-toggle="tooltip" minlength="3" maxlength="20"
							data-placement="bottom" title="Min:4 Max:20" value="<%=d.getTrato()%>" required>
						</div>	
								
								
						<label class="col-sm-2 control-label text-rpromedix">Categoria</label>
						    <div class="col-sm-6">
						      <select name="categoria" id="categoria" class="form-control" required>
						      	<option value="<%=d.getCategoria()%>"><%=d.getCategoria()%></option>
						        <option value="Tutor Academico">Tutor Academico</option>
						        <option value="Coordinador">Coordinador</option>
						      </select>
						      <div>
							    <a href="https://github.com/danielfarrell/bootstrap-combobox"></a>
							  </div>
						    </div>
											
						<label class="col-sm-2 control-label text-gpromedix">Correo</label>
						<div class="col-sm-6">
							<input id="correo" name="correo" type="email" class="form-control has-gpromedix" 
						placeholder="Ej:julio@doc.uca.edu.ni" data-toggle="tooltip"   minlength="10" maxlength="45"
							data-placement="bottom" title="Min:10 Max:45" value="<%=d.getCorreo() %>" required>
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