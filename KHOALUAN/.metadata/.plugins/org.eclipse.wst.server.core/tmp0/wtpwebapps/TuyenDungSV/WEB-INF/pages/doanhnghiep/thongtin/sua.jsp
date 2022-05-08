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
    <c:set var="dn" value="${sessionScope.doanhnghiep }"></c:set>
    <div style="height:70px;">
    </div>
    <div class="container">
    	<div style="height:20px;">
    	</div>
        <form class="row " method="post" onsubmit="return validate();" action="/doanhnghiep/thongtin/sua">
          <h3 style="color: rgb(6, 109, 70);" class="mb-5">Chỉnh sửa thông tin doanh nghiệp</h3>
          
          <!-- thong tin lien he -->
          
            <h5 class="mb-3">Thông tin liên hệ</h5>
            <div class="row mb-3">
              <label for="contactName" class="col-sm-3 col-form-label" >Tên người liên hệ<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="text" class="form-control" id="contactName" name="txtTenLienHe" value="${dn.getTenLienHe() }">
                <small id="errorContactName" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="contactEmail" class="col-sm-3 col-form-label">Email liên hệ<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="email" class="form-control" id="contactEmail" name="txtEmailLienHe" value="${dn.getEmailLienHe() }" >
                <small id="errorContactEmail" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="contactTel" class="col-sm-3 col-form-label">Điện thoại<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="tel" class="form-control" id="contactTel" name="txtSoDienThoai"  placeholder="0376551445" value="${dn.getSoDienThoai() }">
                <small><i><b>Lưu ý: </b>Các thuê bao di động đã chuyển về 10 số. Vui lòng nhập thông tin theo đầu số mới.</i></small>
                <br><small id="errorContactTel" style="color: red;"></small>
              </div>
            </div>
            
          <!-- thong tin doanh nghiep -->
          
            <h5 class="mb-3 mt-5" >Thông tin doanh nghiệp</h5>
            <div class="row mb-3">
              <label for="enterpriseName" class="col-sm-3 col-form-label" >Tên pháp lý của doanh nghiệp<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="text" class="form-control" id="enterpriseName" name="txtTenDoanhNghiep" value="${dn.getTenDoanhNghiep() }" disabled="disabled">
              </div>
            </div>
            <div class="row mb-3">
              <label for="taxCode" class="col-sm-3 col-form-label">Mã số thuế<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="text" class="form-control" id="taxCode" name="txtMaSoThue" value="${dn.getMaSoThue() }" disabled="disabled">
              </div>
            </div>
            

            <div class="row mb-3">
              <label for="city" class="col-sm-3 col-form-label">Chọn Tỉnh/Thành phố<span class="required"> *</span></label>
              <div class="col-sm-9">
                <select class="form-select" aria-label="Default select example" id="city" name="cmbTinhThanh" onchange="setQuanHuyen()">
	        		
	        		<c:forEach items="${dsTinhThanh }" var="tt">
						<c:if test="${quanHuyenDAO.getQuanHuyenById(xaPhuongDAO.getXaPhuongById(dn.getMaXaPhuong()).getMaQuanHuyen()).getMaTinhThanh()==tt.getMaTinhThanh() }">
							<option value="${tt.getMaTinhThanh()}" selected="selected">${tt.getTenTinhThanh() }</option> 
						</c:if>
						<c:if test="${quanHuyenDAO.getQuanHuyenById(xaPhuongDAO.getXaPhuongById(dn.getMaXaPhuong()).getMaQuanHuyen()).getMaTinhThanh()!=tt.getMaTinhThanh() }">
							<option value="${tt.getMaTinhThanh()}">${tt.getTenTinhThanh() }</option> 
						</c:if>
	        			
	        		</c:forEach>
	        		
                </select>
                <small id="errorCity" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="district" class="col-sm-3 col-form-label">Chọn Quận/Huyện<span class="required"> *</span></label>
              <div class="col-sm-9">
                <select class="form-select" aria-label="Default select example" id="district" name="cmbQuanHuyen" onchange="setXaPhuong()">              
                	
                	<option selected="selected" value="${quanHuyenDAO.getQuanHuyenById(xaPhuongDAO.getXaPhuongById(dn.getMaXaPhuong()).getMaQuanHuyen()).getMaQuanHuyen()}">${quanHuyenDAO.getQuanHuyenById(xaPhuongDAO.getXaPhuongById(dn.getMaXaPhuong()).getMaQuanHuyen()).getTenQuanHuyen() }</option> 
                </select>
                <small id="errorDistrict" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="ward" class="col-sm-3 col-form-label">Chọn Xã/Phường/Thị trấn<span class="required"> *</span></label>
              <div class="col-sm-9">
                <select class="form-select" aria-label="Default select example" id="ward" name="cmbXaPhuong" > 
                	<option selected="selected" value="${dn.getMaXaPhuong()}">${xaPhuongDAO.getXaPhuongById(dn.getMaXaPhuong()).getTenXaPhuong() }</option> 
                </select>
                <small id="errorWard" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="street" class="col-sm-3 col-form-label">Địa chỉ đường<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="text" class="form-control" id="street" name="txtDiaChiDuong" value="${dn.getDiaChiDuong() }">
                <small id="errorStreet" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="field" class="col-sm-3 col-form-label">Chọn lĩnh vực hoạt động<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="text" class="form-control" disabled="disabled" value="${linhVucHoatDongCap2DAO.getLinhVucHoatDongById(dn.getMaLinhVucHoatDong()).getTenLinhVuc() }">
                
              </div>
            </div>
            <div class="row mb-3">
              <label for="enterpriseType" class="col-sm-3 col-form-label">Chọn loại hình doanh nghiệp<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="text" class="form-control" disabled="disabled" value="${loaiHinhDoanhNghiepDAO.getLoaiHinhDoanhNghiepById(dn.getMaLoaiHinhDoanhNghiep()).getTenLoaiHinhDoanhNghiep() }">
              </div>
            </div>
            
          <div class="row mb-3 mt-3">
            <div class="col-sm-9 offset-sm-3">
            	<a  class="btn btn-danger" href="/doanhnghiep/thongtin">Huỷ</a>
              <button type="submit"  class="btn btn-primary">Chỉnh sửa</button>
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
	    	row.innerHTML = data;
	    	
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

