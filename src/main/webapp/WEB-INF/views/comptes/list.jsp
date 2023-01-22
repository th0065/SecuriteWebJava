<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
 <title>Comptes</title>
 <style><%@include file="/style.css"%></style>

</head>
<body>

 <center>
  <h1>Gestion des comptes</h1>
 </center>
    <div class="container">

                <div class="btn btn-group" role="group">
            <a href="compte?param=add" class="btn btn-primary glow-on-hover">Ajouter un nouveau compte</a><br>
            <a href="droit" class="btn btn-success glow-on-hover">Gestion des droits</a>
            </div>
        <table class="table table-sm table-bordered">
            <thead class="thead-dark">
                <th>ID</th>
                <th>Username</th>
                <th>Password</th>
                <th>Actions</th>
            </thead>
            <c:forEach var="compte" items="${listCompte}">
                <tr class="group/item  hover:bg-slate-100 ...">
                    <td><c:out value="${compte.id}" /></td>
                    <td><c:out value="${compte.username}" /></td>
                    <td><c:out value="${compte.password}" /></td>
                    <td style="display:flex;">
                   <a href="compte?idM=<c:out value="${compte.id}" />" class="btn btn-sm btn-info glow-on-hover">Modifier</a><br>
                   <a href="compte?idS=<c:out value="${compte.id}" />" class="btn btn-sm btn-danger glow-on-hover">Supprimer</a><br>

                    </td>

                </tr>
            </c:forEach>
        </table>

                        <a href="logout" class="btn btn-danger ">Se deconnecter</a>

    </div>

</body>
</html>
