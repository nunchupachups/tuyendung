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
    	
       <c:if test="${msg1!=null }">
      			<div class="alert alert-success alert-dismissible mt-3">
      			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      				${msg1 } 
      			</div>
    	</c:if> 
    	<c:if test="${msg2!=null }">
      			<div class="alert alert-danger alert-dismissible mt-3">
      			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      				${msg2 } 
      			</div>
    	</c:if> 
      <form class="row" method="post" action="/doanhnghiep/blog/tao" enctype="multipart/form-data">
            <h3 style="color: rgb(6, 109, 70)" class="mb-5 mt-4">Thêm blog mới</h3>

            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label">Tiêu đề<span class="required"> *</span></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="title" name="txtTieuDe" required="required" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="writer" class="col-sm-2 col-form-label">Tác giả<span class="required"> *</span></label>
                <div class="col-sm-10">
                    <input type="text" id="writer" class="form-control"  name="txtTacGia" required="required"></input>
                </div>
            </div>
            <div class="row mb-3">
                <label for="image" class="col-sm-2 col-form-label">Hình ảnh<span class="required">
                        *</span></label>
                <div class="col-sm-10">
                    <input class="form-control" type="file" id="image" name="imgAnh" required="required" />
                </div>
            </div>
            
            <div class="row mb-3">
                <label for="content" class="col-sm-2 col-form-label">Nội dung<span class="required">
                        *</span></label>
                <div class="col-sm-10">
                    <textarea id="content" class="form-control" name="txtNoiDung" rows="3" required="required"></textarea>
                </div>
            </div>
            
            <div class="row mb-3">
                <div class="col-sm-10 offset-sm-2">
                    <button type="submit" class="btn btn-primary">Thêm</button>
                </div>
            </div>
        </form>
    </div>
    
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    <script>
    CKEDITOR.replace ('content');
    CKEDITOR.config.height = '1000px';
	CKFinder.setupCKEditor(null,'/libraries/ckfinder/');
    </script>

</body>
</html>