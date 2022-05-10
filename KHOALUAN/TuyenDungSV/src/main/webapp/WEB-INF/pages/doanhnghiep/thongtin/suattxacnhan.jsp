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
        <form class="row " method="post" onsubmit="return validate();" action="/doanhnghiep/thongtinxacnhan/sua" enctype="multipart/form-data">
          <h3 style="color: rgb(6, 109, 70);" class="mb-5">Chỉnh sửa thông tin doanh nghiệp</h3>
          
          <!-- thong tin doanh nghiep -->
          
            <h5 class="mb-3 mt-5" >Thông tin doanh nghiệp</h5>
            <div class="row mb-3">
              <label for="enterpriseName" class="col-sm-3 col-form-label" >Tên pháp lý của doanh nghiệp<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="text" class="form-control" id="enterpriseName" name="txtTenDoanhNghiep" value="${dn.getTenDoanhNghiep() }">
                <small id="errorEnterpriseName" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="taxCode" class="col-sm-3 col-form-label">Mã số thuế<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="text" class="form-control" id="taxCode" name="txtMaSoThue" value="${dn.getMaSoThue() }">
                <small id="errorTaxCode" style="color: red;"></small>
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
                <select class="form-select" aria-label="Default select example" id="field" name="cmbLinhVucHoatDong" >
                  <c:forEach items="${dsLinhVuc }" var="lv">
                	<optgroup title="${lv.getTenLinhVuc() }" label="${lv.getTenLinhVuc() }">
                		<c:forEach items="${linhVucHoatDongCap2DAO.getAllLinhVucHoatDongByIdCap1(lv.getMaLinhVuc()) }" var="lvc1">
                			<c:choose>
                				<c:when test="${lvc1.getMaLinhVuc()==dn.getMaLinhVucHoatDong() }">
                					<option selected="selected" title="${lvc1.getTenLinhVuc() }" value="${lvc1.getMaLinhVuc() }">${lvc1.getTenLinhVuc() }</option>
                				</c:when>
                				<c:otherwise>
                					<option title="${lvc1.getTenLinhVuc() }" value="${lvc1.getMaLinhVuc() }">${lvc1.getTenLinhVuc() }</option>
                				</c:otherwise>
                			</c:choose>
                			
                		</c:forEach>
                	</optgroup>
        			
        			</c:forEach>
                </select>
                <small id="errorField" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="enterpriseType" class="col-sm-3 col-form-label">Chọn loại hình doanh nghiệp<span class="required"> *</span></label>
              <div class="col-sm-9">
                <select class="form-select" aria-label="Default select example" id="enterpriseType" name="cmbLoaiHinhDoanhNghiep" required="required">
                  <c:forEach items="${dsLoaiHinhDoanhNghiep }" var="lhdn">
        					<c:choose>
                				<c:when test="${lhdn.getMaLoaiHinhDoanhNghiep()==dn.getMaLoaiHinhDoanhNghiep() }">
                					<option selected="selected" value="${lhdn.getMaLoaiHinhDoanhNghiep() }">${lhdn.getTenLoaiHinhDoanhNghiep() }</option>
                				</c:when>
                				<c:otherwise>
                					<option value="${lhdn.getMaLoaiHinhDoanhNghiep() }">${lhdn.getTenLoaiHinhDoanhNghiep() }</option>
                				</c:otherwise>
                			</c:choose>
        			
        			</c:forEach>
                </select>
                <small id="errorEnterpriseType" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="certificate" class="col-sm-6 col-form-label">Tải lên giấy phép kinh doanh/Giấy chứng nhận thành lập công ty/Giấy chứng nhận đăng ký thuế của doanh nghiệp <span class="required"> (Nếu muốn thay thế)</span></label>
              <div class="col-sm-6">
                <input class="form-control" type="file" id="certificate" multiple  name="giayChungNhan" accept="image/*">
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
	var checkTaxCode= /^([0-9]{10}|[0-9]{13})$/;
	
	var enterpriseName = document.getElementById("enterpriseName").value;
	var taxCode = document.getElementById("taxCode").value;
	var city = document.getElementById("city").value;
	var district = document.getElementById("district").value;
	var ward = document.getElementById("ward").value;
	var street = document.getElementById("street").value;
	var field = document.getElementById("field").value;
	var enterpriseType = document.getElementById("enterpriseType").value;
	
	if(enterpriseName==""){
		document.getElementById("errorEnterpriseName").innerText="Tên doanh nghiệp không được bỏ trống";
		kt=false;
	}
	else  document.getElementById("errorEnterpriseName").innerText="";
	if(!checkTaxCode.test(taxCode)) {	
		document.getElementById("errorTaxCode").innerText="Mã số thuế không hợp lệ";
		kt=false;
	}
	else document.getElementById("errorTaxCode").innerText="";
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
	if(field==""){
		document.getElementById("errorField").innerText="Lĩnh vực hoạt động không được bỏ trống";
		kt=false;
	}
	else document.getElementById("errorField").innerText="";
	if(enterpriseType==""){
		document.getElementById("errorEnterpriseType").innerText="Loại hình doanh nghiệp không được bỏ trống";
		kt=false;
	}
	else document.getElementById("errorEnterpriseType").innerText="";
	
	if(kt) kt = confirm("Chỉnh sửa thông tin doanh nghiệp sẽ tốn một khoảng thời gian để duyệt. Trong khi đó bạn sẽ không thể thực hiện các chức năng khác của website. \n\nBạn có chắc chắn muốn chỉnh sửa?");
	return kt;
};

</script>
</body>
</html>