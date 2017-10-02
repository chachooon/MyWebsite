<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>차정윤 :: Post List</title>

<!-- Bootstrap core CSS -->
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="/css/clean-blog.min.css" rel="stylesheet">

</head>

<body>
	<!-- Navigation -->
	<%@ include file="/nav.jspf"%>

	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('/img/home-bg.jpg')">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="site-heading">
						<h1>Post List</h1>
						<!-- <span class="subheading">어서오세용 천천히 둘러보세용</span> -->
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<!-- 최근게시글 -->
			<div class="col-lg-8 col-md-10 mx-auto">
				<%for(int i=0; i<10; i++){%> 
				<div class="post-preview">
					<a href="post.html">
						<h2 class="post-title">Post 게시글의 제목입니다.</h2>
						<h4 class="post-subtitle">읽기는 누구나 가능 쓰는것은 아무나 못씀.</h4>
					</a>
					<p class="post-meta">
						Posted by <a href="#">작성자명</a> on September 24, 2017<br>
						<span class="tag">
							<%for(int t=0; t<3; t++){%> <a href="#">tag</a><%} %>
						</span>
					</p>
				</div>
				<hr>
				<% } %>
				<!-- Pager -->
				<div class="clearfix">
					<a class="btn btn-secondary float-right" href="#">Older Posts &rarr;</a>
				</div>
			</div>
		</div>
	</div>

	<hr>

	<!-- Footer -->
	<%@ include file="/footer.jspf"%>

	<!-- Bootstrap core JavaScript -->
	<script src="/vendor/jquery/jquery.min.js"></script>
	<script src="/vendor/popper/popper.min.js"></script>
	<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="/js/clean-blog.min.js"></script>

</body>

</html>
