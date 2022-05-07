<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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

        
        	<div style="position: relative;padding: 30px;" >
        		<div style="border-left: solid #00B14F 8px;margin-bottom: 20px;">
        			<h3 style="color: green;margin-left: 10px;">${doanhNghiep.getTenDoanhNghiep().toUpperCase() }</h3>
        		</div>
		            
		            
		            <div style="display: flex;margin-bottom: 5px;">
		            	<div style="width: 35px; height: 35px; background-color: #00B14F; border-radius: 50%; margin-right: 15px;align-items: center;display: flex;justify-content: center;">
		            		<i class="fas fa-envelope"></i>
		            	</div>
		            	<div style="display: flex;align-items: center;"><b>Email: &nbsp;</b> ${ doanhNghiep.getEmailLienHe() }</div>
		            </div>
		            <div style="display: flex;margin-bottom: 5px;">
		            	<div style="width: 35px; height: 35px; background-color: #00B14F; border-radius: 50%; margin-right: 15px;align-items: center;display: flex;justify-content: center;">
		            		<i class="fas fa-phone-alt"></i>
		            	</div>
		            	<div style="display: flex;align-items: center;"><b>Số điện thoại: &nbsp;</b> ${ doanhNghiep.getSoDienThoai() }</div>
		            </div>
		            <div style="display: flex;margin-bottom: 5px;">
		            	<div style="width: 35px; height: 35px; background-color: #00B14F; border-radius: 50%; margin-right: 15px;align-items: center;display: flex;justify-content: center;">
		            		<i class="fas fa-map-marker-alt"></i>
		            	</div>
		            	<div style="display: flex;align-items: center;"><b>Địa chỉ: &nbsp;</b>${ doanhNghiep.getDiaChiDuong() }, ${ xaPhuongDAO.getXaPhuongById(doanhNghiep.getMaXaPhuong()).getPathWithType() }</div>
		            </div>
		    </div>
		   
		    
		
		<div style=" background-color: #f0f5f8; padding: 50px 30px 20px 30px; width: 1200px; transform: translateX(-40px);">
			
			<ul class="nav nav-pills tab-chitiet" >
				<li class="nav-item" onclick="tab(0)"><a href="#quang-ba" class="link active">Về doanh nghiệp</a></li>
				<li class="nav-item" onclick="tab(1)"><a href="#tuyen-dung"  class="link">Tin tuyển dụng</a></li>
			</ul>
		
		</div>    
		    
		 <div id="quang-ba" >   
	<h5 style="margin: 30px 0;">Về doanh nghiệp</h5>
	<c:if test="${!quangBas.isEmpty() }">
		<div class="slideshow-container" >
        
	        <div class="mySlide row" >
	        
	        	<c:forEach items="${quangBas}" var="qb">
	        		<div class="col-6 slide-left ">
		                <h1>${qb.getTieuDe() }</h1>
		                <p>${qb.getNoiDungDaiDien() }</p>
		                <button class="btn btn-primary btn-lg">
		                    <a href="/doanhnghiep/quangba/chitiet?id=${qb.getMaQuangBa() }" style="color: white; text-decoration: none;">Xem thêm</a>
		                </button>
		            </div>
		            <div class="col-6 slide-right ">
		                <img src="${contextPath }/${qb.getHinhAnhDaiDien() }" >
		    
		            </div>
	        	</c:forEach>
	        	<div style="text-align:center" class="dots">
	            <c:forEach items="${quangBas}" varStatus="theCount">
		            <span class="dot" onclick="currentSlide(${theCount.index})"></span> 
	        	</c:forEach>
	        	</div>
	        </div>
        
      </div>
      </c:if>
      <c:if test="${quangBas.isEmpty() }">
      	<h4 style="color: #c0c0c0;">Không có thông tin</h4>
      </c:if>
      </div>
      
    
    
<div style=" background-color: #f0f5f8; height: 20px; width: 1200px; transform: translateX(-20px);"></div>
<div id="tuyen-dung"  >
<h5 style="margin: 30px 0;">Tin tuyển dụng</h5>
<c:if test="${!tuyenDungs.isEmpty() }"> 
       <div class="carousel" data-flickity data-flickity-options='{ "wrapAround": true, "pageDots": false, "cellAlign": "left" }'>
  <c:forEach items="${tuyenDungs }" var="td" varStatus="i">
  
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
  </c:forEach>
</div>
</c:if>
<c:if test="${!tuyenDungs.isEmpty() }">
	<h4 style="color: #c0c0c0;">Chưa có bài tuyển dụng</h4>
</c:if>
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
    	
    	var slideIndex;
        // KHai bào hàm hiển thị slide
        function showSlides() {
            var i;
            var slidel = document.getElementsByClassName("slide-left");
            var slider = document.getElementsByClassName("slide-right");
            var dots = document.getElementsByClassName("dot");
            for (i = 0; i < slidel.length; i++) {
               slidel[i].style.display = "none";  
               slider[i].style.display = "none";  
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
       
            slidel[slideIndex].style.display = "block"; 
            slider[slideIndex].style.display = "block"; 
            dots[slideIndex].className += " active";
            //chuyển đến slide tiếp theo
            slideIndex++;
            //nếu đang ở slide cuối cùng thì chuyển về slide đầu
            if (slideIndex > slidel.length - 1) {
              slideIndex = 0
            }    
            //tự động chuyển đổi slide sau 5s
            setTimeout(showSlides, 5000);
        }
        //mặc định hiển thị slide đầu tiên 
        showSlides(slideIndex = 0);
       
       
        function currentSlide(n) {
          showSlides(slideIndex = n);
        }
    </script>
</body>
</html>