<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-news"/>
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
                        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" id="categoryCode" name="categoryCode">
                            <c:if test="${empty model.categoryCode}">
                                <option value="">Chọn loại bài viết</option>
                                <c:forEach var="item" items="${categories}">
                                    <option value="${item.code}">${item.name}</option>
                                </c:forEach>
                            </c:if>
                            <c:if test="${not empty model.categoryCode}">
                                <option value="">Chọn loại bài viết</option>
                                <c:forEach var="item" items="${categories}">

                                    <option value="${item.code}" selected="selected" <c:if test="${item.code == model.categoryCode}">selected="selected"</c:if>>
                                            ${item.name}
                                    </option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="title" name="title" value="${model.title}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="thumbnail" name="thumbnail" value="" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="shortDescription" name="shortDescription" value="${model.shortDescription}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right">Nội dung</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="content" name="content" value="${model.content}" />
                    </div>
                </div>
                <div class="form-group">

                    <div class="col-sm-12">
                        <c:if test="${not empty model.id}">
                            <input type="button" class="btn btn-white btn-warning" id="btnAddOrUpdateNew" value="Cập nhật bài viết" />
                        </c:if>
                        <c:if test="${empty model.id}">
                            <input type="button" class="btn btn-white btn-warning" id="btnAddOrUpdateNew" value="Thêm bài viết" />
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
            // var title = $('#title').val();
            // var categoryCode = $('#categoryCode').val();
            // var shortDescription = $('#shortDescription').val();
            // var thumbnail = $('#thumbnail').val();
            // var content = $('#content').val();
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
                },
                error: function (error){
                    console.log(error);
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
                },
                error: function (error){
                    console.log(error);
                }
            });
        }
    </script>
</body>
</html>
