<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:set var="entry"></c:set>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>

		<div class="bg-light p-4 mb-3 rounded">
			<h1>Usuarios</h1>
		</div>
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Costo</th>
					<th>Duración</th>
					<th>Tipo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itinerarioUser}" var="itinerario">
					<tr>
						<td><strong><c:out
									value="${itinerario.obtenerNombre()}"></c:out></strong></td>
						<td><c:out value="${itinerario.obtenerCosto()}"></c:out></td>
						<td><c:out value="${itinerario.obtenerTiempo()}"></c:out></td>
						<td><c:out value="${itinerario.obtenerTipo()}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</main>

</body>
</html>