<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex gap-3 mt-5">
		<h2>Your Gold</h2>
		<div>
			<h2 class="border" id="goldCount"><c:out value="${totalGold}" /></h2>
		</div>
	</div>
	<div class="container my-4 d-flex justify-content-around">
		<form action="/formProcess" method="post" class="text-center">
			<div class="form-group">
				<h3>Farm</h3>
				<h4>(earns 10-20 gold)</h4>
				<input name="mission" type="hidden" value="farm">

			</div>
			<button type="submit" class="btn btn-primary">Find Gold!</button>
		</form>
		<form action="/formProcess" method="post" class="text-center">
			<div class="form-group">
				<h3>Cave</h3>
				<h4>(earns 5-10 gold)</h4>
				<input name="mission" type="hidden" value="cave">

			</div>
			<button type="submit" class="btn btn-primary">Find Gold!</button>
		</form>
		<form action="/formProcess" method="post" class="text-center">
			<div class="form-group">
				<h3>House</h3>
				<h4>(earns 2-5 gold)</h4>
				<input name="mission" type="hidden" value="house">

			</div>
			<button type="submit" class="btn btn-primary">Find Gold!</button>
		</form>
		<form action="/formProcess" method="post" class="text-center">
			<div class="form-group">
				<h3>Quest</h3>
				<h4>(earns 0-50 gold)</h4>
				<input name="mission" type="hidden" value="quest">

			</div>
			<button type="submit" class="btn btn-primary">Find Gold!</button>
		</form>
	</div>
	<div class="container">
			<c:forTokens items="${messages}" delims = "|" var = "message">
				<p><c:out value="${ message}"></c:out></p>
			</c:forTokens>
	</div>
</body>
</html>