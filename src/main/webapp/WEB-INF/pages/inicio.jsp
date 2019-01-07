<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Montenes Tech</title>

	<style>
	.error {
		color: red;
		font-weight: bold;
	}
	</style>

</head>
<body>
	<h1>Página inicial do sistema</h1>

	<s:form action="${pageContext.request.contextPath }/salvar"
		method="post" modelAttribute="cliente_form">
		<table>
			<tr>
				<td><label id="cliente_nome" for="nome">Nome</label></td>

				<td>
					<s:input path="nome" /> 
				</td>
				<td>
					<s:errors path="nome" cssClass="error" />
				</td>	
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="Salvar" /></td>
			</tr>

		</table>
	</s:form>

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