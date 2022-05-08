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
        <form class="row " method="post" onsubmit="return validate();" action="/doanhnghiep/doimatkhau" >
          <h3 style="color: rgb(6, 109, 70);" class="mb-5">Đổi mật khẩu</h3>
            <div class="row mb-3">
              <label for="oldPassword" class="col-sm-2 col-form-label" >Mật khẩu cũ<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="password" class="form-control" id="oldPassword" name="txtOldPassword">
                <small id="errorOldPassword" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="newPassword" class="col-sm-2 col-form-label">Mật khẩu mới<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="password" class="form-control" id="newPassword" name="txtNewPassword" >
                <small><i><b>Lưu ý: </b>Mật khẩu tối thiểu 8 ký tự, trong đó có ít nhất 1 ký tự chữ thường, 1 ký tự chữ hoa và 1 ký tự số.</i></small>
                <br><small id="errorNewPassword" style="color: red;"></small>
              </div>

            </div>
            <div class="row mb-3">
              <label for="reNewPassword" class="col-sm-2 col-form-label">Xác nhận mật khẩu mới<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="password" class="form-control" id="reNewPassword">
                <small id="errorReNewPassword" style="color: red;"></small>
              </div>
            </div>
       
          <div class="row mb-3">
            <div class="col-sm-11 offset-sm-1">
              <button type="submit"  class="btn btn-primary">Đăng ký</button>
            </div>
          </div>
       
      </form>
    </div>
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    
<script>

function validate(){
	var kt=true;
	var checkOldPassword="";
	var checkNewPassword="";
	var checkPassword= /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
	
	var oldPassword = document.getElementById("oldPassword").value;
	var newPassword = document.getElementById("newPassword").value;
	var reNewPassword = document.getElementById("reNewPassword").value;
	var errorOldPassword = document.getElementById("errorOldPassword");
	var errorNewPassword = document.getElementById("errorNewPassword");
	var errorReNewPassword = document.getElementById("errorReNewPassword");
	
	$.ajax({ 
	    type:"post", 
	    url: "/doanhnghiep/checkmatkhaucu", 
	    contentType: "application/x-www-form-urlencoded;charset=utf-8",
	    data: {
	    	oldPassword: oldPassword,
	    }, 
	    async: false,
	    success: function(data) { 
	    	checkOldPassword=data;
	    },
	    });
	
	if(oldPassword=="") {	
		errorOldPassword.innerText="Mật khẩu cũ không được bỏ trống";
		kt=false;
	}else if(checkOldPassword=="false"){
		errorOldPassword.innerText="Mật khẩu cũ không đúng";
		kt=false;
	}else {
		errorOldPassword.innerText="";
		console.log(newPassword);
		console.log(oldPassword);
		if(newPassword===oldPassword){
			console.log("hi");
			errorNewPassword.innerText="Mật khẩu mới không được giống mật khẩu cũ";
			kt=false;
		}else errorNewPassword.innerText="";
	}
	
	if(newPassword=="") {	
		errorNewPassword.innerText="Mật khẩu mới không được bỏ trống";
		kt=false;
	}else if(!checkPassword.test(newPassword)){
		errorNewPassword.innerText="Mật khẩu mới không hợp lệ";
		kt=false;
	}
	
	if(reNewPassword=="") {	
		errorReNewPassword.innerText="Lặp lại mật khẩu mới không được bỏ trống";
		kt=false;
	}else if(reNewPassword!=newPassword){
		errorReNewPassword.innerText="Lặp lại mật khẩu mới không khớp";
		kt=false;
	}else errorReNewPassword.innerText="";
	
	return kt;
};
</script>
</body>
</html>