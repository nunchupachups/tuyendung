<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>${title }</title>
	<jsp:include page="/WEB-INF/pages/layout/header.jsp" />
	<script>
		$(document).ready(function(){
			$('#myModal').modal('show');
		});
		
	</script>
</head>
<body>


	<c:if test="${sessionScope.sinhvien!=null }">
		<c:if test="${!sessionScope.sinhvien.isDaDuyet() }">
				<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">


      <!-- Modal body -->
      <div class="modal-body">
        Cho phép trang web sử dụng công khai thông tin cá nhân và kết quả học tập của bạn?
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      	<a class="btn btn-primary" href="/sinhvien/updatethongtin">OK</a>
      	<!-- them thong tin ca nhan va diem cua sv, tao cv -->
        <a class="btn btn-danger" href="/sinhvien/dangxuat">NO</a>
      </div>

    </div>
  </div>
</div>
					
		</c:if>
	</c:if>
    <div class="bg">
    <jsp:include page="/WEB-INF/pages/layout/navbar.jsp" />
    <div style="height:70px;">
    </div>
    <div class="container">
    	<c:if test="${msgCapNhat!=null }">
      			<div class="alert alert-danger alert-dismissible mt-3">
      			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      				<a href="/sinhvien/updatethongtin">${msgCapNhat } </a>
      			</div>
    	</c:if> 
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
    </div>
	
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
</body>
</html>