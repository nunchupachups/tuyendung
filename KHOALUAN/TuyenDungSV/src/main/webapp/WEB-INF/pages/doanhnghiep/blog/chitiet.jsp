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
    <c:if test="${sessionScope.doanhnghiep!=null&&sessionScope.doanhnghiep.getMaDoanhNghiep()==blog.getMaDoanhNghiep() }">
    <div class="dropdown" style="position: absolute; top:0; right:60px;">
          <button style="padding-top: 0;" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
            <h1>...</h1>
          </button>
          <ul class="dropdown-menu">
          	<li>
			      <form action="/doanhnghiep/blog/xoa" onsubmit="return xoa()" method="get">
			            <input type="hidden" value="${blog.getMaBlog() }" name="id"/>
			            <input class="dropdown-item" type="submit" value="Xoá"/>
			      </form>
			</li>
            <li><a class="dropdown-item" href="/doanhnghiep/blog/sua?id=${blog.getMaBlog() }">Sửa</a></li>
          </ul>
        </div>
        </c:if>
	<c:if test="${blog!=null }">
	<div style="text-align: center;margin-bottom: 20px;">
		<h1>${blog.getTieuDe() }</h1>
		<span>${blog.getNgayDang() }</span>
	</div>
		
		<div style="text-align: justify;">${blog.getNoiDung() }</div>
		<small style="float: right; font-weight: bold;">${blog.getTacGia() }</small>
	</c:if>
    </div>
    
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    <script>
    function xoa(){
		var kt = confirm("Bạn có chắc chắn muốn xoá bài tuyển dụng này?");
    	return kt;
    	
	};
    </script>
</body>
</html>