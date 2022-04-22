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
    <div style="height: 15px;"></div>
    
    <form action="/doanhnghiep/tuyendung/timkiem" class="row">
    	<div class="col-9">
        	<input type="text" class="form-control" name="txtTieuDe" placeholder="Nhập tiêu đề tuyển dụng" >
        </div>
        <div class="col-1">
            <button type="submit" class="btn btn-primary"><i class="fas fa-search"></i></button>
        </div>
        <div class="col-2">
            <a class="btn btn-primary" href="/doanhnghiep/tuyendung/taotuyendung">Tạo bài tuyển dụng</a>
        </div>
    </form>
    <hr>
    	<c:if test="${dsTuyenDung.isEmpty() }">
    	<h4 style="color: #c0c0c0;">Không có bài tuyển dụng nào</h4>
    	</c:if>
    	
        <c:forEach items="${dsTuyenDung }" var="td">
        	<div class="tuyendung" style="position: relative;">
		        <div class="tuyendung-container">
		            <h3>${td.getTieuDe() }</h3>
		            <b><i>Ngành nghề: </i></b>${nganhNgheDAO.getNganhNgheByID(td.getMaNganhNghe()).getTenNganhNghe() }<br>
		            <b><i>Tên công việc: </i></b>${td.getTenCongViec() } <br>
		            <b><i>Hình thức làm việc: </i></b>${hinhThucLamViecDAO.getHinhThucLamViecByID(td.getMaHinhThuc()).getTenHinhThuc() }<br>
		            <c:if test="${td.getThoiGianThuViec()!=null }">
		            	<b><i>Thời gian thử việc: </i></b>${td.getThoiGianThuViec() }<br>
		            </c:if>
		            
		            <c:if test="${td.getSinhVienNam()!=0 }">
		            	<b><i>Sinh viên năm: </i></b>${td.getSinhVienNam() }<br>
		            </c:if>
		            <c:if test="${td.getGioiTinh()!=null }">
		            	<b><i>Giới tính: </i></b>${td.getGioiTinh() }<br>
		            </c:if> 
		            <b><i>Khu vực tuyển: </i></b>${td.getKhuVucTuyenDung() }<br>
		            <b><i>Số lượng: </i></b>${td.getSoLuong() }<br>
		            <b><i>Mức lương: </i></b>${td.getMucLuong() }<br>
		            <b><i>Hạn đăng ký: </i></b>${td.getHanDangKy() }<br>
		            <b><i>MÔ TẢ CÔNG VIỆC</i></b> <br>
		            ${td.getMoTaCongViec() }
		            <b><i>YÊU CẦU CÔNG VIỆC</i></b><br>
		            ${td.getYeuCauCongViec() }
		            <b><i>QUYỀN LỢI</i></b><br>
		            ${td.getQuyenLoi() } 
		        </div>
		        <div class="dropdown tuyendung-dropdown">
		            <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
		                <h1>...</h1>
		            </button>
		            <ul class="dropdown-menu">
		                <li><a class="dropdown-item" href="/doanhnghiep/tuyendung/xoa?id=${td.getMaTuyenDung() }">Xoá</a></li>
		                <li><a class="dropdown-item" href="/doanhnghiep/tuyendung/sua?id=${td.getMaTuyenDung() }">Sửa</a></li>
		            </ul>
		        </div>
		        <div style="position: absolute;bottom: 15px;right: 50px;">
		        	
		        	<c:if test="${td.isDaDuyet()}">
		            	<button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#myModal">10 người đã đăng ký</button>
		        	</c:if>
		        	<c:if test="${!td.isDaDuyet()}">
		            	<button class="btn btn-danger">Chưa được duyệt</button>
		        	</c:if>
		        </div>
		
		        <!-- The Modal -->
		        <div class="modal" id="myModal">
		            <div class="modal-dialog">
		                <div class="modal-content">
		
		                    <!-- Modal Header -->
		                    <div class="modal-header">
		                        <h4 class="modal-title">Danh sách sinh viên ứng tuyển</h4>
		                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
		                    </div>
		
		                    <!-- Modal body -->
		                    <div class="modal-body">
		                        <a href="">Dương Kiều Trang</a><hr>
		                        Bùi Anh Thư <hr>
		                        Lê Quỳnh Phương
		                    </div>
		
		                    <!-- Modal footer -->
		                    <div class="modal-footer">
		                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
		                    </div>
		
		                </div>
		            </div>
		        </div>
		    </div>
        	
        </c:forEach>
    </div>
	
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
</body>
</html>