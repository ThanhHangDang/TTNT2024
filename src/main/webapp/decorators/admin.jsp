<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ - Admin" /></title>
<!-- Custom fonts for this template-->
<link href="template/admin/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="template/admin/css/sb-admin-2.min.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>

<body id="page-top">
	<div id="wrapper">
		<%@ include file="/common/admin/menu.jsp"%>
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<%@ include file="/common/admin/header.jsp"%>
				
				<div class="container-fluid">
					<dec:body />
				</div>
			</div>
			
			
			<%@ include file="/common/admin/footer.jsp"%>
		</div>
	</div>
	<script src='<c:url value="template/paging/jquery.twbsPagination.js"/>'></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous">
	</script>
	
	<!-- <script src="template/admin/vendor/jquery/jquery.min.js"></script> -->

    <!-- Core plugin JavaScript-->
    <script src="template/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="template/admin/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="template/admin/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="template/admin/js/demo/chart-area-demo.js"></script>
    <script src="template/admin/js/demo/chart-pie-demo.js"></script>
</body>
</html>