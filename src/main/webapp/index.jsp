<html>

<head>
 <title>Accueil</title>

<style><%@include file="/style.css"%></style>

</head>
<body>

<div class="container" style="width:50%;">
<form  method="post" action='login' >
    <% if(request.getAttribute("error") != null){%>
        <div class="  form-group">

                <span class='text-danger'><%= request.getAttribute("error") %></span>

        </div>
    <%}%>


		<div class="form-group">
		    <label for="username">Username</label>
			<input class="form-control" type='text' name='username' id='username'/>
		</div>
		<div class="form-group">
			 <label for="password">Password</label>
			<input class="form-control" type='password' id='password' name='password'/>
			</div>
			<div class="form-group">
			<input class="btn btn-primary" type='submit' value='Se connecter'/>
		     </div>


</form>
</div>
</body>
</html>
