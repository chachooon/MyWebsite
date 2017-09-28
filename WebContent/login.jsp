<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>


<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>로그인</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
<%-- <% 	String email="", pwd="", error="";
	String target = request.getParameter("target");
	String remember = request.getParameter("keepID");
 	String keepLogin = request.getParameter("keepLogin");
	session = request.getSession(); 
%>
<% 	
	Cookie[] cookies = request.getCookies();	
	if(cookies != null && cookies.length>0) 
		for(int i=0;i<cookies.length;i++)
			if(cookies[i].getName().equals("email"))
				email =cookies[i].getValue();
%> --%>
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
       	
       	<form action="/LoginActions" method="post">
     	<% 	String remember = request.getParameter("keepID"); 
     		String email="",pwd="", error="";
     		
     		Cookie[] cookies = request.getCookies();	
     		if(cookies != null && cookies.length>0) 
     			for(int i=0;i<cookies.length;i++)
     				if(cookies[i].getName().equals("email"))
     					email = cookies[i].getValue();
     	%> 
     	<input type="hidden" name="target" value="http://www.naver.com" />
         <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
		<%if(email.length()>0){ %>
            <input class="form-control" id="exampleInputEmail1" name="email" type="email" value="<%=email%>" aria-describedby="emailHelp" placeholder="Enter email">
        	<% }else{ %> 
         	<input class="form-control" id="exampleInputEmail1" name="email" type="email" value="" aria-describedby="emailHelp" placeholder="Enter email">
      	<% } %> 
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input class="form-control" id="exampleInputPassword1" name="pwd" type=password value="" placeholder="Password">
          </div>
          <div class="form-group">
            <div class="form-check">
              
           	<%if(email.length()>0){ %>
               	<label class="form-check-label">
                <input class="form-check-input" name="keepID" type="checkbox" value="keepID"> Remember Password</label>
             <% }else{ %>
                <label class="form-check-label">
                <input class="form-check-input" name="keepID" type="checkbox" value="keepID" checked> Remember Password</label>
            <% } %>
            </div>
          </div>
        <input class="btn btn-primary btn-block" type=submit name="LogIn" value="Login"> 
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="register.jsp">Register an Account</a>
         <!--  <a class="d-block small" href="#">Forgot Password?</a> -->
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/popper/popper.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>



