<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>${title }</title>
	<jsp:include page="/WEB-INF/pages/layout/header.jsp" />
	<script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>
	<link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">
	<script>
$(document).ready(function(){
  $(".link").on('click', function(event) {
	  console.log("hihi");
    if (this.hash !== "") {
      event.preventDefault();
      var hash = this.hash;
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 800, function(){
        window.location.hash = hash;
      });
    } 
  });
});
</script>
	<style type="text/css">
		.tuyendung-item{
			margin-top: 15px;}
		.tuyendung-item span{
			padding: 5px; 
			background-color: #EDEEF0; 
			margin: 3px; 
			border-radius: 5px;
		}
	</style>
	
</head>
<body>
    <div class="bg">
    <jsp:include page="/WEB-INF/pages/layout/navbar.jsp" />
    <div style="height:70px;">
    </div>
    <div class="container" > 
    <div style="height: 15px;"></div>

        <div  id="tuyendung-item${tuyenDung.getMaTuyenDung() }">
        	<div style="position: relative;padding: 30px;" >
		        <div class="tuyendung-container">
		        	
		            <h3 style="color: green;">${tuyenDung.getTieuDe() }</h3>
		            <a href="/doanhnghiep/chitiet?id=${tuyenDung.getMaDoanhNghiep() }" style="text-decoration: none; color: black;">
		            	<span style="margin-bottom:20px;">${doanhNghiepDAO.getDoanhNghiepById(tuyenDung.getMaDoanhNghiep()).getTenDoanhNghiep().toUpperCase()  }</span>
		            </a>
		            <div style="margin: 5px 0;">
		            	<b><i>Tên công việc : </i></b>${tuyenDung.getTenCongViec() } 
		            </div>    
		        </div>
		        
		        <div style="position: absolute;bottom: 15px;right: 50px;">

		        	<c:choose>
		        		<c:when test="${sessionScope.sinhvien==null }">
		        			<button class="btn btn-success" onclick="alert('Bạn cần phải đăng nhập trước!')">Đăng ký</button>
		        		</c:when>
		        		<c:otherwise>
		        			<c:choose>
		        				<c:when test="${dangKyTuyenDungDAO.getDangKyByMaSinhVienAndMaTuyenDung(sessionScope.sinhvien.getMaSinhVien(), tuyenDung.getMaTuyenDung())==null }">
		        					<button class="btn btn-success" onclick="dangKyTuyenDung(${tuyenDung.getMaTuyenDung()})">Đăng ký</button>
		        				</c:when>
		        				<c:when test="${dangKyTuyenDungDAO.getDangKyByMaSinhVienAndMaTuyenDung(sessionScope.sinhvien.getMaSinhVien(), tuyenDung.getMaTuyenDung())!=null &&dangKyTuyenDungDAO.getDangKyByMaSinhVienAndMaTuyenDung(sessionScope.sinhvien.getMaSinhVien(), tuyenDung.getMaTuyenDung()).isDaDuyet()}">
		        					<button class="btn btn-primary">Đã duyệt</button>
		        				</c:when>
		        				<c:otherwise>
		        					<button class="btn btn-danger" onclick="huyDangKy(${tuyenDung.getMaTuyenDung()})">Huỷ đăng ký</button>
		        				</c:otherwise>
		        			</c:choose>
		        		</c:otherwise>
		        	</c:choose>
		        </div>
		    </div>
		    </div>
		    
		
		<div style=" background-color: #f0f5f8; padding: 50px 30px 20px 30px; width: 1200px; transform: translateX(-40px);">
			
			<ul class="nav nav-pills tab-chitiet" >
				<li class="nav-item" onclick="tab(0)"><a href="#chi-tiet-tuyen-dung" class="link active">Chi tiết tin tuyển dụng</a></li>
				<li class="nav-item" onclick="tab(1)"><a href="#viec-lam-cung-cong-ty"  class="link">Việc làm cùng công ty</a></li>
				<li class="nav-item" onclick="tab(2)"><a href="#viec-lam-lien-quan" class="link">Việc làm liên quan</a></li>
			</ul>
		
		</div>    
		    
		 <div id="chi-tiet-tuyen-dung" >   
	<h5 style="margin: 30px 0;">Chi tiết tin tuyển dụng</h5>
	<div class="tuyendung" >
		
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
		            <b><i>Khu vực tuyển: </i></b>
		            <c:choose>
		            	<c:when test="${tuyenDung.getKhuVucTuyenDung()=='00' }">
		            		<span>Cả nước</span>
		            	</c:when>
		            	<c:otherwise>
		            		<span>${tinhThanhDAO.getTinhThanhById(tuyenDung.getKhuVucTuyenDung()).getTenTinhThanh() }</span>
		            		
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
        
      </div>
      
       <div style=" background-color: #f0f5f8; height: 20px; width: 1200px; transform: translateX(-20px);"></div>
       
       
       <div id="viec-lam-cung-cong-ty"  >
       <h5 style="margin: 30px 0;">Việc làm cùng công ty</h5>
       <div class="carousel" data-flickity data-flickity-options='{ "wrapAround": true, "pageDots": false, "cellAlign": "left" }'>
  <c:forEach items="${tuyenDungCungCongTy }" var="td" varStatus="i">
  <c:if test="${i.count<=10 }">
  <div class="carousel-cell">
  	<div class="tuyendung">
		   <div class="tuyendung-container">
		        	<a href="/tuyendung/chitiet?id=${td.getMaTuyenDung() }"  style="text-decoration: none; ">
		            	<h4>${td.getTieuDe() }</h4>
		            </a>
		            <a href="/doanhnghiep/chitiet?id=${td.getMaDoanhNghiep() }" style="text-decoration: none; color: black;">
		            	<span style="margin-bottom:20px;">${doanhNghiepDAO.getDoanhNghiepById(td.getMaDoanhNghiep()).getTenDoanhNghiep().toUpperCase()  }</span>
		            </a>
		            <div style="margin: 5px 0;">
		            	<b><i>Tên công việc : </i></b>${td.getTenCongViec() } 
		            </div>
		            
		            <div class="tuyendung-item">
		            <c:choose>
		            	<c:when test="${td.getKhuVucTuyenDung()=='00' }">
		            		<span>Cả nước</span>
		            	</c:when>
		            	<c:otherwise>
		            		<span>${tinhThanhDAO.getTinhThanhById(td.getKhuVucTuyenDung()).getTenTinhThanh() }</span>
		            		
		            	</c:otherwise>
		            </c:choose>
		            
		            	<span>${td.getMucLuong() }</span>
		            	<span>Hạn đăng ký : ${td.getHanDangKy() }</span>
		            </div>
		            
		        </div>
		        
		    </div>
  </div>
  </c:if>
  </c:forEach>
