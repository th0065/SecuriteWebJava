<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
 <title>Ajout de compte</title>
 <style><%@include file="/style.css"%></style>

</head>
<body>

 <center>
  <h1>Création de comptes</h1>

 </center>
    <div class"container ml-5" style="margin-left:27%;">
            <div class="">
                <a href="compte" class="btn btn-success ">Gestion des Comptes</a>
            </div>
        <form method="post" action='compte'  >
            <% if(request.getAttribute("success") != null){%>
                <div class="row form-group">
                    <div class="col-md-6 ">
                        <span class='text-success'><%= request.getAttribute("success") %></span>
                    </div>
                </div>
            <%}%>
            <%if(request.getAttribute("error") != null){%>
                <div class="row form-group">
                    <div class="col-md-6">
                        <span class='text-danger'><%= request.getAttribute("error") %></span>
                    </div>
                </div>
            <%}%>
        	<div class="row form-group ">
        		<div class="col-md-6">
        		<label for="username" >Username</label>
        			<input class="form-control" type='text' name='username' id='username' required/>
        			<label for="password" >Password</label>
        			<input class="form-control" type='password' name='password' id='password' required/>
        			<br>
        			<input  type='submit' class="btn btn-primary" value="Sauvegarder" name='submit'/>
        		</div>
        	</div>
        </form>
    </div>
</body>
</html>
