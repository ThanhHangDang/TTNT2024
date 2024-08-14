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

	<div class="row">
        <h2 class="fw-bold text-center mt-2">ĐĂNG NHẬP</h2>
        <p>
            Nếu bạn chưa tài khoản, xin vui lòng bấm nút "Đăng ký" chuyển qua trang đăng ký.<br/>
        </p>
    </div>
	<form id="formLogin" action="<c:url value='/dang-nhap' />" method="post">
		<c:if test="${not empty message}">
			<div class="alert alert-${alert}" role="alert">
					${message}
			</div>
		</c:if>
        <p>Tên đăng nhập*</p>
        <input type="text" class="form-control" id="userName" name="userName" aria-describedby="emailHelp">
        <p>Password*</p>
        <input type="password" class="form-control" id="password" name="password">
		
		<input type="hidden" value="login" name="action"/>
        <div class="row">
            <div class="col">
                <input type="submit" class="form-control btn btn-outline-danger mt-3 mb-3" name="submit" value="Đăng nhập">
            </div>
        </div>
    </form>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous">
	</script>
</body>
</html>