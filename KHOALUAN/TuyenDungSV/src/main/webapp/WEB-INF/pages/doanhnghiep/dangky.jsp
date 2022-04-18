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
        <form class="row " method="post" action="/doanhnghiep/dangky" enctype="multipart/form-data">
          <h3 style="color: rgb(6, 109, 70);" class="mb-5">Đăng ký tài khoản doanh nghiệp</h3>
          <!-- Thong tin dang nhap -->
          <div class="mb-4 mySlides" >
            <h5 class="mb-3">Thông tin đăng nhập</h5>
            <div class="row mb-3">
              <label for="email" class="col-sm-2 col-form-label" >Email đăng nhập<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="email" class="form-control" id="email" name="txtEmail" required="required">
              </div>
            </div>
            <div class="row mb-3">
              <label for="password" class="col-sm-2 col-form-label">Mật khẩu<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="password" class="form-control" id="password" name="txtMatKhau" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required="required">
                <small><i><b>Lưu ý: </b>Mật khẩu tối thiểu 8 ký tự, trong đó có ít nhất 1 ký tự chữ và 1 ký tự số.</i></small>
              </div>

            </div>
            <div class="row mb-3">
              <label for="rePassword" class="col-sm-2 col-form-label">Xác nhận lại mật khẩu<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="password" class="form-control" id="rePassword" required="required">
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-sm-10 offset-sm-2">
                <button type="button" class="btn btn-outline-secondary" onclick="currentSlide(1)">Tiếp <i class="fas fa-arrow-right"></i></button>
              </div>
            </div>
          </div>
          <!-- thong tin lien he -->
          <div class="mb-4 mySlides" style="display: none;">
            <h5 class="mb-3">Thông tin liên hệ</h5>
            <div class="row mb-3">
              <label for="contactName" class="col-sm-2 col-form-label" >Tên người liên hệ<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="contactName" name="txtTenLienHe" required="required">
              </div>
            </div>
            <div class="row mb-3">
              <label for="contactEmail" class="col-sm-2 col-form-label">Email liên hệ<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="email" class="form-control" id="contactEmail" name="txtEmailLienHe" required="required">
              </div>
            </div>
            <div class="row mb-3">
              <label for="contactTel" class="col-sm-2 col-form-label">Điện thoại<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="tel" class="form-control" id="contactTel" name="txtSoDienThoai" pattern="0[3578][0-9]{1}-[0-9]{3}-[0-9]{4}" placeholder="037-655-1445" required="required">
                <small><i><b>Lưu ý: </b>Các thuê bao di động đã chuyển về 10 số. Vui lòng nhập thông tin theo đầu số mới.</i></small>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-sm-10 offset-sm-2">
                <button type="button" class="btn btn-outline-secondary" style="margin-right: 10px;" onclick="currentSlide(0)"><i class="fas fa-arrow-left"></i> Trở lại </button>
                <button type="button" class="btn btn-outline-secondary"onclick="currentSlide(2)">Tiếp <i class="fas fa-arrow-right"></i></button>
              </div>
            </div>
          </div>

          <!-- thong tin doanh nghiep -->
          <div class="mb-4 mySlides" style="display: none;">
            <h5 class="mb-3">Thông tin doanh nghiệp</h5>
            <div class="row mb-3">
              <label for="enterpriseName" class="col-sm-3 col-form-label" >Tên pháp lý của doanh nghiệp<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="text" class="form-control" id="enterpriseName" name="txtTenDoanhNghiep" required="required">
              </div>
            </div>
            <div class="row mb-3">
              <label for="taxCode" class="col-sm-3 col-form-label">Mã số thuế<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="text" class="form-control" id="taxCode" name="txtMaSoThue" minlength="10" maxlength="13" required="required">
              </div>
            </div>
            

            <div class="row mb-3">
              <label for="city" class="col-sm-3 col-form-label">Chọn Tỉnh/Thành phố<span class="required"> *</span></label>
              <div class="col-sm-9">
                <select class="form-select" aria-label="Default select example" id="city" name="cmbTinhThanh" required="required"  onchange="setQuanHuyen()">
	        		<option disabled selected>----------</option>
	        		<c:forEach items="${dsTinhThanh }" var="tt">

	        			<option value="${tt.getMaTinhThanh()}">${tt.getTenTinhThanh() }</option> 
	        		</c:forEach>
                </select>
              </div>
            </div>
            <div class="row mb-3">
              <label for="district" class="col-sm-3 col-form-label">Chọn Quận/Huyện<span class="required"> *</span></label>
              <div class="col-sm-9">
                <select class="form-select" aria-label="Default select example" id="district" name="cmbQuanHuyen" required="required" onchange="setXaPhuong()">              
                	<option disabled selected>----------</option>
                </select>
              </div>
            </div>
            <div class="row mb-3">
              <label for="ward" class="col-sm-3 col-form-label">Chọn Xã/Phường/Thị trấn<span class="required"> *</span></label>
              <div class="col-sm-9">
                <select class="form-select" aria-label="Default select example" id="ward" name="cmbXaPhuong" required="required" > 
                	
                </select>
              </div>
            </div>
            <div class="row mb-3">
              <label for="street" class="col-sm-3 col-form-label">Địa chỉ đường</label>
              <div class="col-sm-9">
                <input type="text" class="form-control" id="street" name="txtDiaChiDuong">
              </div>
            </div>
            <div class="row mb-3">
              <label for="field" class="col-sm-3 col-form-label">Chọn lĩnh vực hoạt động<span class="required"> *</span></label>
              <div class="col-sm-9">
                <select class="form-select" aria-label="Default select example" id="field" name="cmbLinhVucHoatDong" required="required">
                  <c:forEach items="${dsLinhVuc }" var="lv">
                	<optgroup title="${lv.getTenLinhVuc() }" label="${lv.getTenLinhVuc() }">
                		<c:forEach items="${linhVucHoatDongCap2DAO.getAllLinhVucHoatDongByIdCap1(lv.getMaLinhVuc()) }" var="lvc1">
                			<option title="${lvc1.getTenLinhVuc() }" value="${lvc1.getMaLinhVuc() }">${lvc1.getTenLinhVuc() }</option>
                		</c:forEach>
                	</optgroup>
        			
        			</c:forEach>
                </select>
              </div>
            </div>
            <div class="row mb-3">
              <label for="enterpriseType" class="col-sm-3 col-form-label">Chọn loại hình doanh nghiệp<span class="required"> *</span></label>
              <div class="col-sm-9">
                <select class="form-select" aria-label="Default select example" id="enterpriseType" name="cmbLoaiHinhDoanhNghiep" required="required">
                  <c:forEach items="${dsLoaiHinhDoanhNghiep }" var="lhdn">
        			<option value="${lhdn.getMaLoaiHinhDoanhNghiep() }">${lhdn.getTenLoaiHinhDoanhNghiep() }</option>
        			</c:forEach>
                </select>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-sm-9 offset-sm-3">
                <button type="button" class="btn btn-outline-secondary" style="margin-right: 10px;" onclick="currentSlide(1)"><i class="fas fa-arrow-left"></i> Trở lại </button>
                <button type="button" class="btn btn-outline-secondary" onclick="currentSlide(3)">Tiếp <i class="fas fa-arrow-right"></i></button>
              </div>
            </div>
          </div>
          <div class="mb-4 mySlides" style="display: none;">  
            <h5 class="mb-3">Chứng minh doanh nghiệp</h5>
            <div class="row mb-3">
              <label for="certificate" class="col-sm-6 col-form-label">Tải lên giấy phép kinh doanh/Giấy chứng nhận thành lập công ty/Giấy chứng nhận đăng ký thuế của doanh nghiệp<span class="required"> *</span></label>
              <div class="col-sm-6">
                <input class="form-control" type="file" id="certificate" multiple required="required" name="giayChungNhan">
              </div>
            </div>
          
          
          <div class="row mb-3">
            <div class="col-sm-11 offset-sm-1">
              <button type="button" class="btn btn-outline-secondary" style="margin-right: 10px;" onclick="currentSlide(2)"><i class="fas fa-arrow-left"></i> Trở lại </button>
            </div>
          </div>
          <!-- button Dangky -->
          <div class="row mb-3"> 
            <div class="col-sm-11 offset-sm-1">
              <small><i>Bằng việc nhấn nút Đăng ký, Quý khách đã đồng ý với <a href="">điều khoản sử dụng</a> và <a href="">chính sách bảo mật</a> của chúng tôi.</i></small>  
            </div>
          </div>
          
          
          <div class="row mb-3">
            <div class="col-sm-11 offset-sm-1">
              <button type="submit" class="btn btn-primary">Đăng ký</button>
            </div>
          </div>
        </div>
      </form>
    </div>
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    
<script>

function setQuanHuyen(){
	var maTinhThanh = document.getElementById("city").value;
	document.getElementById("ward").innerHTML="<option disabled selected>----------</option>";
	$.ajax({ 
	    type:"post", 
	    url: "/doanhnghiep/dangky/quanhuyen", 
	    contentType: "application/x-www-form-urlencoded;charset=utf-8",
	    data: {
	    	maTinhThanh: maTinhThanh,
	    }, 
	    success: function(data) { 
	    	var row = document.getElementById("district");
	    	row.innerHTML += data;
	    	
	    },
	    })
};

function setXaPhuong(){
	var maQuanHuyen = document.getElementById("district").value;
	$.ajax({ 
	    type:"post", 
	    url: "/doanhnghiep/dangky/xaphuong", 
	    contentType: "application/x-www-form-urlencoded;charset=utf-8",
	    data: {
	    	maQuanHuyen: maQuanHuyen,
	    }, 
	    success: function(data) { 
	    	var row = document.getElementById("ward");
	    	row.innerHTML = data;
	    },
	    })
};
</script>
</body>
</html>