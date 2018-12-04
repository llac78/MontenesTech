<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Montenes Tech</title>
</head>
<body>
	<h1>Página inicial do sistema! Testando conexão com o BD</h1>

	<c:choose>
		<c:when test="${not empty listaClientes}">
			<table>
				<tr>
					<td><h3>Nome</h3></td>
				</tr>

				<c:forEach var="cliente" items="${listaClientes}">
					<tr>
						<td>${cliente.nome}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>Não há clientes cadastrados.</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>