</div>
</div>
<div style=" background-color: #f0f5f8; height: 20px; width: 1200px; transform: translateX(-20px);"></div>
<div id="viec-lam-lien-quan"  >
<h5 style="margin: 30px 0;">Việc làm liên quan</h5>
     <c:forEach items="${tuyenDungLienQuan }" var="td">
        	<div class="tuyendung" >
		        <div class="tuyendung-container">
		        	<a href="/tuyendung/chitiet?id=${td.getMaTuyenDung() }" style="text-decoration: none; ">
		            	<h4>${td.getTieuDe() }</h4>
		            </a>
		            <a href="/doanhnghiep/chitiet?id=${td.getMaDoanhNghiep() }" style="text-decoration: none; color: black;">
		            	<span style="margin-bottom:20px;">${doanhNghiepDAO.getDoanhNghiepById(td.getMaDoanhNghiep()).getTenDoanhNghiep().toUpperCase()  }</span>
		            </a>
		            <div style="margin: 5px 0;">
		            	<b><i>Tên công việc : </i></b>${td.getTenCongViec() } 
		            </div>
		            
		            <div class="tuyendung-item">
		            <c:choose>
		            	<c:when test="${td.getKhuVucTuyenDung()=='00' }">
		            		<span>Cả nước</span>
		            	</c:when>
		            	<c:otherwise>
		            		<span>${tinhThanhDAO.getTinhThanhById(td.getKhuVucTuyenDung()).getTenTinhThanh() }</span>
		            		
		            	</c:otherwise>
		            </c:choose>
		            
		            	<span>${td.getMucLuong() }</span>
		            	<span>Hạn đăng ký : ${td.getHanDangKy() }</span>
		            </div>
		            
		        </div>
		        
		    </div>
        	
        </c:forEach>  
        </div>
    </div>
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    <script>
    	function tab(n){
    		var tablinks = document.getElementsByClassName("link");
    		for (i = 0; i < tablinks.length; i++) {
    		    tablinks[i].className = tablinks[i].className.replace(" active", "");
    		}
    		tablinks[n].className +=" active";
    	};
    	function dangKyTuyenDung(id){
    		$.ajax({ 
    		    type:"post", 
    		    url: "/tuyendung/chitiet/dangky", 
    		    contentType: "application/x-www-form-urlencoded;charset=utf-8",
    		    data: {
    		    	maTuyenDung: id
    		    }, 
    		    success: function(data) { 
    		    	let row = document.getElementById("tuyendung-item"+id);
    		    	row.innerHTML = data;
    		    },
    		})
    	};
    	function huyDangKy(id){
    		$.ajax({ 
    		    type:"post", 
    		    url: "/tuyendung/chitiet/huydangky", 
    		    contentType: "application/x-www-form-urlencoded;charset=utf-8",
    		    data: {
    		    	maTuyenDung: id
    		    }, 
    		    success: function(data) { 
    		    	let row = document.getElementById("tuyendung-item"+id);
    		    	row.innerHTML = data;
    		    },
    		})
    	};
    </script>
</body>
</html>