<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<title>${title }</title>
	<jsp:include page="/WEB-INF/pages/layout/header.jsp" />
</head>
<body>
    <div class="bg">
    <jsp:include page="/WEB-INF/pages/layout/navbar.jsp" />
    <div style="height:70px;">
    </div>
    <div class="container">
      <form class="row" method="post" onsubmit="return confirm("Chỉnh sửa quảng bá sẽ tốn một khoảng thời gian để chờ duyệt. \n\nBạn có chắc chắn muốn chỉnh sửa ?");" action="/doanhnghiep/quangba/sua" enctype="multipart/form-data">
            <h3 style="color: rgb(6, 109, 70)" class="mb-5 mt-4">Sửa bài quảng bá</h3>

            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label">Tiêu đề<span class="required"> *</span></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="title" name="txtTieuDe" required="required" value="${quangBa.getTieuDe() }"/>
                </div>
            </div>
            <div class="row mb-3">
                <label for="content" class="col-sm-2 col-form-label">Nội dung đại diện<span class="required">
                        *</span></label>
                <div class="col-sm-10">
                    <textarea id="content" class="form-control" name="txtNoiDung" rows="3" required="required"  >${quangBa.getNoiDungDaiDien() }</textarea>
                </div>
            </div>
            <div class="row mb-3">
                <label for="image" class="col-sm-2 col-form-label">Hình ảnh đại diện (Chọn ảnh mới nếu muốn thay đổi)</label>
                <div class="col-sm-10">
                    <input class="form-control" type="file" id="image" name="imgAnhDaiDien" value="${contextPath }/${quangBa.getHinhAnhDaiDien() }"/>
                </div>
            </div>
            <div class="row mb-3">
                <label for="post" class="col-sm-2 col-form-label">Bài viết<span class="required"> *</span></label>
                <div class="col-sm-10">
                    <textarea id="post" class="form-control"  name="txtBaiViet" required="required" >${quangBa.getBaiViet() }</textarea>
                	
                </div>
                
            </div>
            <div style="visibility: hidden;">
            	<input class="form-control" type="text" name="txtMaQuangBa" value="${quangBa.getMaQuangBa() }"/>
            </div>
            <div class="row mb-3">
                <div class="col-sm-10 offset-sm-2">
                	<a  class="btn btn-danger" href="/doanhnghiep/quangba/chitiet?id=${quangBa.getMaQuangBa() }">Huỷ</a>
                    <button type="submit" class="btn btn-primary">Sửa</button>
                </div>
            </div>
        </form>
    </div>
    
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
				<script>
                	
                	
				CKEDITOR.replace ('post');
		        CKEDITOR.config.height = '1000px';
				CKFinder.setupCKEditor(null,'/libraries/ckfinder/');
			    </script>
</body>
</html>