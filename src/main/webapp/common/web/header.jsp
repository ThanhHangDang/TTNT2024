<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="#!">BK Shop</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#!">Home</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="#!">Tất cả sản phẩm</a></li>
						<li><hr class="dropdown-divider" /></li>
						<li><a class="dropdown-item" href="#!">Quần áo bóng đá</a></li>
						<li><a class="dropdown-item" href="#!">Giày bóng đá</a></li>
						<li><a class="dropdown-item" href="#!">Găng tay thủ môn</a></li>
						<li><a class="dropdown-item" href="#!">Phụ kiện bóng đá</a></li>
						<li><a class="dropdown-item" href="#!">Bóng thi đấu</a></li>
					</ul></li>
					
				<c:if test="${not empty USERMODEL}">
					<li class="nav-item"><a class="nav-link" href='#'>Welcome, ${USERMODEL.fullName}</a></li>
					<li class="nav-item"><a class="nav-link" href='<c:url value="/thoat?action=logout"/>'>Thoát</a></li>
				</c:if>
				<c:if test="${empty USERMODEL}">
					<li class="nav-item"><a class="nav-link" href='<c:url value="/dang-nhap?action=login"/>'>Đăng nhập</a></li>
				</c:if>
			</ul>
			<form class="d-flex">
				<button class="btn btn-outline-dark" type="submit">
					<i class="bi-cart-fill me-1"></i> Cart <span
						class="badge bg-dark text-white ms-1 rounded-pill">0</span>
				</button>
			</form>
		</div>
	</div>
</nav>