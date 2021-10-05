<%@page import="entidades.Coordinacion" %>
<%@page import="vistas.VW_facultad" %>
<%@page import="datos.DTFacultad" %>
<%@page import="java.util.ArrayList" %>
<%@page import="datos.DTCoordinacion" %>
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
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Modulo Evaluación-Editar  Coordinación</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.css" rel="stylesheet" type="text/css">
    <link rel=stylesheet href="jAlert/dist/jAlert.css"/>
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.css" rel="stylesheet">

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
                     <h1 class="h3 mb-2 text-gray-800">Editar  Coordinacion</h1>
                     
                    <hr>
						
						<a href="index.jsp">Inicio</a> /
						<a href="ListaCoordinacion.jsp">Lista de Coordinación</a> /
						<a href="EditarCoordinacion.jsp">Editar Coordinación</a>
						
					<hr>
					
                    <%
					String idcoordinacion = request.getParameter("idcoordinacion");
					
					Coordinacion co = new Coordinacion();
					DTCoordinacion dtc = new DTCoordinacion();
					co = dtc.getCoordinacion(Integer.parseInt(idcoordinacion));
            		 %>
					<form class="form-group" method="post" action="./SLgestionCoordinacion">
						<div class="form-group">
						<input hidden="true" name="idcoordinacion" value="<%=idcoordinacion%>">
						<input type="hidden" id="opcion" name="opcion" value="2" required />
								<label class="col-sm-2 control-label text-rpromedix">Nombre: </label>
							<div class="col-sm-6">				
								<input id="nombre" name="nombre" type="text" class="form-control has-rpromedix" 
								placeholder="Ej: Coordinación de Ingeniería en Sistemas de Información"  data-toggle="tooltip" 
								minlength="20" maxlength="50"
								data-placement="bottom" title="Min:20 Max:50" value="<%=co.getNombre()%>" required>
							</div>
											
					       <label class="col-sm-2 control-label text-rpromedix">Correo: </label>
							<div class="col-sm-6">
								<input type="hidden" id="id_emp_edit" name="id_emp_edit" required />
								<input id="correo" name="correo" type="email" class="form-control has-rpromedix" 
								placeholder="Ej:isi@uca.edu.ni" data-toggle="tooltip"  minlength="10" maxlength="45"
								data-placement="bottom" title="Min:10 Max:45"" value="<%=co.getCorreo() %>" required>
							</div>
						
						<label class="col-sm-2 control-label text-gpromedix">Telefono: </label>
						<div class="col-sm-6">
							<input id="telefono" name="telefono" type="tel" class="form-control has-gpromedix" 
							placeholder="Ej:22222222" data-toggle="tooltip" minlength="8" maxlength="8"
							data-placement="bottom" title="Max:8" value="<%=co.getTelefono() %>" required>
						</div>
							
						<label class="col-sm-2 control-label text-gpromedix">Extension Telefónica: </label>
						<div class="col-sm-6">
							<input id="extension_telefonica" name="extension_telefonica" type="tel" class="form-control has-gpromedix" 
							placeholder="Ej:505" data-toggle="tooltip" minlength="2" maxlength="4"
							data-placement="bottom" title="Min:2 Max:4" value="<%=co.getExtension_telefonica()%>">
						</div>
									
						<label class="col-sm-2 control-label text-gpromedix">Direccion: </label>
						<div class="col-sm-6">
							<input id="Ej:Frente al edificio E"" name="direccion" type="text" class="form-control has-gpromedix" 
							placeholder="Direccion" data-toggle="tooltip" minlength="10" maxlength="50"
							data-placement="bottom" title="Min:10 Max:50" value="<%=co.getDireccion() %>" required>
						</div>	
						
						<label class="col-sm-2 control-label">Facultad:</label>
							<div class="col-sm-6">
						      <select id="idfacultad" name="idfacultad" class="form-control" required>
						      <%
						  		DTFacultad dtf = new DTFacultad();
								ArrayList<VW_facultad> listaFacultades = new ArrayList<VW_facultad>();
								listaFacultades = dtf.listarFacultades();
								for(VW_facultad f : listaFacultades){
								if(f.getIdfacultad()==co.getIdFacultad()){
								%>
                    			<option selected="true" value="<%=f.getIdfacultad()%>"><%=f.getNombre()%> </option>                    			
                    			<%
                    			}else{
                    			%>
                    			<option value="<%=f.getIdfacultad()%>"><%=f.getNombre()%> </option>
                       			 <%
                    			}
                    			}
                    			%>     
						      </select>
						       <a href="https://github.com/danielfarrell/bootstrap-combobox"></a>
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
								<button class="btn btn-outline-primary" type="submit" title="Guardar Cambios">
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
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
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
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>
    
     <script src="jAlert/dist/jAlert.min.js"></script>
	 <script src="jAlert/dist/jAlert-functions.min.js"></script>
	 
	 <script>
	 $(document).ready(function ()
     	    {
     	        var mensaje = "";
     	        mensaje = "<%=varMSJ%>";
     	            	             	        
     	        if(mensaje == "4")
     	        {
     	            errorAlert('Error', 'Revise los datos insertados');
     	        }
     	       
     	    });
	 </script>

</body>
</html>