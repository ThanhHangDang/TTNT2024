<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="#">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">
			Trang Chủ <sup>2</sup>
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item active"><a class="nav-link" href='<c:url value="/admin-product?type=list&page=1&maxPageItem=10&sortName=name&sortBy=desc"/>'>
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Quản lý sản phẩm</span>
	</a></li>
	
	<li class="nav-item active"><a class="nav-link" href='<c:url value="/admin-product?type=list&page=1&maxPageItem=10&sortName=name&sortBy=desc"/>'>
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Quản lý đơn hàng</span>
	</a></li>
	
	<li class="nav-item active"><a class="nav-link" href='<c:url value="/admin-product?type=list&page=1&maxPageItem=10&sortName=name&sortBy=desc"/>'>
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Quản lý người dùng</span>
	</a></li>
	
	<li class="nav-item active"><a class="nav-link" href='<c:url value="/admin-product?type=list&page=1&maxPageItem=10&sortName=name&sortBy=desc"/>'>
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Lịch sử và thống kê</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>


</ul>
<!-- End of Sidebar -->