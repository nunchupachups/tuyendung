<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<nav class="navbar navbar-expand-lg d-flex ">
	<div class="navbar-container">
	<a class="navbar-brand " href="#" >
      <img src="image/brand.png" class="img-brand" > 
    </a>
    <div style="display: inline-block;">
    <ul class="navbar-nav " >
      <li class="nav-item">
        <a class="nav-link " href="#">Active</a>
      </li>
     <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="#">Disabled</a>
      </li>
    </ul>
    </div>
    <div style="display: inline-block;float:right;">
    <ul class="navbar-nav " >
    	<span style="margin-top: 10px;">Công ty ABC</span> 
	   <div class="dropdown">
          <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
            
            <i class="fas fa-sort-down"></i>
          </button>
          <ul class="dropdown-menu dropdown-account">
            <li><a class="dropdown-item" href="#">Xoá</a></li>
            <li><a class="dropdown-item" href="#">Sửa</a></li>
          </ul>
        </div>
	      
	    </ul>
    </div>
    
  </div>  
</nav>