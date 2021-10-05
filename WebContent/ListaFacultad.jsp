<%@page import="vistas.VW_facultad" %>
<%@page import="java.util.ArrayList" %>
<%@page import="datos.DTFacultad" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String varMSJ = request.getParameter("msj")== null?"":request.getParameter("msj");
%>
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

<title>Modulo Evaluación - Lista de Facultades</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link rel=stylesheet href="jAlert/dist/jAlert.css"/>
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">


<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">
</head>
<body>
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
					<h1 class="h3 mb-2 text-gray-800">Lista de Facultades</h1>
					<hr>
						
						<a href="index.jsp">Inicio</a> /
						<a href="ListaFacultad.jsp">Lista de Facultades</a>
						
					<hr>


					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Lista de Facultades <i class="fa fa-question-circle" data-toggle="tooltip" data-placement="right" 
                           title="Lista de las facultades forman parte de la UCA,  en esta sección podrás agregar una nueva facultad, buscar, editar o eliminar sus datos."></i>							
							</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="tblfacultad" width="100%"
									cellspacing="0">
									
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre</th>
                                            <th>Correo</th>
                                            <th>Telefono</th>
                                            <th>Extensión Telefónica</th>
                                            <th>Dirección</th>
                                            <th>Opciones</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                           <th>ID</th>
                                            <th>Nombre</th>
                                            <th>Correo</th>
                                            <th>Telefono</th>
                                            <th>Extensión Telefónica</th>
                                            <th>Dirección</th>
                                            <th>Opciones</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                    <%
                                    DTFacultad dtf = new DTFacultad();
                                    ArrayList<VW_facultad> listaFacultades = new ArrayList<VW_facultad>();
                                    
                                    listaFacultades = dtf.listarFacultades();
                                    
                                    for(VW_facultad vwf: listaFacultades)
                                    {
                                    %>

										<tr>
                                         <td><%=vwf.getIdfacultad() %></td>
                                         <td><%=vwf.getNombre() %></td>
                                         <td><%=vwf.getCorreo() %></td>
                                         <td><%=vwf.getTelefono() %></td>
                                         <td><%=vwf.getExtension_telefonica() %></td>
                                         <td><%=vwf.getDireccion() %></td>
                                         <td>
									        <span>
                 								<a onclick="eliminarFacultad(<%=vwf.getIdfacultad()%>);">
                 									<i class="fas fa-trash" data-toggle="tooltip" data-placement="right" title="Eliminar"></i>
                 								</a>
                 							</span>
                 							<span>
                 								<a onclick="valoreditar(<%=vwf.getIdfacultad() %>)">
                 									<i class="fas fa-edit" data-toggle="tooltip" data-placement="right" title="Editar"></i>
                 								</a>
                 							</span>
                 						</td>                                                                                     
                                     </tr>
                                    <%
                                    }                                   
                                    %>                                   
                                    </tbody>
								</table>
								
								 <div class="d-sm-flex align-items-center justify-content-between mb-4">
			                        <a href="AgregarFacultad.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
			                        class="fas fa-plus fa-sm text-white-50"></i> Agregar Nueva Facultad</a>                                           
			                    </div>  
							</div>
						</div>
					</div>

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
	
	<script src="jAlert/dist/jAlert.min.js"></script>
    <script src="jAlert/dist/jAlert-functions.min.js"></script>
	<script type="text/javascript">
		
		function valoreditar(idfacultad)
		{
			window.location.href="EditarFacultad.jsp?idfacultad="+idfacultad;
			location.reload
		}
		
		function eliminarFacultad(id)
		{
			$.fn.jAlert.defaults.confirmQuestion = '¿Está Seguro?';
        	$.fn.jAlert.defaults.confirmBtnText = 'Si';
            confirm(function(e, btn){
                e.preventDefault();
                window.location.href = "SLeliminarFacultad?id="+id;
            },
            function(e,btn){
                e.preventDefault();
            });
		}
		
		</script>
	<script>
	    $(document).ready(function() {
	        $('#tblfacultad').DataTable({
	            responsive: true,
	            language: {
	                url: './vendor/datatables/es-ar.json'
	            }
	        });
	    });
	    
	    $(document).ready(function ()
        	    {
        	        var mensaje = "";
        	        mensaje = "<%=varMSJ%>";
        	        
        	        if(mensaje == "1")
        	        {
        	            successAlert('Registrado', 'Los datos han sido guardados exitosamente');
        	        }
        	        if(mensaje == "2")
        	        {
        	            errorAlert('Error', 'Revise los datos insertados');
        	        }
        	        if(mensaje == "3")
        	        {
        	        	successAlert('Modificado', 'Los datos han sido modificados exitosamente')
        	        }        	        
        	        if(mensaje == "4")
        	        {
        	            errorAlert('Error', 'Revise los datos insertados');
        	        }
        	        if(mensaje == "5")
        	        {
        	        	successAlert('Eliminado', 'Los datos han sido elimnados')
        	        }
        	        if(mensaje == "6")
        	        {
        	            errorAlert('Error', 'Error al eliminar los datos');
        	        }
        	    });
	 </script>
		
</body>
</html>