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
        
          <h3 style="color: rgb(6, 109, 70);" class="mb-5">Thông tin tuyển dụng</h3>
          <div style="margin-left: 40px;">
          <h3>${tuyenDung.getTieuDe() }</h3>
		            <b><i>Ngành nghề: </i></b>${nganhNgheDAO.getNganhNgheByID(tuyenDung.getMaNganhNghe()).getTenNganhNghe() }<br>
		            <b><i>Tên công việc: </i></b>${tuyenDung.getTenCongViec() } <br>
		            <b><i>Hình thức làm việc: </i></b>${hinhThucLamViecDAO.getHinhThucLamViecByID(tuyenDung.getMaHinhThuc()).getTenHinhThuc() }<br>
		            <c:if test="${tuyenDung.getThoiGianThuViec()!=null }">
		            	<b><i>Thời gian thử việc: </i></b>${tuyenDung.getThoiGianThuViec() }<br>
		            </c:if>
		            
		            <c:if test="${tuyenDung.getSinhVienNam()!=0 }">
		            	<b><i>Sinh viên năm: </i></b>${tuyenDung.getSinhVienNam() }<br>
		            </c:if>
		            <c:if test="${tuyenDung.getGioiTinh()!=null }">
		            	<b><i>Giới tính: </i></b>${tuyenDung.getGioiTinh() }<br>
		            </c:if> 
		            <c:choose>
		            	<c:when test="${tuyenDung.getKhuVucTuyenDung()=='00' }">
		            		<span><b><i>Khu vực tuyển: </i></b>Cả nước</span>
		            	</c:when>
		            	<c:otherwise>
		            		<span><b><i>Khu vực tuyển: </i></b>${tinhThanhDAO.getTinhThanhById(tuyenDung.getKhuVucTuyenDung()).getTenTinhThanh() }</span>
		            	</c:otherwise>
		            </c:choose>
		            <br>
		            <b><i>Số lượng: </i></b>${tuyenDung.getSoLuong() }<br>
		            <b><i>Mức lương: </i></b>${tuyenDung.getMucLuong() }<br>
		            <b><i>Hạn đăng ký: </i></b>${tuyenDung.getHanDangKy() }<br>
		            <b><i>MÔ TẢ CÔNG VIỆC</i></b> <br>
		            ${tuyenDung.getMoTaCongViec() }
		            <b><i>YÊU CẦU CÔNG VIỆC</i></b><br>
		            ${tuyenDung.getYeuCauCongViec() }
		            <b><i>QUYỀN LỢI</i></b><br>
		            ${tuyenDung.getQuyenLoi() } 
          </div>
   
     
    </div>
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
</body>
</html>