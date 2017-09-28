<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String id="", pwd="", error="";
	String target = request.getParameter("target");
	String remember = request.getParameter("remember");
	String keepLogin = request.getParameter("keepLogin");
	session = request.getSession(); 
%>
  
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>회원가입</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">

  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
        <form>
          <div class="form-group">
            <label for="exampleInputName">Name</label>
            <input class="form-control" id="exampleInputName" name="name" type="text" aria-describedby="nameHelp" placeholder="Enter name">
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input class="form-control" id="exampleInputEmail1" name="name" type="email" aria-describedby="emailHelp" placeholder="Enter email">
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">Password</label>
                <input class="form-control" id="exampleInputPassword1" name="pwd" type="password" placeholder="Password">
              </div>
              <div class="col-md-6">
                <label for="exampleConfirmPassword">Confirm password</label>
                <input class="form-control" id="exampleConfirmPassword" name="pwdCheck" type="password" placeholder="Confirm password">
              </div>
            </div>
          </div>
          
          <input class="btn btn-primary btn-block" type="submit" name="submit" value="Register"/>
          <input class="btn btn-primary btn-block" type="submit" name="submit" value="Register"/>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="login.jsp">Login Page</a>
          <!-- <a class="d-block small" href="forgot-password.html">Forgot Password?</a> -->
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

<%-- 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/default.css">
<% if(session.getAttribute("userID")==null){ %>
		<title>회원가입</title> 
	</head>
	<body>
	<%@ include file="/header.jspf" %>
		<form action="/RegisterAction" method="post">
			아이디 : <input type="text" name="userID" value="" required/><br>
			비밀번호 : <input type="password" name="pwd" value="" required/><br>
			이 름 : <input type="text" name="userNAME" value="" required/><br>
			이메일 : <input type="text" name="userEMAIL" value="" required/><br>
			<input type="submit" name="submit" value="Join"/><br>
		</form>
<% }else{ %>
		<title>회원정보수정</title> 
	</head>
	<body>
	<%@ include file="/header.jspf" %>
		<form action="/RegisterAction" method="post">
			아이디 : <%=session.getAttribute("userID")%> 
			<input type="hidden" name="userID" value="<%=session.getAttribute("userID")%>" /><br>
			현재 비밀번호 : <input type="password" name="pwd" value="" required/><br>
			새 비밀번호 : <input type="password" name="pwd2" value="" required/><br>
			이 름 : <input type="text" name="userNAME" value="<%=session.getAttribute("name")%>" required/><br>
			이메일 : <input type="text" name="userEMAIL" value="<%=session.getAttribute("email")%>" required/><br>
			<a href=index.jsp">취소</a> 
			<input type="submit" name="submit" value="Update"/> 
			<input type="submit" name="submit" value="Delete"/>
		</form>
		
<% } %>

	</body>
</html>
 --%>