function validate(){
	var kt= true;
	var checkEmail= /^[a-zA-Z][a-zA-Z0-9_\.]{5,63}@[a-zA-Z0-9]{2,}(\.[a-zA-Z0-9]{2,4}){1,2}$/;
	var checkTel= /^0[35789][0-9]{8}$/;
	
	var contactName = document.getElementById("contactName").value;
	var contactEmail = document.getElementById("contactEmail").value;
	var contactTel = document.getElementById("contactTel").value;
	var city = document.getElementById("city").value;
	var district = document.getElementById("district").value;
	var ward = document.getElementById("ward").value;
	var street = document.getElementById("street").value;
	
	if(!checkEmail.test(contactEmail)) {	
		document.getElementById("errorContactEmail").innerText="Email không hợp lệ";
		kt=false;
	}
	else document.getElementById("errorContactEmail").innerText="";
	if(!checkTel.test(contactTel)) {	
		document.getElementById("errorContactTel").innerText="Số điện thoại không hợp lệ";
		kt=false;
	}
	else document.getElementById("errorContactTel").innerText="";
	if(contactName=="") {	
		document.getElementById("errorContactName").innerText="Tên người liên hệ không được bỏ trống";
		kt=false;
	}
	else document.getElementById("errorContactName").innerText="";
	
	if(city==""){
		document.getElementById("errorCity").innerText="Tỉnh/Thành phố không được bỏ trống";
		kt=false;
	}
	else  document.getElementById("errorCity").innerText="";
	if(district==""){
		document.getElementById("errorDistrict").innerText="Quận/huyện không được bỏ trống";
		kt=false;
	}
	else document.getElementById("errorDistrict").innerText="";
	if(ward==""){
		document.getElementById("errorWard").innerText="Xã/phường/thị trấn không được bỏ trống";
		kt=false;
	}
	else document.getElementById("errorWard").innerText="";
	if(street==""){
		document.getElementById("errorStreet").innerText="Địa chỉ đường không được bỏ trống";
		kt=false;
	}
	else document.getElementById("errorStreet").innerText="";

	return kt;
};

</script>
</body>
</html>