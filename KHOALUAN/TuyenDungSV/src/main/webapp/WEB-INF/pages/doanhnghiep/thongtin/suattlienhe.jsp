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
        <form class="row " method="post" onsubmit="return validate();" action="/doanhnghiep/thongtinlienhe/sua">
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

function validate(){
	var kt= true;
	var checkEmail= /^[a-zA-Z][a-zA-Z0-9_\.]{5,63}@[a-zA-Z0-9]{2,}(\.[a-zA-Z0-9]{2,4}){1,2}$/;
	var checkTel= /^0[35789][0-9]{8}$/;
	
	var contactName = document.getElementById("contactName").value;
	var contactEmail = document.getElementById("contactEmail").value;
	var contactTel = document.getElementById("contactTel").value;
	
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
	
	return kt;
};

</script>
</body>
</html>