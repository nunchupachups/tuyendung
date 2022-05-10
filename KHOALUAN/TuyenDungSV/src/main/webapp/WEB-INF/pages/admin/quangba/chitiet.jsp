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
    	<div style="height:20px;">
    	</div>
        
          <h3 style="color: rgb(6, 109, 70);" class="mb-5">Thông tin quảng bá</h3>
          <div style="margin-left: 40px;">
          	<h5 style="color: green; border-left: 5px solid green;padding-left: 10px;" class="mb-3">Tiêu đề</h5>
            <div style="margin-left: 50px;margin-bottom: 30px;">
	            ${quangBa.getTieuDe() }
            </div>
          	<h5 style="color: green; border-left: 5px solid green;padding-left: 10px;" class="mb-3">Nội dung đại diện</h5>
            <div style="margin-left: 50px;margin-bottom: 30px;">
	            ${quangBa.getNoiDungDaiDien() }
            </div>
            <h5 style="color: green; border-left: 5px solid green;padding-left: 10px;" class="mb-3">Hình ảnh đại diện</h5>
            <div style="margin-left: 50px;margin-bottom: 30px;">
	            <div style="width: 900px; margin-bottom: 20px;">
	            	<img style="width: 100%;" alt="" src="${contextPath }/${quangBa.getHinhAnhDaiDien()}">
	            </div>
            </div>
            <h5 style="color: green; border-left: 5px solid green;padding-left: 10px;" class="mb-3">Bài viết</h5>
            <div style="margin-left: 50px;margin-bottom: 30px;">
	            <div style="width:900px;text-align: justify;">${quangBa.getBaiViet() }</div>
            </div>
          		
          </div>
       
     
    </div>
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
</body>
</html>