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
    <section class="vh-100">
        <div class="container-fluid h-custom">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
              <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                class="img-fluid" alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
              <h3 style="color: rgb(6, 109, 70);margin-left: 90px;" class="mb-5 ">Đăng nhập</h3>
              <p class="lead mb-0 ">Đăng nhập bằng</p>
                <div class="text-lg-start mt-1 pt-2">
                  <a class="btn btn-primary btn-lg mb-3" style="padding-left: 2.5rem; padding-right: 2.5rem;width: 70%;" href="/doanhnghiep/dangnhap">Tài khoản doanh nghiệp</a>
                  <a class="btn btn-primary btn-lg mb-3" style="padding-left: 2.5rem; padding-right: 2.5rem;width: 70%;" href="/sinhvien/dangnhap">Tài khoản sinh viên</a>
                  <a class="btn btn-primary btn-lg mb-3" style="padding-left: 2.5rem; padding-right: 2.5rem;width: 70%;" href="/admin/dangnhap">Tài khoản quản trị</a>
                  <p class="small fw-bold mt-2 pt-1 mb-0">Chưa có tài khoản? <a href="#!" class="link-danger">Đăng ký tài khoản doanh nghiệp</a></p>
                </div>
      
            </div>
          </div>
        </div>
        
      </section>
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
</body>
</html>