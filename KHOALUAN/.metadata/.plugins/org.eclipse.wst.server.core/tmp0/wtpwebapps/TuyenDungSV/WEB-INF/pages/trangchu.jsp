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
	<script>
		$(document).ready(function(){
			$('#myModal').modal('show');
		
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
    	
    	<div style="height: 15px;"></div>
    	
        	<div style="position: relative;padding: 30px;" >
        		<div style="height: 8px;width:100px;; margin-left: auto; margin-right: auto;margin-bottom:20px; background-color: green; border-radius: 10px;"></div>
		       <h1 style="text-align: center;line-height: 45px; " >Website hỗ trợ kết nối sinh viên, nhà trường <br>và doanh nghiệp</h1>
		       <div class="row mt-5" >
			       	<div class="col row">
			       		<div class="col-2" style="font-size: 70px; color: green; display: flex;align-items: center;">
			       			<i class="fas fa-hourglass-half"></i>
			       		</div>
			       		<div class="col-10">
			       			<h3>Tuyển dụng nhanh chóng</h3>
			       			<p style="font-size: 19px;">Kết nối trực tiếp giữa doanh nghiệp, thông tin tuyển dụng và sinh viên nhà trường</p>
			       		</div>
			       	</div>
			       	<div class="col row">
			       		<div class="col-2" style="font-size: 70px; color: green; display: flex;align-items: center;">
			       			<i class="fas fa-check-circle"></i>
			       		</div>
			       		<div class="col-10">
			       			<h3>Thông tin chính xác</h3>
			       			<p style="font-size: 19px;">Tiếp cận và kết nối với tất cả sinh viên nhà trường với thông tin và điểm số chính xác</p>
			       		</div>
			       	</div>
		       </div>
		     
		        
		    </div>
		<div style=" background-color: #f0f5f8; padding: 50px 30px 20px 30px; width: 1200px; transform: translateX(-40px);">
			
			<ul class="nav nav-pills tab-chitiet" >
				<li class="nav-item" onclick="tab(0)"><a href="#thong-tin-tuyen-dung" class="link active">Thông tin tuyển dụng</a></li>
				<li class="nav-item" onclick="tab(1)"><a href="#doanh-nghiep"  class="link">Doanh nghiệp</a></li>
				<li class="nav-item" onclick="tab(2)"><a href="#blog-huong-nghiep"  class="link">Blog hướng nghiệp</a></li>
			</ul>
		
		</div>
		<div id="thong-tin-tuyen-dung" >   
	<h5 style="margin: 30px 0;border-left: green solid 5px; padding-left: 10px; color: green;">Thông tin tuyển dụng</h5>
	<c:if test="${!tuyenDungs.isEmpty() }">
		<div class="carousel" data-flickity data-flickity-options='{ "wrapAround": true, "pageDots": false, "cellAlign": "left" }'>
		
	  <c:forEach items="${tuyenDungs }" var="td" >
	  <div class="carousel-cell">
	  	<div class="tuyendung">
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
	  </div>
	
	  </c:forEach>
	  
	</div>
        </c:if>
      </div>
      
      <div style=" background-color: #f0f5f8; height: 20px; width: 1200px; transform: translateX(-20px);"></div>
    	<div id="doanh-nghiep" >   
	<h5 style="margin: 30px 0;border-left: green solid 5px; padding-left: 10px; color: green;">Doanh nghiệp</h5>
	<c:if test="${!doanhNghieps.isEmpty() }">
		<div class="carousel" data-flickity data-flickity-options='{ "wrapAround": true, "pageDots": false, "cellAlign": "left" }' >
	  <c:forEach items="${doanhNghieps }" var="dn" >
	  <c:if test="${quangBaDAO.getAllQuangBaDaDuyetByMaDoanhNghiep(dn.getMaDoanhNghiep()).size()!=0 }">
	  <c:set var="qb" value="${quangBaDAO.getAllQuangBaDaDuyetByMaDoanhNghiep(dn.getMaDoanhNghiep()).get(0) }"></c:set>
	  <div class="carousel-cell" style="height:510px;width: 40%; " onclick="chiTiet(${qb.getMaDoanhNghiep()})">
	  <a href="/doanhnghiep/chitiet?id=${qb.getMaDoanhNghiep() }" style="color: black;text-decoration: none;">
	  	<div style="height: 500px;width:400px; display: flex;flex-direction: column;box-shadow: 5px 5px 6px #00000029;	">
			   <div style="height: 320px;">
			   	<img style="width: 100%; height: 100%;" src="${contextPath }/${qb.getHinhAnhDaiDien()}">
			   </div>
			   <div style="padding: 15px;">
			   		<h4 style="overflow:hidden; text-overflow: ellipsis; white-space: nowrap;">${qb.getTieuDe() }</h4>
			   		<p style="overflow:clip; height: 70px;">${qb.getNoiDungDaiDien() }</p>
			   ...
			   </div>
		</div>
		</a>
	  </div>
	  
	</c:if>
	  </c:forEach>
	</div>
	</c:if>
    </div>
    <div style=" background-color: #f0f5f8; height: 20px; width: 1200px; transform: translateX(-20px);"></div>
    	<div id="blog-huong-nghiep" >   
		<h5 style="margin: 30px 0;border-left: green solid 5px; padding-left: 10px; color: green;">Blog hướng nghiệp</h5>
		<c:if test="${!blogs.isEmpty() }">
				<div class="carousel" data-flickity data-flickity-options='{ "wrapAround": true, "pageDots": false, "cellAlign": "left" }' >
			  <c:forEach items="${blogs }" var="b" >
			  
			
		
			  <div class="carousel-cell" style="height:500px;width: 33%; margin-bottom: 20px;position: relative;" onclick="chiTietBlog(${b.getMaBlog()})">
			  <a href="/doanhnghiep/blog/chitiet?id=${b.getMaBlog() }" style="color: black;text-decoration: none;">
			  	<div style="height: 450px;width:100%; display: flex;flex-direction: column;box-shadow: 5px 5px 6px #00000029;	">
					   <div style="height: 320px;">
					   	<img style="width: 100%; height: 100%;" src="${contextPath }/${b.getAnh()}">
					   </div>
					   <div style="padding: 15px;">
					   		<h4>${b.getTieuDe() }</h4>
					   </div>
					   
				</div>
				</a>
			  </div>
			  
		
			  </c:forEach>
			</div>
			</c:if>
    </div>
	</div>
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    <script>
    function chiTiet(id){
		$.ajax({ 
		    type:"get", 
		    url: "/doanhnghiep/chitiet?id="+id, 
		})
	};
	function chiTietBlog(id){
		$.ajax({ 
		    type:"get", 
		    url: "/doanhnghiep/blog/chitiet?id="+id, 
		})
	};
	function tab(n){
		var tablinks = document.getElementsByClassName("link");
		for (i = 0; i < tablinks.length; i++) {
		    tablinks[i].className = tablinks[i].className.replace(" active", "");
		}
		tablinks[n].className +=" active";
	};
    </script>
</body>
</html>