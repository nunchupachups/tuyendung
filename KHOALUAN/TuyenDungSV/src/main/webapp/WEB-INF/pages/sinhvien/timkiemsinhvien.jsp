<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <div style="height: 15px;"></div>
    <c:if test="${dktc!=null }">
      			<div class="alert alert-success alert-dismissible mt-3">
      			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      				${dktc } 
      			</div>
    </c:if>
    <form action="/sinhvien/timkiem" class="row">
    	<div class="col-5">
        	<input type="text" class="form-control" name="txtKyNang" placeholder="Nhập kỹ năng cần thiết" >
        </div>
       
    	<div class="col-2">
        	<select class="form-select" name="cmbSinhVienNam">
        	
        		<option value="-1">Sinh viên tất cả các năm </option>
        		<option value="1">Năm 1</option> 
        		<option value="2">Năm 2</option> 
        		<option value="3">Năm 3</option> 
        		<option value="4">Năm 4</option> 
        		<option value="5">Năm 5</option> 
                
                
            </select>
        </div> 
        <div class="col-2">
        	<select class="form-select" name="cmbmaNDT">
        		<option value="-1">Tất cả ngành đào tạo</option>
                <c:forEach items="${dsNganhDaoTao }" var="ndt">
                	<option title="${ndt.getTenNganh() }" value="${ndt.getMaNganh() }">${ndt.getTenNganh() }</option>
        		</c:forEach>
            </select>
        </div>
        <div class="col-2">
        	<select class="form-select" name="cmbGPA">
        		<option value="-1">Tất cả điểm</option>
        		<option value="1">Dưới 2.0</option>
        		<option value="2">Từ 2.0 đến 3.0</option>
        		<option value="3">Từ 3.0 trở lên</option>
            </select>
        </div> 
        <div class="col-1">
            <button type="submit" class="btn btn-primary"><i class="fas fa-search"></i></button>
        </div>
    </form>
    <hr>
    	<c:if test="${dssinhvien.isEmpty() }">
    	<h4 style="color: #c0c0c0;">Không có sinh viên nào thoả mãn yêu cầu tìm kiếm</h4>
    	</c:if>
        <c:forEach items="${dssinhvien }" var="sv">
        	<div class="sinhvien">
	            <h5><a href="#">sv.getTenSinhVien() </a></h5>
	            <div><b> Ngành đào tạo:</b> </div>
	            <div><b>GPA:</b> sv.getGPA() </div>
        	</div>
        	
        </c:forEach>
    </div>
	
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
</body>
</html>