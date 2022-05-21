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
    
    <div class="row">
    	<div class="col-5">
        	<input type="text" class="form-control" id="key" placeholder="Tên công việc, vị trí bạn muốn ứng tuyển...	" >
        </div>
        <div class="col-2">
        	<select class="form-select" aria-label="Default select example"  id="cmbNganhNghe" >
                        <option value="-1">Tất cả ngành nghề</option>
                        <c:forEach items="${dsNganhNghe }" var="nn">
                        	<option value="${nn.getMaNganhNghe() }">${nn.getTenNganhNghe() }</option>
                        </c:forEach>
            </select>
        </div>
        <div class="col-2">
                    <select class="form-select" aria-label="Default select example" id="cmbHinhThuc">
                        <option value="-1">Tất cả hình thức làm việc</option>
                        <c:forEach items="${dsHinhThuc }" var="ht">
                        	<option value="${ht.getMaHinhThuc() }">${ht.getTenHinhThuc() }</option>
                        </c:forEach>
                      </select>
                </div>
                <div class="col-2">
                    <select class="form-select" aria-label="Default select example" id="cmbKhuVucTuyen">
                        <option value="-1">Tất cả khu vực</option>
                        <option value="00">Cả nước</option>
                        <c:forEach items="${dsTinhThanh }" var="tt">
                        	<option value="${tt.getMaTinhThanh() }">${tt.getTenTinhThanh() }</option>
                        </c:forEach>
                      </select>
                </div>
        <div class="col-1">
            <button class="btn btn-primary" onclick="timKiemTuyenDung()"><i class="fas fa-search"></i></button>
        </div>
        
    </div>
    <hr>
    <div id="tuyendung">
    
    	<c:if test="${tuyenDungs.isEmpty()||tuyenDungs==null }">
    	<h4 style="color: #c0c0c0;">Không có bài tuyển dụng nào</h4>
    	</c:if>
    	
        <c:forEach items="${tuyenDungs }" var="td">
        	<div  id="tuyendung-item${td.getMaTuyenDung() }">
        	<div class="tuyendung" style="position: relative;" >
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
		        
		        <div style="position: absolute;bottom: 15px;right: 50px;">
		        	<c:choose>
		        		<c:when test="${sessionScope.sinhvien==null }">
		        			<button class="btn btn-success" onclick="alert('Bạn cần phải đăng nhập trước!')">Đăng ký</button>
		        		</c:when>
		        		<c:otherwise>
		        			<c:choose>
		        				<c:when test="${dangKyTuyenDungDAO.getDangKyByMaSinhVienAndMaTuyenDung(sessionScope.sinhvien.getMaSinhVien(), td.getMaTuyenDung())==null }">
		        					<button class="btn btn-success" onclick="dangKyTuyenDung(${td.getMaTuyenDung()})">Đăng ký</button>
		        				</c:when>
		        				<c:when test="${dangKyTuyenDungDAO.getDangKyByMaSinhVienAndMaTuyenDung(sessionScope.sinhvien.getMaSinhVien(), td.getMaTuyenDung())!=null &&dangKyTuyenDungDAO.getDangKyByMaSinhVienAndMaTuyenDung(sessionScope.sinhvien.getMaSinhVien(), td.getMaTuyenDung()).isDaDuyet()}">
		        					<button class="btn btn-primary">Đã duyệt</button>
		        				</c:when>
		        				<c:otherwise>
		        					<button class="btn btn-danger" onclick="huyDangKy(${td.getMaTuyenDung()})">Huỷ đăng ký</button>
		        				</c:otherwise>
		        			</c:choose>
		        		</c:otherwise>
		        	</c:choose>
		        </div>
		    </div>
        	</div>
        </c:forEach>
        
        <c:if test="${soPage>1 }">
        	<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item disabled">
      <a class="page-link" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item active" onclick="timKiemTuyenDung()"><a class="page-link" >1</a></li>
    <c:forEach var="i" begin="2" end="${soPage }">
    	<c:if test="${i<4 }">
    		<li class="page-item" onclick="timKiemTuyenDungByPage(${i})"><a class="page-link" >${i }</a></li>
    	</c:if>
    </c:forEach>
    <li class="page-item">
      <a class="page-link" onclick="timKiemTuyenDung(2)" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
       </c:if>
       </div>
       <c:if test="${!tuyenDungDeXuat.isEmpty() }">
       <div style=" background-color: #f0f5f8; height: 20px; width: 1200px; transform: translateX(-20px);"></div>
       <h5 style="margin: 30px 0;">Việc làm có thể phù hợp</h5>
        
       <div class="carousel" data-flickity data-flickity-options='{ "wrapAround": true, "pageDots": false, "cellAlign": "left" }'>
      
  <c:forEach items="${tuyenDungDeXuat }" var="td" varStatus="i">
  <c:if test="${i.count<=10 }">
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
  </c:if>
  </c:forEach>
  </c:if>
</div>
       
    </div>
	
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    <script>
    function timKiemTuyenDung(){
    	console.log("hihi");
    	var key=document.getElementById("key").value;
    	var maNganhNghe=document.getElementById("cmbNganhNghe").value;
    	var maHinhThuc=document.getElementById("cmbHinhThuc").value;
    	var maKhuVuc=document.getElementById("cmbKhuVucTuyen").value;
		$.ajax({ 
		    type:"post", 
		    url: "/tuyendung/timkiem", 
		    contentType: "application/x-www-form-urlencoded;charset=utf-8",
		    data: {
		    	key: key,
		    	maNganhNghe: maNganhNghe,
		    	maHinhThuc: maHinhThuc,
		    	maKhuVuc: maKhuVuc
		    	
		    }, 
		    success: function(data) { 
		    	let row = document.getElementById("tuyendung");
		    	row.innerHTML = data;
		    },
		})
	};
	
	function timKiemTuyenDungByPage(page){
		console.log(page);
    	var key=document.getElementById("key").value;
    	var maNganhNghe=document.getElementById("cmbNganhNghe").value;
    	var maHinhThuc=document.getElementById("cmbHinhThuc").value;
    	var maKhuVuc=document.getElementById("cmbKhuVucTuyen").value;
		$.ajax({ 
		    type:"post", 
		    url: "/tuyendung/timkiem/page", 
		    contentType: "application/x-www-form-urlencoded;charset=utf-8",
		    data: {
		    	key: key,
		    	maNganhNghe: maNganhNghe,
		    	maHinhThuc: maHinhThuc,
		    	maKhuVuc: maKhuVuc,
		    	page: page
		    }, 
		    success: function(data) { 
		    	let row = document.getElementById("tuyendung");
		    	row.innerHTML = data;
		    },
		})
	};
	function dangKyTuyenDung(id){
		$.ajax({ 
		    type:"post", 
		    url: "/tuyendung/dangky", 
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
		    url: "/tuyendung/huydangky", 
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