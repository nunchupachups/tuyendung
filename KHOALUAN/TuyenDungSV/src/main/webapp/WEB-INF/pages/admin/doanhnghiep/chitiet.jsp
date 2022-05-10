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
    <c:set var="dn" value="${doanhNghiep }"></c:set>
    <div style="height:70px;">
    </div>
    <div class="container">
    	<div style="height:20px;">
    	</div>
        
          <h3 style="color: rgb(6, 109, 70);" class="mb-5">Thông tin doanh nghiệp</h3>
          <div style="margin-left: 40px;">
          <!-- thong tin dang nhap -->
            <h5 style="color: green; border-left: 5px solid green;padding-left: 10px;" class="mb-3">Thông tin đăng nhập</h5>
            <div style="margin-left: 50px;margin-bottom: 30px;">
	            <div class="row mb-3">
	              <div class="col-sm-2 " >Email đăng nhập : </div>
	              <div class="col-sm-10">${dn.getEmailDangNhap() }</div>
	            </div>
            </div>
          <!-- thong tin lien he -->
            <h5 style="color: green; border-left: 5px solid green;padding-left: 10px;" class="mb-3">Thông tin liên hệ</h5>
            <div style="margin-left: 50px;margin-bottom: 30px;">
	            <div class="row mb-3">
	              <div class="col-sm-2 " >Tên người liên hệ : </div>
	              <div class="col-sm-10">${dn.getTenLienHe() }</div>
	            </div>
	            <div class="row mb-3">
	              <div class="col-sm-2 " >Email liên hệ : </div>
	              <div class="col-sm-10">${dn.getEmailLienHe() }</div>
	            </div>
	            <div class="row mb-3">
	              <div class="col-sm-2 " >Điện thoại : </div>
	              <div class="col-sm-10">${dn.getSoDienThoai() }</div>
	            </div>
            </div>
          <!-- thong tin doanh nghiep -->
      
            <h5 style="color: green; border-left: 5px solid green; padding-left: 10px;" class="mb-3">Thông tin doanh nghiệp</h5>
            <div style="margin-left: 50px;margin-bottom: 30px;">
	            <div class="row mb-3">
	              <div class="col-sm-3 " >Tên pháp lý của doanh nghiệp : </div>
	              <div class="col-sm-9">${dn.getTenDoanhNghiep() }</div>
	            </div>
	            <div class="row mb-3">
	              <div class="col-sm-3 " >Mã số thuế : </div>
	              <div class="col-sm-9">${dn.getMaSoThue() }</div>
	            </div>
	            <div class="row mb-3">
	              <div class="col-sm-3 " >Địa chỉ : </div>
	              <div class="col-sm-9">${dn.getDiaChiDuong() }, ${xaPhuongDAO.getXaPhuongById(dn.getMaXaPhuong()).getPathWithType() }</div>
	            </div>
	            <div class="row mb-3">
	              <div class="col-sm-3 " >Lĩnh vực hoạt động : </div>
	              <div class="col-sm-9">${linhVucHoatDongCap2DAO.getLinhVucHoatDongById(dn.getMaLinhVucHoatDong()).getTenLinhVuc() }</div>
	            </div>
	            <div class="row mb-3">
	              <div class="col-sm-3 " >Loại hình doanh nghiệp : </div>
	              <div class="col-sm-9">${loaiHinhDoanhNghiepDAO.getLoaiHinhDoanhNghiepById(dn.getMaLoaiHinhDoanhNghiep()).getTenLoaiHinhDoanhNghiep() }</div>
	            </div>
	          </div>
            <!-- thong tin xac nhan -->
      
            <h5 style="color: green; border-left: 5px solid green; padding-left: 10px;" class="mb-3">Giấy tờ chứng nhận doanh nghiệp</h5>
            <div style="margin-left: 50px;margin-bottom: 30px;">
            	<c:choose>
            	
	            <c:when test="${anh.isEmpty() }">
	            	<h4 style="color: #c0c0c0;">Không có giấy tờ chứng nhận nào</h4>
	            </c:when>
	            <c:otherwise>
	            	<c:forEach items="${anh }" var="a">
	            		<div style="width: 900px; margin-bottom: 20px;">
	            			<img style="width: 100%;" alt="" src="${contextPath }/${a}">
	            		</div>
	            	</c:forEach>
	            </c:otherwise>
	            </c:choose>
	        </div>
       </div>
     
    </div>
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
</body>
</html>