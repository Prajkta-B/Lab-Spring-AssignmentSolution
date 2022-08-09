<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Student Data</title>
</head>

<body>

	<div class="container">

		<h3>Student Data</h3>
		<hr>

		<p class="h4 mb-4">Enter Student</p>

		<form action="/Lab6-Solution/studentData/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${StudentDetails.id}" />

			<div class="form-inline">
				<input type="text" name="firstname" value="${StudentDetails.firstname}"
					class="form-control mb-4 col-4" placeholder="FirstName">
			</div>
			
			<div class="form-inline">
				<input type="text" name="lastname" value="${StudentDetails.lastname}"
					class="form-control mb-4 col-4" placeholder="LastName">
			</div>

			<div class="form-inline">
				<input type="text" name="course" value="${StudentDetails.course}"
					class="form-control mb-4 col-4" placeholder="Course">
			</div>

			<div class="form-inline">
				<input type="text" name="country" value="${StudentDetails.country}"
					class="form-control mb-4 col-4" placeholder="country">
			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/Lab6-Solution/studentData/list">Back to Student List</a>

	</div>
</body>

</html>










