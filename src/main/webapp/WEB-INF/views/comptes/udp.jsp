<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
 <title>Mis à jour</title>
 <style><%@include file="/style.css"%></style>

</head>
<body>
<%
    Object id = request.getAttribute("id");
     Object usr = request.getAttribute("usr");
      Object pwd = request.getAttribute("pwd");
%>
 <center>
  <h1>Mis à jour </h1>

 </center>
    <div class="container">
            <div class="float-end">
                <a href="compte" class="btn btn-success ">Comptes</a>
            </div>
        <form method="PUT" action='compte'  >
           	<div class="col-md-6">
           	        		     <input hidden value='<c:out value="${id}" />' type='number' name='id' id='id' />
        		<label for="username" >Username</label>
        			<input class="form-control" value=' <c:out value="${usr}" />'  type='text' name='username' id='username' required/>
        			            <label for="password" >Password</label>
        			<input class="form-control" value='<c:out value="${pwd}" />' type='text' name='password' id='password' required/>
        			<input  type='submit' class="btn btn-primary" name='submit'/>
        		</div>

        </form>
    </div>
</body>
</html>
