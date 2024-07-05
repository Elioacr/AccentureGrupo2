<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Registro </title>
		<link rel="stylesheet" href="/css/usuarios.css">
	</head>
	<body>
		<h1> Registro </h1>
		<form:form action="/registrar/usuario" method="POST" modelAttribute="usuario">
			<div>
				<form:label path="nombre">
					Nombre:
				</form:label>
				<form:input path="nombre" type="text" name="nombre"/>
				<form:errors path="nombre"/>
			</div>
			<div>
				<form:label path="apellido">
					Apellido:
				</form:label>
				<form:input path="apellido" type="text" name="apellido"/>
				<form:errors path="apellido"/>
			</div>
			<div>
				<form:label path="correo">
					Correo:
				</form:label>
				<form:input path="correo" type="text" name="correo"/>
				<form:errors path="correo"/>
			</div>
			<div>
				<form:label path="contraseña">
					Contraseña:
				</form:label>
				<form:input path="contraseña" type="password" name="contraseña"/>
				<form:errors path="contraseña"/>
			</div>
			<button>
				Registro
			</button>
		</form:form>
		
		<div class="col-6">
					<h1 class="text-success mt-4"> Login </h1>
					<form:form action="/procesa/login" method="POST" modelAttribute="loginUsuario">
						<div>
							<form:label class="form-label" path="usuarioCorreo">
								Correo:
							</form:label>
							<form:input class="form-control mb-4" path="usuarioCorreo" type="text" name="usuarioCorreo"/>
							<div>
								<form:errors class="alert alert-danger" path="usuarioCorreo"/>
							</div>
						</div>
						<div>
							<form:label class="form-label" path="usuarioContraseña">
								Contraseña:
							</form:label>
							<form:input class="form-control mb-4" path="usuarioContraseña" type="password" name="usuarioContraseña"/>
							<div>
								<form:errors class="alert alert-danger" path="usuarioContraseña"/>
							</div>
						</div>
						<button class="btn btn-success mt-4">
							Login
						</button>
					</form:form>
				</div>
			
		
		<a href="/usuarios"> Volver al inicio </a>
	</body>
</html>