<%-- 
    Document   : adicionarCategoria
    Created on : 02/05/2016, 08:20:36
    Author     : Ada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Adicionar Categoria</h1>
        <form action="<c:url value='/adicionarCategoria'/>" method="post"> 
            Descrição
            <br>
            <input type="text" name="descricao"/>
            <input type="submit" name="btnSalvar" value="Salvar"/>
        </form>
    </body>
</html>
