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
    	
      <form class="row" method="post" onsubmit="return validate();" action="/doanhnghiep/blog/sua" enctype="multipart/form-data">
            <h3 style="color: rgb(6, 109, 70)" class="mb-5 mt-4">Sửa blog</h3>

            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label">Tiêu đề<span class="required"> *</span></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="title" name="txtTieuDe" required="required" value="${blog.getTieuDe() }"/>
                </div>
            </div>
            <div class="row mb-3">
                <label for="writer" class="col-sm-2 col-form-label">Tác giả<span class="required"> *</span></label>
                <div class="col-sm-10">
                    <input type="text" id="writer" class="form-control"  name="txtTacGia" value="${blog.getTacGia() }" required="required"></input>
                </div>
            </div>
            <div class="row mb-3">
                <label for="image" class="col-sm-2 col-form-label">Hình ảnh<span class="required">
                        (chọn nếu muốn thay đổi)</span></label>
                <div class="col-sm-10">
                    <input class="form-control" type="file" id="image" name="imgAnh" />
                </div>
            </div>
            
            <div class="row mb-3">
                <label for="content" class="col-sm-2 col-form-label">Nội dung<span class="required">
                        *</span></label>
                <div class="col-sm-10">
                    <textarea id="content" class="form-control" name="txtNoiDung" rows="3" required="required">${blog.getNoiDung() }</textarea>
                </div>
            </div>
            
            <div class="row mb-3">
                <div class="col-sm-10 offset-sm-2">
                    <button type="submit" class="btn btn-primary">Sửa</button>
                </div>
            </div>
            <input type="hidden" name="id" value="${blog.getMaBlog() }"/>
            <input type="hidden" name="anh" value="${blog.getAnh() }"/>
        </form>
    </div>
    
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    <script>
    CKEDITOR.replace ('content');
    CKEDITOR.config.height = '1000px';
	CKFinder.setupCKEditor(null,'/libraries/ckfinder/');
	function validate(){
    	var kt = confirm("Chỉnh sửa blog sẽ tốn một khoảng thời gian để duyệt. \n\nBạn có chắc chắn muốn chỉnh sửa?");
    	return kt;
    };
    </script>

</body>
</html>