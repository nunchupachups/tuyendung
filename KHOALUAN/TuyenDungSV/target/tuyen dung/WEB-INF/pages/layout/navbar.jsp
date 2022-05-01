<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<nav class="navbar navbar-expand-lg d-flex ">
	<div class="navbar-container">
	<a class="navbar-brand " href="#" >
      <img src="${contextPath }/image/brand.png" class="img-brand" > 
    </a>
    
    <c:choose>
    	<c:when test="${sessionScope.sinhvien != null||sessionScope.doanhnghiep != null||sessionScope.admin != null}">
    		<c:choose>
    		<c:when test="${sessionScope.sinhvien != null}">
    		<div style="display: inline-block;">
    			<ul class="navbar-nav " >
			      <li class="nav-item">
			        <a class="nav-link " href="/doanhnghiep">Doanh Nghiệp</a>
			      </li>
			     <li class="nav-item">
			        <a class="nav-link" href="/sinhvien/tuyendung">Tuyển dụng</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/sinhvien/CV">CV</a>
			      </li>
			    </ul>
			    </div>
			    <div style="display: inline-block;float:right;">
			    <ul class="navbar-nav " >
			    	<span style="margin-top: 10px;">${sessionScope.sinhvien.getTenSinhVien() }</span> 
				   <div class="dropdown">
			          <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
			            
			            <i class="fas fa-sort-down"></i>
			          </button>
			          <ul class="dropdown-menu dropdown-account">
			            <li><a class="dropdown-item" href="#">Thông tin cá nhân</a></li>
			            <li><a class="dropdown-item" href="/sinhvien/dangxuat">Đăng xuất <i class="fas fa-sign-out-alt"></i></a></li>
			          </ul>
			        </div>
				      
				    </ul>
			    </div>
    		</c:when>
    		<c:when test="${sessionScope.doanhnghiep != null}">
    		<div style="display: inline-block;">
    			<ul class="navbar-nav " >
			      <li class="nav-item">
			        <a class="nav-link " href="/sinhvien/timkiem">Sinh viên</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/doanhnghiep/quangba">Quảng bá</a>
			      </li>
			     <li class="nav-item">
			        <a class="nav-link" href="/doanhnghiep/tuyendung">Tuyển dụng</a>
			      </li>
			    </ul>
			</div>
			    <div style="display: inline-block;float:right;">
			    <ul class="navbar-nav " >
			    	<span style="margin-top: 10px;">${sessionScope.doanhnghiep.tenDoanhNghiep }</span> 
				   <div class="dropdown">
			          <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
			            
			            <i class="fas fa-sort-down"></i>
			          </button>
			          <ul class="dropdown-menu dropdown-account">
			            <li><a class="dropdown-item" href="#">Thông tin doanh nghiệp</a></li>
			            <li><a class="dropdown-item" href="/doanhnghiep/dangxuat">Đăng xuất <i class="fas fa-sign-out-alt"></i></a></li>
			          </ul>
			        </div>
				      
				    </ul>
			    </div>
    		</c:when>
    		<c:otherwise>
    		<div style="display: inline-block;">
    			<ul class="navbar-nav " >
			      <li class="nav-item">
			        <a class="nav-link " href="#">Doanh nghiệp</a>
			      </li>
			     <li class="nav-item">
			        <a class="nav-link" href="#">Tuyển dụng</a>
			      </li>
			    </ul>
			    </div>
			    <div style="display: inline-block;float:right;">
			    <ul class="navbar-nav " >
			      <li><a>Đăng Ký <i class="fas fa-user-plus"></i></a></li>
			      <li><a>Đăng Nhập <i class="fa-solid fa-right-to-bracket"></i></a></li>
				</ul>
			    </div>
    		</c:otherwise>
    		</c:choose>
    	
    	</c:when>
    	<c:otherwise>
    	<div style="display: inline-block;">
    		<ul class="navbar-nav " >
			      <li class="nav-item">
			        <a class="nav-link " href="/doanhnghiep">Doanh nghiệp</a>
			      </li>
			     <li class="nav-item">
			        <a class="nav-link" href="#">Tuyển dụng</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" onclick="alert('Bạn cần phải đăng nhập trước!')">CV</a>
			      </li>
			    </ul>
			    </div>
			    <div style="display: inline-block;float:right;">
			    <ul class="navbar-nav " >
			    	<li class="nav-item">
			        	<a class="nav-link " href="/doanhnghiep/dangky">Đăng Ký <i class="fas fa-user-plus"></i></a>
			     	</li>
			     	<li class="nav-item">
			        	<a class="nav-link " href="/dangnhap">Đăng Nhập <i class="fas fa-sign-in-alt"></i></a>
			     	</li>
				</ul>
			    </div>
    	</c:otherwise>
    </c:choose>
    
    
  </div>  
</nav>