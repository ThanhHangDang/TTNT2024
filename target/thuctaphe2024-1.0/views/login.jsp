<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>
<body>

	<form id="formLogin" class="mt-5 col-4" action="<c:url value='/dang-nhap' />" method="post">
		<c:if test="${not empty message}">
			<div class="alert alert-${alert}" role="alert">
					${message}
			</div>
		</c:if>

		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Username</label> 
			<input type="text" class="form-control" id="userName" name="userName" aria-describedby="emailHelp">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label>
			<input type="password" class="form-control" id="password" name="password">
		</div>
		<input type="hidden" value="login" name="action"/>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous">
	</script>
</body>
</html>