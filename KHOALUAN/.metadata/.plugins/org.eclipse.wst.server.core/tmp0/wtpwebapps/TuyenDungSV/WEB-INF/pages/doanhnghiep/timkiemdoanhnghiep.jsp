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
    
    <form action="/doanhnghiep/timkiem" class="row">
    	<div class="col-5">
        	<input type="text" class="form-control" name="txttenDN" placeholder="Nhập tên doanh nghiệp" >
        </div>
       
    	<div class="col-2">
        	<select class="form-select" name="cmbmaTT">
        	
        		<option value="-1">Tất cả tỉnh thành</option>
        		<c:forEach items="${dsTinhThanh }" var="tt">
        		
        			<option value="${tt.getMaTinhThanh()}">${tt.getTenTinhThanh() }</option> 
        		</c:forEach>
                
                
            </select>
        </div> 
        <div class="col-2">
        	<select class="form-select" name="cmbmaLVHD">
        		<option value="-1">Tất cả lĩnh vực hoạt động</option>
                <c:forEach items="${dsLinhVuc }" var="lv">
                	<optgroup title="${lv.getTenLinhVuc() }" label="${lv.getTenLinhVuc() }">
                		<c:forEach items="${linhVucHoatDongCap2DAO.getAllLinhVucHoatDongByIdCap1(lv.getMaLinhVuc()) }" var="lvc1">
                			<option title="${lvc1.getTenLinhVuc() }" value="${lvc1.getMaLinhVuc() }">${lvc1.getTenLinhVuc() }</option>
                		</c:forEach>
                	</optgroup>
        			
        		</c:forEach>
            </select>
        </div>
        <div class="col-2">
        	<select class="form-select" name="cmbmaLHDN">
        		<option value="-1">Tất cả loại hình doanh nghiệp</option>
                <c:forEach items="${dsLoaiHinhDoanhNghiep }" var="lhdn">
        			<option value="${lhdn.getMaLoaiHinhDoanhNghiep() }">${lhdn.getTenLoaiHinhDoanhNghiep() }</option>
        		</c:forEach>
            </select>
        </div> 
        <div class="col-1">
            <button type="submit" class="btn btn-primary"><i class="fas fa-search"></i></button>
        </div>
    </form>
    <hr>
    	<c:if test="${dsdoanhnghiep.isEmpty() }">
    	<h4 style="color: #c0c0c0;">Không có doanh nghiệp nào thoả mãn yêu cầu tìm kiếm</h4>
    	</c:if>
        <c:forEach items="${dsdoanhnghiep }" var="dn">
        	<div class="doanhnghiep">
	            <h5><a href="/doanhnghiep/chitiet?id=${dn.getMaDoanhNghiep() }">${dn.getTenDoanhNghiep() }</a></h5>
	            <div><b> Lĩnh vực hoạt động:</b> <c:if test="${linhVucHoatDongCap2DAO.getLinhVucHoatDongById(dn.getMaLinhVucHoatDong())!=null}">${linhVucHoatDongCap2DAO.getLinhVucHoatDongById(dn.getMaLinhVucHoatDong()).getTenLinhVuc() }</c:if></div>
	            <div><b>Địa chỉ:</b> ${dn.getDiaChiDuong() }, <c:if test="${xaPhuongDAO.getXaPhuongById(dn.getMaXaPhuong())!=null}">${xaPhuongDAO.getXaPhuongById(dn.getMaXaPhuong()).getPathWithType() }</c:if>  </div>
        	</div>
        	
        </c:forEach>
    </div>
	
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
</body>
</html>