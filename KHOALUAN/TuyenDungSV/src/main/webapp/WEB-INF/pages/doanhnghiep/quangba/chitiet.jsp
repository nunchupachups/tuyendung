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
    <div class="container " style="padding: 50px 100px;position: relative;">
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
    <div class="dropdown" style="position: absolute; top:0; right:60px;">
          <button style="padding-top: 0;" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
            <h1>...</h1>
          </button>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/doanhnghiep/quangba/xoa?id=${quangBa.getMaQuangBa() }">Xoá</a></li>
            <li><a class="dropdown-item" href="/doanhnghiep/quangba/sua?id=${quangBa.getMaQuangBa() }">Sửa</a></li>
          </ul>
        </div>
	<c:if test="${quangBa!=null }">
	<div style="text-align: center;">
		<h1>${quangBa.getTieuDe() }</h1>
	</div>
		
		<div style="padding: 40px 100px;text-align: justify;">${quangBa.getBaiViet() }</div>
	</c:if>
    </div>
    
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
</body>
</html>