<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
 <title>Droits</title>
 <style><%@include file="/style.css"%></style>

</head>
<body>
 <center>
  <h1>Gestion des roles</h1>
 </center>
    <div class="container">
            <div class="btn btn-group" role="group">
                <a href="droit?param=add" class="btn btn-primary glow-on-hover">Ajout de rôle</a><br>
                <a href="compte" class="btn btn-success glow-on-hover">Gestion des comptes</a>
            </div>
            <br>
        <table class="table able-sm table-bordered">

            <tr>
                <th>ID</th>
                <th>ROLE</th>
            </tr>
            <c:forEach var="droit" items="${listDroits}">
                <tr>
                    <td><c:out value="${droit.id}" /></td>
                    <td><c:out value="${droit.name}" /></td>
                </tr>
            </c:forEach>
        </table>
             <a href="logout" class="btn btn-danger ">Se deconnecter</a>

    </div>
</body>
</html>
