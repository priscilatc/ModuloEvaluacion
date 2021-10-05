<%@page import="vistas.VW_periodoppp" %>
<%@page import="vistas.VW_nivel" %>
<%@page import="datos.DTNivel" %>
<%@page import="datos.DTPeriodoPPP" %>
<%@page import="datos.DTPreguntaA" %>
<%@page import="java.util.ArrayList" %>
<%@page import="entidades.PreguntaAbierta" %>
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
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Modulo Evaluación-Editar  Pregunta abierta</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.css" rel="stylesheet" type="text/css">
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
                     <h1 class="h3 mb-2 text-gray-800">Editar  Pregunta abierta</h1>
                     <hr>
						
						<a href="index.jsp">Inicio</a> /
						<a href="ListaPreguntaAbierta.jsp">Lista de Preguntas Abiertas</a> /
						<a href="EditarPregunta_abierta.jsp">Editar Pregunta Abierta</a>
						
					<hr>
                     
					<%
					   String idpreguntaabierta = request.getParameter("idpreguntaabierta");
					
						PreguntaAbierta pa = new PreguntaAbierta();
						DTPreguntaA dtpa =  new DTPreguntaA();
						pa = dtpa.getPreguntaA(Integer.parseInt(idpreguntaabierta));
					%>						
					<form class="form-group" method="post" action="./SLgestionPreguntaA">
						<div class="form-group">
						<input type="hidden" id="opcion" name="opcion" value="2" required />
						<input type="hidden" id="idpreguntaabierta" name="idpreguntaabierta" value="<%=idpreguntaabierta%>" required />

							<label class="col-sm-2 control-label text-rpromedix">Descripcion: </label>
							<div class="col-sm-6">
								<input id="descripcion" name="descripcion" type="text" class="form-control has-rpromedix" 
								placeholder="Ej:Describa los conocimientos que le fueron utiles en su PPP" data-toggle="tooltip" minlength="10" maxlength="50"
							data-placement="bottom" title="Min:4 Max:20" value="<%=pa.getDescripcion() %>" required>
							</div>
											
						<label class="col-sm-2 control-label text-rpromedix">Periodo PPP:</label>
						    <div class="col-sm-6">
						      <select id="idperiodoppp" name="idperiodoppp" class="form-control" required>								        
						  		<%
						  		DTPeriodoPPP dtp = new DTPeriodoPPP();
								ArrayList<VW_periodoppp> listaPeriodos = new ArrayList<VW_periodoppp>();
								listaPeriodos = dtp.listarPeriodos();
								for(VW_periodoppp p : listaPeriodos){
									if(p.getIdperiodoppp()==pa.getIdPeriodoPPP()){
								%>
                              			<option selected="true" value="<%=p.getIdperiodoppp()%>"><%=p.getDescripcion()%> </option>
                              			
                              		<%
                              			}else{
                              		%>
                              			<option value="<%=p.getIdperiodoppp()%>"><%=p.getDescripcion()%> </option>
                                	   <%
                              			}
                              		}
                              	   %>
							</select>
							<div>
							    <a href="https://github.com/danielfarrell/bootstrap-combobox"></a>
							 </div>		
						    </div>
						  
						  						
						<label class="col-sm-2 control-label text-rpromedix">Nivel180:</label>
								    <div class="col-sm-6">
								      <select id="idnivel" name="idnivel"class="form-control" required>
								      <%
								        DTNivel dtn = new DTNivel();
										ArrayList<VW_nivel> listaNiveles = new ArrayList<VW_nivel>();
										listaNiveles = dtn.listarNiveles();
										for(VW_nivel n : listaNiveles){
											if(n.getIdNivel()==pa.getIdNivel()){
										%>
                                			<option selected="true" value="<%=n.getIdNivel()%>"><%=n.getDescripcion()%> </option>
                                			
                                		<%
                                			}else{
                                		%>
                                			<option value="<%=n.getIdNivel()%>"><%=n.getDescripcion()%> </option>
                                  	   <%
                                			}
                                		}
                                	   %>	        
								      </select>
								      <div>
									    <a href="https://github.com/danielfarrell/bootstrap-combobox"></a>
									  </div>
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

</body>
</html>