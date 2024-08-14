<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="APIurl" value="/api-admin-news"/>
<c:url var="Newsurl" value="/admin-news"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài viết</title>
</head>
<body>
	
	<div class="row">
		<div class="mb-3">
			<a title="Thêm bài viết" href='<c:url value="/admin-news?type=edit"/> '>
				<button class="btn btn-success">Thêm Bài Viết</button>
			</a>
			<button title="Xóa bài viết" id="btnDelete" class="btn btn-danger">Xóa Bài Viết</button>
		</div>

		<form action="<c:url value='/admin-news'/>" method="get" id="formSubmit">
			<table class="table table-hover">
				<thead>
				  <tr>
					<th><input type="checkbox" id="checkAll"/></th>
					<th scope="col">ID</th>
					<th scope="col">Tên bài viết</th>
					<th scope="col">Mô tả ngắn</th>
					<th scope="col">Thao tác</th>
				  </tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${model.listResult}">
						<tr>
							<td><input type="checkbox" id="checkbox_${item.id}"/></td>
							 <th scope="row">${item.id}</th>
							<td>${item.title}</td>
							<td>${item.shortDescription}</td>
							<td>
								<c:url var="editURL" value="/admin-news">
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
	
			<ul class="pagination" id="pagination"></ul>
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
		var limit = 2;
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
						$("#sortName").val('title');
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
				return $(this).val();
			}).get();
			data['ids'] = ids;
			deleteNews(data);
		});
		function deleteNews (data){
			$.ajax({
				url: '${APIurl}',
				type: 'DELETE',
				contentType: 'application/json',
				data: JSON.stringify(data),
				success: function (result) {
					window.location.href = "${Newsurl}?type=list&maxPageItem=2&page=1";
				},
				error: function (error){
					console.log(error);
				}
			});
		}
	</script>
</body>
</html>