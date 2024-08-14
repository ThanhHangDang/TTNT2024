<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-product"/>
<c:url var="Producturl" value="/admin-product"/>
<html>
<head>
    <title>Chỉnh sửa bài viết </title>
</head>
<body>
    <div class="row">
        <div class="col-xs-12">
            <c:if test="${not empty message}">
                <div class="alert alert-${alert}">
                    ${message}
                </div>
            </c:if>
            <form id="formSubmit">
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                    <div class="col-sm-9">
                        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" id="type" name="type">
                            <c:if test="${empty model.type}">
                                <option value="">Chọn loại sản phẩm</option>
                                <option value="shoe">Giày thể thao</option>
                                <option value="ball">Bóng thể thao</option>
                                <option value="clothes">Quần áo thể thao</option>
                                <option value="goalkeeper">Găng tay thủ môn</option>
                                <option value="accessories">Phụ kiện thể thao</option>
                            </c:if>
                            <c:if test="${not empty model.type}">
                                <option value="">Chọn loại sản phẩm</option>
                                <option value="shoe" <c:if test='${item.type == "shoe"}'>selected="selected"</c:if>>
                                            Giày thể thao
                                </option>
                                <option value="ball" <c:if test='${item.type == "ball"}'>selected="selected"</c:if>>
                                            Bóng thể thao
                                </option>
                                <option value="clothes" <c:if test='${item.type == "clothes"}'>selected="selected"</c:if>>
                                            Quần áo thể thao
                                </option>
                                <option value="goalkeeper"  <c:if test='${item.type == "goalkeeper"}'>selected="selected"</c:if>>
                                            Găng tay thủ môn
                                </option>
                                <option value="accessories" <c:if test='${item.type == "accessories"}'>selected="selected"</c:if>>
                                            Phụ kiện thể thao
                                </option>
                                
                            </c:if>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">Name</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="title" name="name" value="${model.name}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">Giá</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="thumbnail" name="price" value="${model.price}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">Số lượng</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="thumbnail" name="quantity" value="${model.quantity}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">Mô tả</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="description" name="description" value="${model.description}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">Hình ảnh</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="content" name="image" value="${model.image}" />
                    </div>
                </div>
                <div class="form-group">

                    <div class="col-sm-12">
                        <c:if test="${not empty model.id}">
                            <input type="button" class="btn btn-white btn-warning" id="btnAddOrUpdateNew" value="Cập nhật sản phẩm" />
                        </c:if>
                        <c:if test="${empty model.id}">
                            <input type="button" class="btn btn-white btn-warning" id="btnAddOrUpdateNew" value="Thêm sản phẩm" />
                        </c:if>
                    </div>
                </div>
                <input type="hidden" id="id" value="${model.id}" name="id"/>
            </form>
        </div>
    </div>

    <script>
        $('#btnAddOrUpdateNew').click(function (e) {
            e.preventDefault();
            var data = {};
            var formData = $('#formSubmit').serializeArray();
            $.each(formData, function (index, value) {
                data[""+value.name+""] = value.value;
            });
            var id = $('#id').val();
            if(id == ""){
                addNews(data);
            }
            else {
            	console.log(data);
                updateNews(data);
            }
        });

        function addNews (data){
            $.ajax({
                url: '${APIurl}',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    console.log(result);
                    window.location.href = "${Producturl}?type=list&maxPageItem=10&page=1&sortName=name&sortBy=desc";
                    alert('Thêm sản phẩm thành công!');
                },
                error: function (error){
                    console.log(error);
                    alert('Thêm sản phẩm thất bại!');
                }
            });
        }

        function updateNews (data){
            $.ajax({
                url: '${APIurl}',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    console.log(result);
                    alert('Cập nhật sản phẩm thành công!');
                },
                error: function (error){
                    console.log(error);
                    alert('Cập nhật sản phẩm thất bại!');
                }
            });
        }
    </script>
</body>
</html>
