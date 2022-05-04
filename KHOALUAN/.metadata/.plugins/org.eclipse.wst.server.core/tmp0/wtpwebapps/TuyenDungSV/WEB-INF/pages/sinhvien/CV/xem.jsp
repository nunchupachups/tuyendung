<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
    <div class="row" style="transform: translateX(-3px)">
    		<c:set var="sv" value="${sinhVien }"></c:set>
            <div class="col-4 cv-left" >
                <div class="d-flex">
                
                <c:choose>
                	<c:when test="${sv.getAnhDaiDien()!=null }">
                		<img class="avatar" src="${contextPath }/${sv.getAnhDaiDien()}" style="display: block;">
                	</c:when>
                	<c:otherwise>
                		<img class="avatar" src="${contextPath }/image/user.png" style="display: block;">
                	</c:otherwise>
                </c:choose>
                    
                </div>
                <div style="text-align: center;">
                     <p style="font-size: 17px;font-weight: bold; margin: 15px 0 5px 0; margin-top: 15px; margin-bottom: 5px;">${sv.getHoVaTen().toUpperCase() }</p>
                     <p style="font-size: 14px;">
                     	<c:choose>
                     		<c:when test="${cv.getViTriUngTuyen()!=null }">
	                     		${cv.getViTriUngTuyen() }
	                     	</c:when>
	                     	<c:otherwise>
	                     		 VỊ TRÍ ỨNG TUYỂN
	                     	</c:otherwise>
                     	</c:choose>
                     	
                    </p> 
                     <hr>
                </div>  
                <div class="info">
                    <div class="row">
                        <div class="contact-icon col-2"><i class="fas fa-calendar-alt"></i></div>
                        <div class="contact-info col-10">${sv.getNgaySinh() }</div>
                    </div>
                    <div class="row">
                        <div class="contact-icon col-2"><i class="fas fa-user"></i></div>
                        <div class="contact-info col-10">
                        	<c:if test="${sv.isGioiTinh() }">Nam</c:if>
                        	<c:if test="${!sv.isGioiTinh() }">Nữ</c:if>
						</div>
                    </div>
                    <div class="row">
                        <div class="contact-icon col-2"><i class="fas fa-phone-alt"></i></div>
                        <div class="contact-info col-10">
	                        <c:choose>
	                        	<c:when test="${sv.getDienThoai()!=null }">${sv.getDienThoai() }</c:when>
	                        	<c:otherwise>${sv.getDiDong() }</c:otherwise>
	                        </c:choose>
                        </div>
                    </div>
                    <div class="row">
                        <div class="contact-icon col-2"><i class="fas fa-envelope"></i></div>
                        <div class="contact-info col-10">${sv.getEmail() }</div>
                    </div>
                    <div class="row">
                        <div class="contact-icon col-2"><i class="fas fa-map-marker-alt"></i></div>
                        <div class="contact-info col-10">${sv.getDiaChi() }</div>
                    </div>
                    
                </div>
                <div class="cv-left-item">
                	<c:if test="${cv.isShowMucTieuNgheNghiep() }">
                		<h5 style="margin-bottom: 20px;">MỤC TIÊU NGHỀ NGHIỆP</h5>
	                    <div style="text-align: justify;">
	                    	
	                     		<c:if test="${cv.getMucTieuNgheNghiep()!=null }">
		                     		${cv.getMucTieuNgheNghiep() }
		                     	</c:if>
		                     	
	                        
	                    </div>
                	</c:if>
                	
                     
                </div>
                <div class="cv-left-item">
                	<c:if test="${cv.isShowKyNang() }">
                    <h5 style="margin-bottom: 20px;">KỸ NĂNG</h5>
                    <div>
                    	
                     		<c:if test="${!kynangs.isEmpty() }">
	                     		<c:forEach items="${kynangs }" var="kn">
	                     			<div class="mt-2">
		                     		<div>${kn.getTenKyNang() }</div>
				                        <div>
				                            <div style="height: 10px; background-color: white;">
				                                <div style="height: 10px;width: ${kn.getDoThanhThao()}0%;background-color: #548CA8;"></div>
				                            </div>
				                        </div>
				                    </div>
	                     		</c:forEach>
	                     	</c:if>
	                     	
                     </div> 
                     </c:if>  
                </div>
                <div class="cv-left-item">
                	<c:if test="${cv.isShowSoThich() }">
                    <h5 style="margin-bottom: 20px;">SỞ THÍCH</h5>
                   
                     		<c:if test="${cv.getSoThich()!=null }">
	                     		${cv.getSoThich() }
	                     	</c:if>
	                     	
                     
                     </c:if>
                </div>
            </div>
            <div class="col-8 cv-right">
                <c:if test="${cv.isShowHocVan() }">
                <div class="cv-right-item">
                    <div class="cv-right-item-name"><h5 >HỌC VẤN</h5></div>
	                    
	                     		<c:if test="${!hocVans.isEmpty() }">
		                     		<c:forEach items="${hocVans}" var="hv">
		                     			<ul>
				                            <li>
				                                <div><b>${hv.getTenDonVi() }</b></div>
				                                <c:forEach items="${viTriDAO.getAllViTriByMaDonVi(hv.getMaDonVi()) }" var="vt">
				                             		<div>
					                                    <div class="row mb-2"    >
					                                        <div class="col-9">
					                                            ${vt.getTenViTri() }
					                                        </div>
					                                        <div class="col-3">
					                                            ${vt.getKhoangThoiGian() }
					                                        </div>
					                                        
					                                    </div>
					                                    <div>
					                                    	${vt.getMoTa() }
					                                    </div>
					                                </div>
				                                </c:forEach>
				                                
				                            </li>
				                        </ul> 
		                     		</c:forEach>
		                     	</c:if>
                </div>
                </c:if>
                <c:if test="${cv.isShowKinhNghiemLamViec() }">
                <div class="cv-right-item">
                    <div class="cv-right-item-name"><h5 >KINH NGHIỆM LÀM VIỆC</h5></div>
                   
	                     		<c:if test="${!kinhNghiems.isEmpty() }">
		                     		<c:forEach items="${kinhNghiems}" var="kn">
		                     			<ul>
				                            <li>
				                                <div><b>${kn.getTenDonVi() }</b></div>
				                                <c:forEach items="${viTriDAO.getAllViTriByMaDonVi(kn.getMaDonVi()) }" var="vt">
				                             		<div>
					                                    <div class="row mb-2"    >
					                                        <div class="col-9">
					                                            ${vt.getTenViTri() }
					                                        </div>
					                                        <div class="col-3">
					                                            ${vt.getKhoangThoiGian() }
					                                        </div>
					                                        
					                                    </div>
					                                    <div>
					                                    	${vt.getMoTa() }
					                                    </div>
					                                </div>
				                                </c:forEach>
				                                
				                            </li>
				                        </ul> 
		                     		</c:forEach>
		                     	</c:if>
                </div>
                </c:if>
                <c:if test="${cv.isShowHoatDong() }">
                <div class="cv-right-item">
                    <div class="cv-right-item-name"><h5 >HOẠT ĐỘNG</h5></div>
                    
	                     		<c:if test="${!hoatDongs.isEmpty() }">
		                     		<c:forEach items="${hoatDongs}" var="hd">
		                     			<ul>
				                            <li>
				                                <div><b>${hd.getTenDonVi() }</b></div>
				                                <c:forEach items="${viTriDAO.getAllViTriByMaDonVi(hd.getMaDonVi()) }" var="vt">
				                             		<div>
					                                    <div class="row mb-2"    >
					                                        <div class="col-9">
					                                            ${vt.getTenViTri() }
					                                        </div>
					                                        <div class="col-3">
					                                            ${vt.getKhoangThoiGian() }
					                                        </div>
					                                        
					                                    </div>
					                                    <div>
					                                    	${vt.getMoTa() }
					                                    </div>
					                                </div>
				                                </c:forEach>
				                                
				                            </li>
				                        </ul> 
		                     		</c:forEach>
		                     	</c:if>
		                     	
                </div>
                </c:if>
                <c:if test="${cv.isShowChungChi() }">
                <div class="cv-right-item">
                    <div class="cv-right-item-name"><h5 >CHỨNG CHỈ</h5></div>
                    <div class="row mb-2" style="margin-left: 20px;"   >
                    	
                     		<c:if test="${!chungChis.isEmpty() }">
                     			<c:forEach items="${chungChis }" var="cc">
                     				<div class="col-9 chungchi-name">
			                            ${cc.getTenChungChi() }
			                        </div>
			                        <div class="col-3">
			                            ${cc.getNam() }
			                        </div>
                     			</c:forEach>
	                     		
	                     	</c:if>
	                     	
                        
                        
                        
                    </div>
                </div>
                </c:if>
            </div>
        </div>
    </div>
	
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    <a href="/sinhvien/CV/id?id=${sv.getMaSinhVien() }" style="text-decoration: none; color: black;">
    	<div class="btn-xemcv" style="background-color: orange;">
    	<h5>Xem CV </h5>
    	</div>
    </a>
    <a href="/sinhvien/diem/id?id=${sv.getMaSinhVien() }" style="text-decoration: none; color: black;">
    	<div class="btn-xemdiem" >
    	<h5>Xem điểm</h5>
    	</div>
    </a>
    
    
</body>
</html>