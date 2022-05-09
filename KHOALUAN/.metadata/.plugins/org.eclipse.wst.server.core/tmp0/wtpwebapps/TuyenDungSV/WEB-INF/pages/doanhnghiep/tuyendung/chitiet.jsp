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
    
   <h4 style="margin-bottom: 30px ;color: green;border-left: green solid 5px;padding-left: 10px;">Chi tiết tin tuyển dụng</h4>
        	<div class="tuyendung" style="position: relative;">
		        <div class="tuyendung-container">
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
		        <div class="dropdown tuyendung-dropdown">
		            <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
		                <h1>...</h1>
		            </button>
		            <ul class="dropdown-menu">
		                <li><a class="dropdown-item" href="/doanhnghiep/tuyendung/xoa?id=${tuyenDung.getMaTuyenDung() }">Xoá</a></li>
		                <li><a class="dropdown-item" href="/doanhnghiep/tuyendung/sua?id=${tuyenDung.getMaTuyenDung() }">Sửa</a></li>
		            </ul>
		        </div>
		        <div style="position: absolute;bottom: 15px;right: 50px;">
		        	
		        	<c:if test="${tuyenDung.isDaDuyet()}">
		            	<button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#myModal${tuyenDung.getMaTuyenDung() }">${dangKyTuyenDungDAO.getDangKyByMaTuyenDung(tuyenDung.getMaTuyenDung()).size()} người đã đăng ký</button>
		        	</c:if>
		        	<c:if test="${!tuyenDung.isDaDuyet()}">
		            	<button class="btn btn-danger">Chưa được duyệt</button>
		        	</c:if>
		        </div>
		
		        <!-- The Modal -->
		        <div class="modal" id="myModal${tuyenDung.getMaTuyenDung() }">
		            <div class="modal-dialog">
		                <div class="modal-content">
		
		                    <!-- Modal Header -->
		                    <div class="modal-header">
		                        <h4 class="modal-title">Danh sách sinh viên ứng tuyển</h4>
		                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
		                    </div>
		
		                    <!-- Modal body -->
		                    <div class="modal-body">
		                    <c:if test="${dangKyTuyenDungDAO.getDangKyByMaTuyenDung(tuyenDung.getMaTuyenDung()).size()==0}">
		                    	<span style="color: #c0c0c0;">Chưa có đăng ký nào</span>
		                    </c:if>
		                    <c:if test="${dangKyTuyenDungDAO.getDangKyByMaTuyenDung(tuyenDung.getMaTuyenDung()).size()>0}">
		                    	<c:forEach items="${dangKyTuyenDungDAO.getDangKyByMaTuyenDung(tuyenDung.getMaTuyenDung())}" var="dk">
		                    		<div style="display: flex;justify-content: space-between;margin-bottom: 10px;align-items: center;" id="dang-ky-${dk.getMaSinhVien() }-${tuyenDung.getMaTuyenDung()}">
		                    			<a style="text-decoration: none; font-weight: bold;" href="/sinhvien/CV/id?id=${dk.getMaSinhVien() }">${sinhVienDAO.getSinhVienByMaSinhVien(dk.getMaSinhVien()).getHoVaTen() }</a><hr>
		                    			<c:if test="${dangKyTuyenDungDAO.getDangKyByMaSinhVienAndMaTuyenDung(dk.getMaSinhVien(), tuyenDung.getMaTuyenDung()).isDaDuyet() }">
		                    				<button type="button" class="btn btn-success" >Đã duyệt</button>
		                    			</c:if>
		                    			<c:if test="${!dangKyTuyenDungDAO.getDangKyByMaSinhVienAndMaTuyenDung(dk.getMaSinhVien(), tuyenDung.getMaTuyenDung()).isDaDuyet() }">
		                    				<button type="button" class="btn btn-primary" onclick="duyetSinhVien('${dk.getMaSinhVien()}','${tuyenDung.getMaTuyenDung() }')">Duyệt</button>
		                    			</c:if>
		                    		</div>
		                    	</c:forEach>
		                    </c:if>
		                    </div>
		
		                    <!-- Modal footer -->
		                    <div class="modal-footer">
		                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
		                    </div>
		
		                </div>
		            </div>
		        </div>
		    </div>
    </div>
	
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    <script>
    function duyetSinhVien(maSV, maTD){
		console.log(maSV);
		console.log(maTD);
		$.ajax({ 
		    type:"post", 
		    url: "/doanhnghiep/tuyendung/duyetsinhvien", 
		    contentType: "application/x-www-form-urlencoded;charset=utf-8",
		    data: {
		    	maSinhVien: maSV,
		    	maTuyenDung: maTD
		    }, 
		    success: function(data) { 
		    	let row = document.getElementById("dang-ky-"+maSV+"-"+maTD);
		    	row.innerHTML = data;
		    },
		})
	};
    </script>
</body>
</html>