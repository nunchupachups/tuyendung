<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<nav class="navbar navbar-expand-lg d-flex ">
	<div class="navbar-container">
	<a class="navbar-brand " href="/trangchu" >
      <img src="${contextPath }/image/brand.png" class="img-brand" > 
    </a>
    
    <c:choose>
    	<c:when test="${sessionScope.sinhvien != null||sessionScope.doanhnghiep != null||sessionScope.admin != null}">
    		<c:choose>
    		<c:when test="${sessionScope.sinhvien != null}">
    		<div style="display: inline-block;">
    			<ul class="navbar-nav " >
    			<li class="nav-item">
			        <a class="nav-link " href="/trangchu">Trang Chủ</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link " href="/doanhnghiep">Doanh Nghiệp</a>
			      </li>
			     <li class="nav-item">
			        <a class="nav-link" href="/tuyendung">Tuyển dụng</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/sinhvien/CV">CV</a>
			      </li>
			    </ul>
			    </div>
			    <div style="display: inline-block;float:right;">
			    <div class="navbar-nav " >
			    	<div class="dropdown">
					    	<button type="button" style="height: 45px; width: 45px; background-color: #fafafa;border-radius: 50%; display: flex;justify-content: center;align-items: center; margin-right: 15px; position: relative;" class="dropdown-toggle" data-bs-toggle="dropdown">
					    		<i class="fas fa-bell" style="font-size: 25px;"></i>
					    		<div style="position: absolute; color: red; top: -5px; right: -5px; ">${thongBaoDAO.getSumThongBaoChuaXemByMaSinhVien(sessionScope.sinhvien.getMaSinhVien()) }</div>
					    	</button>
			          <ul class="dropdown-menu" style="width: 500px;right: 0; left: auto ; max-height: 500px;overflow: auto;padding-bottom: 0;box-shadow: 0 3px 6px #00000029;">
			          	<h4 style="margin: 15px;">Thông báo</h4>
			          	<hr>
			          	<c:if test="${thongBaoDAO.getAllThongBaoByMaSinhVien(sessionScope.sinhvien.getMaSinhVien()).size()==0 }">
			          		<li style="margin: 15px;font-weight: normal;">Bạn không có thông báo nào</li>
			          	</c:if>
			          	<c:if test="${thongBaoDAO.getAllThongBaoByMaSinhVien(sessionScope.sinhvien.getMaSinhVien()).size()!=0 }">
			          	<c:forEach items="${thongBaoDAO.getAllThongBaoByMaSinhVien(sessionScope.sinhvien.getMaSinhVien()) }" var="tb">
			          		<c:if test="${tb.isDaXem() }">
				            	<li style="border-bottom: 1px black solid;"><a class="dropdown-item" href="${tb.getLink() }" style="white-space: normal;">${tb.getNoiDung() }</a></li>
				            </c:if>
				            <c:if test="${!tb.isDaXem() }">
				            	<li style="border-bottom: 1px black solid;"><a class="dropdown-item" href="${tb.getLink() }" style="white-space: normal;" onclick="daXem(${tb.getMaThongBao()})"><b>${tb.getNoiDung() }</b></a></li>
				            </c:if>
				            
			            </c:forEach>
			            </c:if>
			          </ul>
			        </div>
			    	<span style="margin-top: 10px;">${sessionScope.sinhvien.getHoVaTen() }</span> 
				   <div class="dropdown">
			          <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
			            
			            <i class="fas fa-sort-down"></i>
			          </button>
			          <ul class="dropdown-menu " style="right: 0; left: auto ;">
			          	<li><a class="dropdown-item" href="/sinhvien/updatethongtin">Cật nhập thông tin và điểm từ trang tín chỉ</a></li>
			            <li><a class="dropdown-item" href="/sinhvien/dangxuat">Đăng xuất <i class="fas fa-sign-out-alt"></i></a></li>
			          </ul>
			        </div>
				      
				    </div>
			    </div>
    		</c:when>
    		<c:when test="${sessionScope.doanhnghiep != null}">
    		<div style="display: inline-block;">
    			<ul class="navbar-nav " >
    			<li class="nav-item">
			        <a class="nav-link " href="/trangchu">Trang Chủ</a>
			      </li>
			      
			      
			      <c:if test="${sessionScope.doanhnghiep.isDaDuyet() }">
				      <li class="nav-item">
				        <a class="nav-link " href="/sinhvien/timkiem">Sinh viên</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="/doanhnghiep/quangba">Quảng bá</a>
				      </li>
				     <li class="nav-item">
				        <a class="nav-link" href="/doanhnghiep/tuyendung">Tuyển dụng</a>
				      </li>
			      </c:if>
			      <c:if test="${!sessionScope.doanhnghiep.isDaDuyet() }">
				      <li class="nav-item">
				        <a class="nav-link " onclick="alert('Tài khoản của bạn chưa được duyệt. \nKhông có quyền truy cập!')">Sinh viên</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" onclick="alert('Tài khoản của bạn chưa được duyệt. \nKhông có quyền truy cập!')">Quảng bá</a>
				      </li>
				     <li class="nav-item">
				        <a class="nav-link" onclick="alert('Tài khoản của bạn chưa được duyệt. \nKhông có quyền truy cập!')">Tuyển dụng</a>
				      </li>
			      </c:if>
			      
			    </ul>
			    
			</div>
			    <div style="display: inline-block;float:right;">
			    <div class="navbar-nav " >
			    	<div class="dropdown">
					    	<button type="button" style="height: 45px; width: 45px; background-color: #fafafa;border-radius: 50%; display: flex;justify-content: center;align-items: center; margin-right: 15px; position: relative;" class="dropdown-toggle" data-bs-toggle="dropdown">
					    		<i class="fas fa-bell" style="font-size: 25px;"></i>
					    		<div style="position: absolute; color: red; top: -5px; right: -5px;">${thongBaoDAO.getSumThongBaoChuaXemByMaDoanhNghiep(sessionScope.doanhnghiep.getMaDoanhNghiep()) }</div>
					    	</button>
			          <ul class="dropdown-menu" style="width: 500px;right: 0; left: auto ; max-height: 500px;overflow: auto;padding-bottom: 0;box-shadow: 0 3px 6px #00000029;">
			          	<h4 style="margin: 15px;">Thông báo</h4>
			          	<hr>
			          	<c:if test="${thongBaoDAO.getAllThongBaoByMaDoanhNghiep(sessionScope.doanhnghiep.getMaDoanhNghiep()).size()==0 }">
			          		<li style="margin: 15px;font-weight: normal;">Bạn không có thông báo nào</li>
			          	</c:if>
			          	<c:if test="${thongBaoDAO.getAllThongBaoByMaDoanhNghiep(sessionScope.doanhnghiep.getMaDoanhNghiep()).size()!=0 }">
			          		
			          	
			          	<c:forEach items="${thongBaoDAO.getAllThongBaoByMaDoanhNghiep(sessionScope.doanhnghiep.getMaDoanhNghiep()) }" var="tb">
			          		<c:if test="${tb.isDaXem() }">
				            	<li style="border-bottom: 1px black solid;"><a class="dropdown-item" href="${tb.getLink() }" style="white-space: normal;">${tb.getNoiDung() }</a></li>
				            </c:if>
				            <c:if test="${!tb.isDaXem() }">
				            	<li style="border-bottom: 1px black solid;"><a class="dropdown-item" href="${tb.getLink() }" style="white-space: normal;" onclick="daXem(${tb.getMaThongBao()})"><b>${tb.getNoiDung() }</b></a></li>
				            </c:if>
			            </c:forEach>
			            </c:if>
			          </ul>
			        </div>
			    	<span style="margin-top: 10px;">${sessionScope.doanhnghiep.tenDoanhNghiep }</span> 
				   <div class="dropdown">
			          <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
			            
			            <i class="fas fa-sort-down"></i>
			          </button>
			          <ul class="dropdown-menu dropdown-account">
			            <li><a class="dropdown-item" href="/doanhnghiep/thongtin">Thông tin doanh nghiệp</a></li>
			            <li><a class="dropdown-item" href="/doanhnghiep/doimatkhau">Đổi mật khẩu</a></li>
			            <li><a class="dropdown-item" href="/doanhnghiep/dangxuat">Đăng xuất <i class="fas fa-sign-out-alt"></i></a></li>
			          </ul>
			        </div>
				      
				    </div>
			    </div>
    		</c:when>
    		<c:otherwise>
    		<div style="display: inline-block;">
    			<ul class="navbar-nav " >
    			
			      <li class="nav-item">
			        <a class="nav-link " href="/admin/doanhnghiep">QL Doanh nghiệp</a>
			      </li>
			     <li class="nav-item">
			        <a class="nav-link" href="/admin/tuyendung">QL Tuyển dụng</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/admin/quangba">QL Quảng bá</a>
			      </li>
			    </ul>
			    </div>
			    <div style="display: inline-block;float:right;">
			    <div class="navbar-nav " >
			      <span style="margin-top: 10px;">Admin</span> 
				   <div class="dropdown">
			          <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
			            
			            <i class="fas fa-sort-down"></i>
			          </button>
			          <ul class="dropdown-menu dropdown-account">
			            <li><a class="dropdown-item" href="/admin/dangxuat">Đăng xuất <i class="fas fa-sign-out-alt"></i></a></li>
			          </ul>
			        </div>
				</div>
			    </div>
    		</c:otherwise>
    		</c:choose>
    	
    	</c:when>
    	<c:otherwise>
    	<div style="display: inline-block;">
    		<ul class="navbar-nav " >
    		<li class="nav-item">
			        <a class="nav-link " href="/trangchu">Trang Chủ</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link " href="/doanhnghiep">Doanh nghiệp</a>
			      </li>
			     <li class="nav-item">
			        <a class="nav-link" href="/tuyendung">Tuyển dụng</a>
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
<script>
function daXem(id){
	console.log(id);
	$.ajax({ 
	    type:"post", 
	    url: "/thongbao/daxem", 
	    contentType: "application/x-www-form-urlencoded;charset=utf-8",
	    data: {
	    	maThongBao: id
	    }, 
	})
};
</script>