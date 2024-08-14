<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="APIurl" value="/api-admin-product"/>
<c:url var="Producturl" value="/admin-product"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách sản phẩm</title>
</head>
<body>
	
	<div class="row">
		<div class="mb-3">
			<a title="Thêm bài viết" href='<c:url value="/admin-product?type=edit"/> '>
				<button class="btn btn-success">Thêm sản phẩm</button>
			</a>
			<button title="Xóa bài viết" id="btnDelete" class="btn btn-danger">Xóa sản phẩm</button>
		</div>

		<form action="<c:url value='/admin-product'/>" method="get" id="formSubmit">
			<table class="table table-hover">
				<thead>
				  <tr>
					<th><input type="checkbox" id="checkAll"/></th>
					<th scope="col">ID</th>
					<th scope="col">Tên Sản phẩm</th>
					<th scope="col">Loại</th>
					<th scope="col">Số lượng</th>
					<th scope="col">Mô tả</th>
					<th scope="col">Hình ảnh</th>
					<th scope="col">Giá</th>
					<th scope="col">Tác vụ</th>
				  </tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${model.listResult}">
						<tr>
							<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}" /></td>
							 <td>${item.id}</td>
							<td>${item.name}</td>
							<td>${item.type}</td>
							<td>${item.quantity}</td>
							<td>${item.description}</td>
							<td><img src="${item.image}" alt='...' style='height:40px; width: 40px;'></td>
							<td>${item.price}</td>
							<td>
								<c:url var="editURL" value="/admin-product">
									<c:param name="type" value="edit" />
									<c:param name="id" value="${item.id}"/>
								</c:url>
								<a type="button" class="btn btn-primary" title="Cập nhật bài viêt" href="${editURL}" id="a">
									Sửa
								</a>
							</td>
					    </tr>
					</c:forEach>
				</tbody>
			</table>
	
			<ul class="pagination d-flex justify-content-center" id="pagination"></ul>
			<input type="hidden" id="page" value="" name="page"/>
			<input type="hidden" id="maxPageItem" value="" name="maxPageItem"/>
			<input type="hidden" id="sortName" value="" name="sortName"/>
			<input type="hidden" id="sortBy" value="" name="sortBy"/>
			<input type="hidden" id="type" value="" name="type"/>
		</form>
	</div>
	<script type="text/javascript">
		var totalPage = ${model.totalPage};
		var currentPage = ${model.page};
		var visiblePages = ${model.maxPageItem};
		var limit = 10;
		$(function () {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: totalPage,
				visiblePages: 10,
				startPage: currentPage,
				onPageClick: function (event, page) {
					/* console.info(page + ' (from options)'); */
					if(currentPage != page){
						$("#maxPageItem").val(limit);
						$("#page").val(page);
						$("#sortName").val('name');
						$("#sortBy").val('desc');
						$("#type").val('list');
						$('#formSubmit').submit();
					}
				}
			});
		});

		$("#btnDelete").click(function () {
			var data = {};
			var ids = $('tbody input[type=checkbox]:checked').map(function () {
				console.log($(this));
				return $(this).val();
	        }).get();
			data['ids'] = ids;
			console.log(data);
			deleteNews(data);
		});
		function deleteNews (data){
			$.ajax({
				url: '${APIurl}',
				type: 'DELETE',
				contentType: 'application/json',
				data: JSON.stringify(data),
				success: function (result) {
					window.location.href = "${Producturl}?type=list&maxPageItem=10&page=1&sortName=name&sortBy=desc";
					alert('Xóa sản phẩm thành công!');
				},
				error: function (error){
					console.log(error);
				}
			});
		}
	</script>
</body>
</html>