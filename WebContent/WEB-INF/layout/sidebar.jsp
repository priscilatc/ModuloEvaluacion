<%@page session="true"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
			<img src="./img/logo-UCA-2021-blanco.png" width="60%">
	</a>
	

	<!-- Divider -->
	<hr class="sidebar-divider my-0">


	<!-- Divider -->
	<hr class="sidebar-divider">


	<!-- Nav Item - Pages Collapse Menu -->

	<!-- Nav Item - Utilities Collapse Menu -->
	<!-- Divider -->
	<hr class="sidebar-divider">
	
	<!-- Nav Item - Seguridad-->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseUtilities"
		aria-expanded="true" aria-controls="collapseUtilities"> <i
			class="fas fa-fw fa-wrench"></i> <span>Administración de Seguridad</span>
	</a>
		<div id="collapseUtilities" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Gestiones</h6>
				<a class="collapse-item" href="ListaUsuario.jsp">Gestión de Usuarios</a> <a
					class="collapse-item" href="ListaRol.jsp">Gestión de Roles</a> <a
					class="collapse-item" href="ListaOpcion.jsp">Gestión de Opciones</a>
			</div>
		</div></li>
		
	<!-- Nav Item - Administración de Tutores-->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseTwo"
		aria-expanded="true" aria-controls="collapseTwo"> <i
			class="fas fa-fw fa-wrench"></i> <span>Administración de Tutores</span>
	</a>
		<div id="collapseTwo" class="collapse"
			aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Gestiones</h6>
				<a class="collapse-item" href="ListaDocente.jsp">Gestión de Tutor Academico</a> <a
					class="collapse-item" href="ListaTutorTecnico.jsp">Gestión de Tutor Técnico</a> 
			</div>
		</div></li>
		
	<!-- Nav Item - Administración de Evaluaciones-->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-fw fa-wrench"></i> <span>Administración de Evaluaciones</span>
	</a>
		<div id="collapsePages" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Gestiones</h6>
				<a class="collapse-item" href="ListaEvaluacion.jsp">Gestión de Evaluación</a> 
				<a class="collapse-item" href="ListaNivel.jsp">Gestión de Nivel 180</a> 
				<a class="collapse-item" href="ListaPeriodoPPP.jsp">Gestión de Período</a>
			</div>
		</div></li>
	
	<li class="nav-item">
       <a class="nav-link" href="ControladorAdmin.jsp">
           <i class="fas fa-fw fa-table"></i>
           <span>Mapa de Sitios</span></a>
     </li>
	
	

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

	

</ul>