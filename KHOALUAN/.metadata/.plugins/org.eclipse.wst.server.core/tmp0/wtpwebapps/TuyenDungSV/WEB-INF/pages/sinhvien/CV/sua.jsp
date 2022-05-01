<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="hocVans" value="${sessionScope.hocVans }"/>
<c:set var="hoatDongs" value="${sessionScope.hoatDongs }"/>
<c:set var="kinhNghiems" value="${sessionScope.kinhNghiems }"/>
<c:set var="kyNangs" value="${sessionScope.kyNangs }"/>
<c:set var="chungChis" value="${sessionScope.chungChis }"/>
<c:set var="cv" value="${sessionScope.cv }"/>
<!DOCTYPE html>
<html>
<head>
	<title>${title }</title>
	<jsp:include page="/WEB-INF/pages/layout/header.jsp" />
	<style type="text/css">
		#cke_1_top, #cke_2_top,#cke_1_bottom,#cke_2_bottom{
		display: none;
		}
	</style>
</head>
<body>
    <div class="bg">
    <jsp:include page="/WEB-INF/pages/layout/navbar.jsp" />
    <div style="height:70px;">
    </div>
    <div class="container">
    	<div class="row">
            <div class="col-8">
                <form class="row" method="post" action="/sinhvien/suaCV" enctype="multipart/form-data">
                    <h3 style="color: rgb(6, 109, 70)" class="mb-5">Tạo CV</h3>
                    <div onclick="showHuongdan('taocv-huongdan-thongtincanhan')">
                        <h5 class="mb-3">Thông tin cá nhân</h5>
                        <div>
                        	
                            <div class="row mb-3">
                                <label for="avatar" class="col-sm-4 col-form-label">Ảnh đại diện (Chọn nếu muốn thay đổi)</label>
                                <div class="col-8">
                                    <input type="file" class=" form-control" name="avatar" accept="image/*"/>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="position" class="col-sm-4 col-form-label"  >Vị trí muốn ứng tuyển<span
                                        class="required"> *</span></label>
                                <div class="col-8">
	                                <c:if test="${cv!=null&&cv.getViTriUngTuyen()!=null }">
	                                	<input type="text" class=" form-control" name="position" required="required" value="${cv.getViTriUngTuyen() }"/>
	                                </c:if>
                                    <c:if test="${cv==null||cv!=null&&cv.getViTriUngTuyen()==null }">
	                                	<input type="text" class=" form-control" name="position" required="required"/>
	                                </c:if>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-4">Họ tên : </div>
                                <div class="col-8">
                                    ${sinhvien.getHoVaTen() }
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-4">Ngày sinh : </div>
                                <div class="col-8">
                                    ${sinhvien.getNgaySinh() }
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-4">Giới tính : </div>
                                <div class="col-8">
                                    <c:if test="${sinhvien.isGioiTinh() }">
                                        Nam
                                    </c:if>
                                    <c:if test="${!sinhvien.isGioiTinh() }">
                                        Nữ
                                    </c:if>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-4">Số điện thoại : </div>
                                <div class="col-8">
                                    <c:choose>
                                    	<c:when test="${!sinhvien.getDiDong()=='' }">
                                    		${sinhvien.getDiDong() }
                                    	</c:when>
                                    	<c:otherwise>
                                    		${sinhvien.getDienThoai() }
                                    	</c:otherwise>
                                    	
                                    </c:choose>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-4">Email : </div>
                                <div class="col-8">
                                    ${sinhvien.getEmail() }
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-4">Địa chỉ : </div>
                                <div class="col-8">
                                    ${sinhvien.getDiaChi() }
                                </div>
                            </div>
                            
                        </div>
                    </div>

                    
                    <h5 class="mb-3">Các mục thông tin khác</h5>
                    <div class="taocv-item" onclick="showHuongdan('taocv-huongdan-kynang')">
                        <div class="row mb-3">
                            <label for="title" class="col-sm-11 col-form-label">
                                <h6>KỸ NĂNG</h6>
                            </label>
                            <div class="col-1">
                                <input type="checkbox" name="kynang"/>
                            </div>
                        </div>
                        <div style="margin-left: 20px;" id="kynang">
                   
                        	<c:forEach items="${kyNangs}" var="kn">
                        		<div class="row mb-1">
	                                <div class="col-6">
	                                    ${kn.getTenKyNang() }
	                                </div>
	                                <div class="col-5">
	                                    Thành thạo:  ${kn.getDoThanhThao() }/10
	                                </div>
	
	                                <div class="col-1">
	                                    <i class="fas fa-trash-alt trash" onclick="deleteKyNang('${kn.getMaKyNang()}')"></i>
	                                </div>
	                            </div>
	                            
                        	</c:forEach>
                            
                            
                            <a href="" data-bs-toggle="modal" data-bs-target="#myModalKynang"><i
                                    class="fas fa-plus-square"></i>Thêm kỹ năng</a>

                        </div>

                    </div>
                    <div class="taocv-item" onclick="showHuongdan('taocv-huongdan-chungchi')">
                        <div class="row mb-3">
                            <label for="title" class="col-sm-11 col-form-label">
                                <h6>CHỨNG CHỈ</h6>
                            </label>
                            <div class="col-1">
                                <input type="checkbox" name="chungchi"/>
                            </div>
                        </div>
                        <div style="margin-left: 20px;" id="chungchi">
                   
                        	<c:forEach items="${chungChis}" var="cc">
                        		<div class="row mb-1">
	                                <div class="col-6">
	                                    ${cc.getTenChungChi() }
	                                </div>
	                                <div class="col-5">
	                                    Năm:  ${cc.getNam() }
	                                </div>
	
	                                <div class="col-1">
	                                    <i class="fas fa-trash-alt trash" onclick="deleteChungChi('${cc.getMaChungChi()}')"></i>
	                                </div>
	                            </div>
	                            
                        	</c:forEach>
                            
                            
                            <a href="" data-bs-toggle="modal" data-bs-target="#myModalChungchi"><i
                                    class="fas fa-plus-square"></i>Thêm chứng chỉ</a>

                        </div>

                    </div>
                    <div class="taocv-item" onclick="showHuongdan('taocv-huongdan-sothich')">
                        <div class="row mb-3">
                            <label for="sothich" class="col-sm-11 col-form-label">
                                <h6>SỞ THÍCH</h6>
                            </label>
                            <div class="col-1">
                                <input type="checkbox"  name="sothich"/>
                            </div>
                        </div>
                        <div style="margin:0 10px 10px 20px;">
                        	<c:choose>
                        		<c:when test="${cv!=null&&cv.getSoThich()!=null }">
                        			<textarea name="soThich" rows="5" cols="20"  class="ckeditor">${cv.getSoThich() }</textarea>
                        		</c:when>
                        		<c:otherwise>
                        			<textarea name="soThich" rows="5" cols="20"  class="ckeditor"></textarea>
                        		</c:otherwise>
                        	</c:choose>
                            
                        </div>

                    </div>
                    <div class="taocv-item" onclick="showHuongdan('taocv-huongdan-muctieunghenghiep')">
                        <div class="row mb-3">
                            <label for="muctieu" class="col-sm-11 col-form-label">
                                <h6>MỤC TIÊU NGHỀ NGHIỆP</h6>
                            </label>
                            <div class="col-1">
                                <input type="checkbox" name="muctieunghenghiep" />
                            </div>
                        </div>
                        <div style="margin:0 10px 10px 20px;">
                        	<c:choose>
                        		<c:when test="${cv!=null&&cv.getMucTieuNgheNghiep()!=null }">
                        			<textarea name="mucTieuNgheNghiep" rows="5" cols="20"  class="ckeditor">${cv.getMucTieuNgheNghiep() }</textarea>
                        		</c:when>
                        		<c:otherwise>
                        			<textarea name="mucTieuNgheNghiep" rows="5" cols="20"  class="ckeditor"></textarea>
                        		</c:otherwise>
                        	</c:choose>
                            
                        </div>

                    </div>
                    <div class="taocv-item" onclick="showHuongdan('taocv-huongdan-hocvan')">
                        <div class="row mb-3">
                            <label class="col-sm-11 col-form-label">
                                <h6>HỌC VẤN</h6>
                            </label>
                            <div class="col-1">
                                <input type="checkbox"  name="hocvan"/>
                            </div>
                        </div>
                        <div style="margin-left: 20px;" id="hocvan">
        					<c:if test="${!hocVans.isEmpty() }">
                                    <ul >
                                    <c:forEach items="${hocVans }" var="hv">
			                            <li>
			                                <div class="row">
			                                	<div class="col-11">
			                                		<b>${hv.getTenDonVi() }</b>
			                                	</div>
			                                	<div class="col-1">
			                                		<i class="fas fa-trash-alt trash" onclick="deleteHocVan('${hv.getMaDonVi()}')"></i>
			                                	</div>
			                                </div>
			                                <c:forEach items="${viTriDAO.getAllViTriByMaDonVi(hv.getMaDonVi()) }" var="vt">
				                                <div class="row mb-3">
				                                	<div class="col-11">
				                                    <div class="row mb-2"    >
				                                        <div class="col-9">
				                                           <b><i>${vt.getTenViTri() }</i></b> 
				                                        </div>
				                                        <div class="col-3">
				                                            ${vt.getKhoangThoiGian() }
				                                        </div>
				                                        
				                                    </div>
				                                    <div style="margin-left: 20px;">
				                                            ${vt.getMoTa() }
				                                    </div>
				                                    </div>
				                                    <div class="col-1">
				                                    	<i class="fas fa-trash-alt trash" onclick="deleteViTriHocVan('${vt.getMaViTri()}')"></i>
				                                    </div>
				                                </div>
			                                </c:forEach>
			                                <a href="" data-bs-toggle="modal" data-bs-target="#myModalViTriHocVan${hv.getMaDonVi() }"><i class="fas fa-plus-square"></i> Thêm ngành, vị trí học tập</a>
			                            	<!-- The Modal vi tri Hoc Van-->
								                <div class="modal" id="myModalViTriHocVan${hv.getMaDonVi() }">
								                    <div class="modal-dialog">
								                        <div class="modal-content">
								
								                            <!-- Modal Header -->
								                            <div class="modal-header">
								                                <h4 class="modal-title">Thêm Vị Trí Học Vấn</h4>
								                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
								                            </div>
								
								                            <!-- Modal body -->
								                            
								                            <div class="modal-body">
								                                
								                                    <div class="mb-3 mt-3">
								                                        <label class="form-label">Vị trí<span class="required">
                                        												*</span></label>
								                                        <input type="text" class="form-control"  id="txtViTriHocVan${hv.getMaDonVi() }" placeholder="Sinh viên ngành Công nghệ thông tin">
								                                    	<small id="errorViTriHocVan" class="required"></small>
								                                    </div>
								                                    <div class="mb-3">
								                                        <label class="form-label">Khoảng thời gian<span class="required">
                                        														*</span></label>
								                                        <input type="text" class="form-control"  id="txtKhoangThoiGianHocVan${hv.getMaDonVi() }" placeholder="2018 - Nay">
								                                    	<small id="errorKhoangThoiGianHocVan" class="required"></small>
								                                    </div>
								                                    <div class="mb-3">
								                                        <label class="form-label">Mô tả:</label>
								                                        <textarea id="txtMoTaHocVan${hv.getMaDonVi() }" rows="5" cols="20" class="form-control"></textarea>
								                                        
								                                    </div>
								                                  
								                            </div>
								
								                            <!-- Modal footer -->
								                            <div class="modal-footer">
								                                <button type="button" class="btn btn-primary" onclick="addViTriHocVan('${hv.getMaDonVi() }')">Thêm</button>
								                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
								                                
								                            </div>
															
								                        </div>
								                    </div>
								                </div>
			                            </li>
			                            </c:forEach>
			                        </ul> 
                                    
                           
                                
                                </c:if>
                            </div>
                            <a href="" data-bs-toggle="modal" data-bs-target="#myModalTruongHoc"><i
                                    class="fas fa-plus-square"></i> Thêm trường học</a>
                       

                    </div>
                    <div class="taocv-item" onclick="showHuongdan('taocv-huongdan-kinhnghiemlamviec')">
                        <div class="row mb-3">
                            <label for="title" class="col-sm-11 col-form-label">
                                <h6>KINH NGHIỆM LÀM VIỆC</h6>
                            </label>
                            <div class="col-1">
                                <input type="checkbox" name="kinhnghiemlamviec" />
                            </div>
                        </div>
                        <div style="margin-left: 20px;" id="kinhnghiem">
        				<c:if test="${!kinhNghiems.isEmpty() }">
                                    <ul >
                                    <c:forEach items="${kinhNghiems }" var="kn">
			                            <li>
			                                <div class="row">
			                                	<div class="col-11">
			                                		<b>${kn.getTenDonVi() }</b>
			                                	</div>
			                                	<div class="col-1">
			                                		<i class="fas fa-trash-alt trash" onclick="deleteKinhNghiem('${kn.getMaDonVi()}')"></i>
			                                	</div>
			                                </div>
			                                <c:forEach items="${viTriDAO.getAllViTriByMaDonVi(kn.getMaDonVi()) }" var="vt">
				                                <div class="row mb-3">
				                                	<div class="col-11">
				                                    <div class="row mb-2"    >
				                                        <div class="col-9">
				                                           <b><i>${vt.getTenViTri() }</i></b> 
				                                        </div>
				                                        <div class="col-3">
				                                            ${vt.getKhoangThoiGian() }
				                                        </div>
				                                        
				                                    </div>
				                                    <div style="margin-left: 20px;">
				                                            ${vt.getMoTa() }
				                                    </div>
				                                    </div>
				                                    <div class="col-1">
				                                    	<i class="fas fa-trash-alt trash" onclick="deleteViTriLamViec('${vt.getMaViTri()}')"></i>
				                                    </div>
				                                </div>
			                                </c:forEach>
			                                <a href="" data-bs-toggle="modal" data-bs-target="#myModalViTriLamViec${kn.getMaDonVi() }"><i class="fas fa-plus-square"></i> Thêm vị trí, chức vụ làm việc</a>
			                            	<!-- The Modal vi tri Lam Viec-->
							                <div class="modal" id="myModalViTriLamViec${kn.getMaDonVi() }">
							                    <div class="modal-dialog">
							                        <div class="modal-content">
							
							                            <!-- Modal Header -->
							                            <div class="modal-header">
							                                <h4 class="modal-title">Thêm Vị Trí Làm Việc</h4>
							                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
							                            </div>
							
							                            <!-- Modal body -->
							                            
								                            <div class="modal-body">
								                                
								                                    <div class="mb-3 mt-3">
								                                        <label class="form-label">Vị trí<span class="required">
                                        												*</span></label>
								                                        <input type="text" class="form-control"  id="txtViTriLamViec${kn.getMaDonVi() }" placeholder="Trưởng phòng nhân sự">
								                                    	<small id="errorViTriLamViec" class="required"></small>
								                                    </div>
								                                    <div class="mb-3">
								                                        <label class="form-label">Khoảng thời gian<span class="required">
                                        														*</span></label>
								                                        <input type="text" class="form-control" id="txtKhoangThoiGianLamViec${kn.getMaDonVi() }" placeholder="2018 - Nay">
								                                    	<small id="errorKhoangThoiGianLamViec" class="required"></small>
								                                    </div>
								                                    <div class="mb-3">
								                                        <label class="form-label">Mô tả:</label>
								                                        <textarea id="txtMoTaLamViec${kn.getMaDonVi() }" rows="5" cols="20" class="form-control"></textarea>
								                                        
								                                    </div>
								                                  
								                            </div>
								
								                            <!-- Modal footer -->
								                            <div class="modal-footer">
								                                <button type="button" class="btn btn-primary" onclick="addViTriLamViec('${kn.getMaDonVi() }')">Thêm</button>
								                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
								                                
								                            </div>
															
							
							                        </div>
							                    </div>
							                </div>
			                            </li>
			                            </c:forEach>
			                        </ul> 
                                    
                           
                                
                                </c:if>                           
                                
                                
                            </div>
                            <a href="" data-bs-toggle="modal" data-bs-target="#myModalCongTy"><i
                                    class="fas fa-plus-square"></i> Thêm công ty</a>

                    </div>
                    <div class="taocv-item" onclick="showHuongdan('taocv-huongdan-hoatdong')">
                        <div class="row mb-3">
                            <label for="title" class="col-sm-11 col-form-label">
                                <h6>HOẠT ĐỘNG</h6>
                            </label>
                            <div class="col-1">
                                <input type="checkbox" name="hoatdong" />
                            </div>
                        </div>
                        <div style="margin-left: 20px;" id="hoatdong">
        					<c:if test="${!hoatDongs.isEmpty() }">
                                    <ul >
                                    <c:forEach items="${hoatDongs }" var="hd">
			                            <li>
			                                <div class="row">
			                                	<div class="col-11">
			                                		<b>${hd.getTenDonVi() }</b>
			                                	</div>
			                                	<div class="col-1">
			                                		<i class="fas fa-trash-alt trash" onclick="deleteHoatDong('${hd.getMaDonVi()}')"></i>
			                                	</div>
			                                </div>
			                                <c:forEach items="${viTriDAO.getAllViTriByMaDonVi(hd.getMaDonVi()) }" var="vt">
				                                <div class="row mb-3">
				                                	<div class="col-11">
				                                    <div class="row mb-2"    >
				                                        <div class="col-9">
				                                           <b><i>${vt.getTenViTri() }</i></b> 
				                                        </div>
				                                        <div class="col-3">
				                                            ${vt.getKhoangThoiGian() }
				                                        </div>
				                                        
				                                    </div>
				                                    <div style="margin-left: 20px;">
				                                            ${vt.getMoTa() }
				                                    </div>
				                                    </div>
				                                    <div class="col-1">
				                                    	<i class="fas fa-trash-alt trash" onclick="deleteViTriHoatDong('${vt.getMaViTri()}')"></i>
				                                    </div>
				                                </div>
			                                </c:forEach>
			                                <a href="" data-bs-toggle="modal" data-bs-target="#myModalViTriHoatDong${hd.getMaDonVi() }"><i class="fas fa-plus-square"></i> Thêm nhóm, bộ phận, chức vụ hoạt động</a>
			                            	<!-- The Modal vi tri Hoc Van-->
								                <div class="modal" id="myModalViTriHoatDong${hd.getMaDonVi() }">
								                    <div class="modal-dialog">
								                        <div class="modal-content">
								
								                            <!-- Modal Header -->
								                            <div class="modal-header">
								                                <h4 class="modal-title">Thêm Vị Trí Hoạt Động</h4>
								                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
								                            </div>
								
								                            <!-- Modal body -->
								                            
								                            <div class="modal-body">
								                                
								                                    <div class="mb-3 mt-3">
								                                        <label class="form-label">Vị trí<span class="required">
                                        												*</span></label>
								                                        <input type="text" class="form-control"  id="txtViTriHoatDong${hd.getMaDonVi() }" placeholder="Trưởng ban văn nghệ">
								                                    	<small id="errorViTriHoatDong" class="required"></small>
								                                    </div>
								                                    <div class="mb-3">
								                                        <label class="form-label">Khoảng thời gian<span class="required">
                                        														*</span></label>
								                                        <input type="text" class="form-control" id="txtKhoangThoiGianHoatDong${hd.getMaDonVi() }" placeholder="2018 - Nay">
								                                    	<small id="errorKhoangThoiGianHoatDong" class="required"></small>
								                                    </div>
								                                    <div class="mb-3">
								                                        <label class="form-label">Mô tả:</label>
								                                        <textarea id="txtMoTaHoatDong${hd.getMaDonVi() }" rows="5" cols="20" class="form-control"></textarea>
								                                        
								                                    </div>
								                                  
								                            </div>
								
								                            <!-- Modal footer -->
								                            <div class="modal-footer">
								                                <button type="button" class="btn btn-primary" onclick="addViTriHoatDong('${hd.getMaDonVi() }')">Thêm</button>
								                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
								                                
								                            </div>
															
								                        </div>
								                    </div>
								                </div>
			                            </li>
			                            </c:forEach>
			                        </ul> 
                                    
                           
                                
                                </c:if>
                            </div>
                            <a href="" data-bs-toggle="modal" data-bs-target="#myModalHoatDong"><i
                                    class="fas fa-plus-square"></i> Thêm đơn vị, câu lạc bộ</a>

                    </div>
                    <input type="hidden" name="showKyNang" id="showKyNang"/>
                    <input type="hidden" name="showSoThich" id="showSoThich"/>
                    <input type="hidden" name="showChungChi" id="showChungChi"/>
                    <input type="hidden" name="showMucTieuNgheNghiep" id="showMucTieuNgheNghiep"/>
                    <input type="hidden" name="showHocVan" id="showHocVan"/>
                    <input type="hidden" name="showKinhNghiemLamViec" id="showKinhNghiemLamViec"/>
                    <input type="hidden" name="showHoatDong" id="showHoatDong"/>
               
                    <div class="row mb-5">
                        <div class="col">
                        	<a href="/sinhvien/CV" class="btn btn-danger">Huỷ</a>
                            <button type="submit" class="btn btn-primary"  onclick="check()">Lưu CV</button>
                        </div>
                    </div>
                </form>
                <!-- The Modal Ky nang-->
                <div class="modal" id="myModalKynang">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Thêm Kỹ năng</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>

                            <!-- Modal body -->
                            
                            <div class="modal-body">
                                
                                    <div class="mb-3 mt-3">
                                        <label class="form-label">Tên kỹ năng<span
                                        class="required"> *</span></label>
                                        <input type="text" class="form-control" id="txtTenKyNang">
                                        <small id="errorTenKyNang" class="required"></small>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Độ thành thạo<span
                                        class="required"> *</span></label>
                                        <input type="number" min="1" max="10" class="form-control"  id="numDoThanhThao">
                                        <small id="errorDoThanhThao" class="required"></small>
                                    </div>
                                
                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" onclick="addKyNang()">Thêm</button>
                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                            </div>
							
                        </div>
                    </div>
                </div>
                <!-- The Modal Chung chi-->
                <div class="modal" id="myModalChungchi">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Thêm Chứng chỉ</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>

                            <!-- Modal body -->
                            
                            <div class="modal-body">
                                
                                    <div class="mb-3 mt-3">
                                        <label class="form-label">Tên chứng chỉ<span
                                        class="required"> *</span></label>
                                        <input type="text" class="form-control"  id="txtTenChungChi">
                                        <small id="errorTenChungChi" class="required"></small>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Năm<span
                                        class="required"> *</span></label>
                                        <input type="text" pattern="[0-9]{4}" class="form-control" id="txtNam">
                                        <small id="errorNam" class="required"></small>
                                    </div>
                                
                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" onclick="addChungChi()">Thêm</button>
                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                            </div>
							
                        </div>
                    </div>
                </div>
                
                <!-- The Modal Truong Hoc -->
                <div class="modal" id="myModalTruongHoc">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Thêm Trường học</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>
							
                            <!-- Modal body -->
                            <div class="modal-body">
                                
                                    <div class="mb-3 mt-3">
                                        <label class="form-label">Tên trường học<span
                                        class="required"> *</span></label>
                                        <input type="text" class="form-control" id="txtTenTruong" >
                                    	<small id="errorTenTruong" class="required"></small>
                                    </div>
                                
                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" onclick="addTruongHoc()">Thêm</button>
                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                            </div>
							
                        </div>
                    </div>
                </div>

                
                <!-- The Modal Cong Ty -->
                <div class="modal" id="myModalCongTy">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Thêm Công Ty</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">
                     
                                    <div class="mb-3 mt-3">
                                        <label class="form-label">Tên công ty:</label>
                                        <input type="text" class="form-control" id="txtTenCongTy" >
                                    	<small id="errorTenCongTy" class="required"></small>
                                    </div>
                               
                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary" onclick="addCongTy()">Thêm</button>
                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                            </div>

                        </div>
                    </div>
                </div>
                
                <!-- The Modal Hoat Dong -->
                <div class="modal" id="myModalHoatDong">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Thêm Đơn Vị Hoạt Động</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">
                                
                                    <div class="mb-3 mt-3">
                                        <label class="form-label">Tên đơn vị:</label>
                                        <input type="text" class="form-control" id="txtTenHoatDong" >
                                    	<small id="errorTenHoatDong" class="required"></small>
                                    </div>
                                
                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary" onclick="addHoatDong()">Thêm</button>
                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-4 taocv-right">
                <div class="taocv-huongdan">
                    <div class="taocv-huongdan-chung taocv-huongdan-item">
                        <h4>Hướng dẫn</h4>
                        <hr>
                        <ol>
                            <li>Điền đầy đủ các thông tin hiển thị trong CV</li>
                            <li>Bấm nút <b>Lưu CV</b></li>
                            <li>Xem & Tải CV về máy</li>

                        </ol>
                        Một số lưu ý:
                        <ul>
                            <li>Sắp xếp thời gian theo thứ tự mới -> cũ.</li>
                            <li>Ưu tiên những gì quan trọng, có liên quan đến vị trí ứng tuyển lên đầu.</li>
                            <li>Ngày tháng nên dùng: 01/2016, 01-2016 hoặc Jan 2016</li>
                        </ul>
                    </div>
                    <div class="taocv-huongdan-kynang taocv-huongdan-item">
                        <h4>Kỹ năng</h4>
                        <hr>
                        <b>Nên:</b>
                        <ul>
                            <li>Nêu ra các kỹ năng giúp ích cho vị trí ứng tuyển (tùy thuộc vào vị trí ứng tuyển và
                                những kỹ năng bạn có để đưa vào CV những kỹ năng phù hợp).</li>
                            <li>Chọn mức độ thành thạo kỹ năng (1-10)
                            </li>
                        </ul>
                        <b>Không nên:</b>
                        <ul>
                            <li>Đưa định nghĩa, quan điểm cá nhân.</li>
                        </ul>
                    </div>
                    <div class="taocv-huongdan-kinhnghiemlamviec taocv-huongdan-item">
                        <h4>Kinh nghiệm làm việc</h4>
                        <hr>
                        <b>Nên:</b>
                        <ul>
                            <li>Liệt kê theo thứ tự thời gian, công việc làm gần đây nhất nêu trước các công việc trước
                                đó.</li>
                            <li>Công việc đã làm (làm full-time hoặc part-time), khóa thực tập có liên quan đến vị trí
                                ứng tuyển.</li>
                            <li>Mô tả trách nhiệm công việc chính, súc tích nhưng đầy đủ. Đưa minh chứng (ví dụ sản phẩm
                                bạn thiết kế, link bài báo bạn viết…).</li>
                            <li>Đưa ra những thành tựu và kỹ năng bạn đạt được (cá nhân bạn học hỏi được cũng như sự
                                cống hiến cho công ty/tổ chức).</li>
                            <li>Nếu bạn chưa có kinh nghiệm, bạn chỉ tham gia công việc như tình nguyện, các việc làm
                                thêm như phát tờ rơi, bồi bàn…thì bạn có thể đề cập đến nhưng chú ý chỉ ra những điều
                                bạn học hỏi được cần có cho vị trí ứng tuyển ví dụ như khả năng làm việc nhóm, sự năng
                                động, sáng tạo và linh hoạt, sự kiên trì, đóng góp cho cộng đồng…).</li>
                            <li>Phân chia ý rõ ràng.</li>
                        </ul>
                        <b>Không nên:</b>
                        <ul>
                            <li>Các công việc làm ngắn hạn ( nhỏ hơn 6 tháng) ngoại trừ khóa thực tập.</li>
                            <li>Đưa quá chi tiết những phần công việc nhỏ nhặt (ví dụ như in giấy tờ, đến công ty sớm
                                dọn dẹp…).</li>
                            <li>Mô tả dài dòng, không phân chia ý rõ ràng.</li>
                            <li>Mô tả dài dòng, không phân chia ý rõ ràng.</li>
                            <li>Mô tả dài dòng, không phân chia ý rõ ràng.</li>
                            <li>Mô tả dài dòng, không phân chia ý rõ ràng.</li>
                        </ul>
                    </div>
                    <div class="taocv-huongdan-muctieunghenghiep taocv-huongdan-item">
                        <h4>Mục tiêu nghê nghiệp</h4>
                        <hr>
                        <b>Nên:</b>
                        <ul>
                            <li>Vị trí mong muốn ứng tuyển,có thể đề cập đến công ty ứng tuyển.</li>
                            <li>Thể hiện kỹ năng, kiến thức chuyên môn bạn có thể áp dụng vào vị trí công việc.</li>
                            <li>Có thể phân ra thành mục tiêu ngắn hạn như thành thạo công việc trong vòng…tháng và mục
                                tiêu dài hạn như cơ hội thăng tiến đến một vị trí nào đó.</li>
                            <li>Mục tiêu hướng đến lợi ích công ty như tăng doanh số, đẩy mạnh brand, mở rộng tập khách
                                hàng…</li>

                        </ul>
                        <b>Không nên:</b>
                        <ul>
                            <li>Viết mục tiêu chung chung như làm việc trong một môi trường năng động, có thể học hỏi
                                được nhiều… hoặc tìm kiếm vị trí phù hợp với bản thân để phát huy hết tất cả những kinh
                                nghiệm, kĩ năng của bản thân…</li>
                        </ul>
                    </div>
                    <div class="taocv-huongdan-thongtincanhan taocv-huongdan-item">
                        <h4>Thông tin cá nhân</h4>
                        <hr>
                        <ul>
                            <li>Viết đầy đủ họ tên của bạn.</li>
                            <li>Email cần nghiêm túc nên chứa họ tên bạn.</li>
                            <li>
                                Chèn ảnh đại diện: <br>
                                <b>Nên: </b>chèn ảnh phù hợp với vị trí ứng tuyển,nhìn thấy khuôn mặt trực diện.
                                <br><b>Không nên: </b>ảnh chỉ nhìn thấy một phần khuôn mặt hoặc quay lưng về phía trước.
                            </li>
                            <li style="color: red;"><u><i>Lưu ý:</i></u> Nếu thông tin không đủ hoặc muốn thay đổi thông tin, bạn cần thay đổi thông tin cá nhân tại trang tín chỉ.
                            </li>
                        </ul>
                    </div>
                    <div class="taocv-huongdan-hocvan taocv-huongdan-item">
                        <h4>Học vấn</h4>
                        <hr>
                        <b>Nên:</b>
                        <ul>
                            <li>Ngành học, trường học.</li>
                            <li>Một số môn chuyên ngành có tính ứng dụng cao ở công việc mà bạn đạt kết quả tốt thì bạn
                                có thể đề cập đến.</li>
                            <li>Đề án, nghiên cứu khoa học nếu có…(có liên quan đến vị trí ứng tuyển).</li>
                            <li>Đưa vào thành tích giải thưởng như học bổng, chứng chỉ</li>
                        </ul>
                        <b>Không nên:</b>
                        <ul>
                            <li>Đưa quá trình học tập từ cấp 1, cấp 2.</li>
                        </ul>
                    </div>
                    <div class="taocv-huongdan-sothich taocv-huongdan-item">
                        <h4>Sở thích</h4>
                        <hr>
                        Liệt kê một số sở thích cá nhân để giúp nhà tuyển dụng hiểu hơn về con người bạn.
                        Nên liệt kê thành các ý với gạch đầu dòng.
                    </div>
                    <div class="taocv-huongdan-chungchi taocv-huongdan-item">
                        <h4>Chứng chỉ</h4>
                        <hr>
                        <ul>
                            <li>Các khóa đào tạo kỹ năng mềm hay chuyên môn (đề cập thời gian, tổ chức, có thể chỉ ra
                                một vài những vấn đề về chuyên môn khi bạn được học ở khóa học mà có liên quan đến công
                                việc).</li>
                            <li>Chứng chỉ Tin học, Ngoại ngữ…(nếu có).</li>

                        </ul>

                    </div>
                    <div class="taocv-huongdan-hoatdong taocv-huongdan-item">
                        <h4>Hoạt động</h4>
                        <hr>
                        <ul>
                            <li>Liệt kê các hoạt động cộng đồng, tình nguyện,...</li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>
    	
    </div>
	
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    <script >  
        
        CKEDITOR.config.toolbar = [];  
        CKEDITOR.config.height = '150px';
        
    </script>
    <script>
	function addKyNang(){
		var txtTenKyNang = document.getElementById("txtTenKyNang").value;
		var numDoThanhThao = document.getElementById("numDoThanhThao").value;
		if(txtTenKyNang!=""&&numDoThanhThao!=""){
			
			document.getElementById("txtTenKyNang").value="";
			document.getElementById("numDoThanhThao").value=null;
			$('#myModalKynang').modal('hide');
			$.ajax({ 
			    type:"post", 
			    url: "/sinhvien/suaCV/addkynang", 
			    contentType: "application/x-www-form-urlencoded;charset=utf-8",
			    data: {
			    	tenKyNang: txtTenKyNang,
			    	doThanhThao: numDoThanhThao,
			    }, 
			    success: function(data) { 
			    	let row1 = document.getElementById("kynang");
			    	row1.innerHTML = data;
			    },
			    })
		}
		
	};
	function addChungChi(){
		var txtTenChungChi = document.getElementById("txtTenChungChi").value;
		var txtNam = document.getElementById("txtNam").value;
		if(txtTenChungChi!=""&&txtNam!=""){
			
			document.getElementById("txtTenChungChi").value="";
			document.getElementById("txtNam").value="";
			$('#myModalChungchi').modal('hide');
			$.ajax({ 
			    type:"post", 
			    url: "/sinhvien/suaCV/addChungChi", 
			    contentType: "application/x-www-form-urlencoded;charset=utf-8",
			    data: {
			    	tenChungChi: txtTenChungChi,
			    	nam: txtNam,
			    }, 
			    success: function(data) { 
			    	let row1 = document.getElementById("chungchi");
			    	row1.innerHTML = data;
			    },
			    })
		}
		
	};
	function deleteKyNang(id){
		console.log(id);
		$.ajax({ 
		    type:"post", 
		    url: "/sinhvien/suaCV/deletekynang", 
		    contentType: "application/x-www-form-urlencoded;charset=utf-8",
		    data: {
		    	maKyNang: id
		    }, 
		    success: function(data) { 
		    	let row = document.getElementById("kynang");
		    	row.innerHTML = data;
		    },
		})
	};
	function deleteChungChi(id){
		$.ajax({ 
		    type:"post", 
		    url: "/sinhvien/suaCV/deleteChungChi", 
		    contentType: "application/x-www-form-urlencoded;charset=utf-8",
		    data: {
		    	maChungChi: id
		    }, 
		    success: function(data) { 
		    	let row = document.getElementById("chungchi");
		    	row.innerHTML = data;
		    },
		})
	};
	function addViTriHocVan(id){
		console.log("txtViTriHocVan"+id);
		var txtViTriHocVan = document.getElementById("txtViTriHocVan"+id).value;
		var txtKhoangThoiGianHocVan = document.getElementById("txtKhoangThoiGianHocVan"+id).value;
		var txtMoTaHocVan = document.getElementById("txtMoTaHocVan"+id).value;
		
		if(txtViTriHocVan!=""&&txtKhoangThoiGianHocVan!=""){
			
			document.getElementById("txtViTriHocVan"+id).value="";
			document.getElementById("txtKhoangThoiGianHocVan"+id).value="";
			document.getElementById("txtMoTaHocVan"+id).value="";
			
			$('#myModalViTriHocVan'+id).modal('hide');
			$.ajax({ 
			    type:"post", 
			    url: "/sinhvien/suaCV/addViTriHocVan", 
			    contentType: "application/x-www-form-urlencoded;charset=utf-8",
			    data: {
			    	viTri: txtViTriHocVan,
			    	khoangThoiGian: txtKhoangThoiGianHocVan,
			    	moTa: txtMoTaHocVan,
			    	maDonVi: id
			    }, 
			    success: function(data) { 
			    	let row = document.getElementById("hocvan");
			    	row.innerHTML = data;
			    },
			    })
		}
		
	};
	function addViTriLamViec(id){
		var txtViTriLamViec = document.getElementById("txtViTriLamViec"+id).value;
		var txtKhoangThoiGianLamViec = document.getElementById("txtKhoangThoiGianLamViec"+id).value;
		var txtMoTaLamViec = document.getElementById("txtMoTaLamViec"+id).value;
		
		if(txtViTriLamViec=="") document.getElementById("errorViTriLamViec").innerText="Không được để trống";
		if(txtKhoangThoiGianLamViec=="") document.getElementById("errorKhoangThoiGianLamViec").innerText="Không được để trống";
		if(txtViTriLamViec!=""&&txtKhoangThoiGianLamViec!=""){
			
			document.getElementById("txtViTriLamViec"+id).value="";
			document.getElementById("txtKhoangThoiGianLamViec"+id).value="";
			document.getElementById("txtMoTaLamViec"+id).value="";
			
			$('#myModalViTriLamViec'+id).modal('hide');
			$.ajax({ 
			    type:"post", 
			    url: "/sinhvien/suaCV/addViTriLamViec", 
			    contentType: "application/x-www-form-urlencoded;charset=utf-8",
			    data: {
			    	viTri: txtViTriLamViec,
			    	khoangThoiGian: txtKhoangThoiGianLamViec,
			    	moTa: txtMoTaLamViec,
			    	maDonVi: id
			    }, 
			    success: function(data) { 
			    	let row = document.getElementById("kinhnghiem");
			    	row.innerHTML = data;
			    },
			    })
		}
		
		
	};
	function addViTriHoatDong(id){
		var txtViTriHoatDong = document.getElementById("txtViTriHoatDong"+id).value;
		var txtKhoangThoiGianHoatDong = document.getElementById("txtKhoangThoiGianHoatDong"+id).value;
		var txtMoTaHoatDong = document.getElementById("txtMoTaHoatDong"+id).value;
		
		if(txtViTriHoatDong!=""&&txtKhoangThoiGianHoatDong!=""){
			
			document.getElementById("txtViTriHoatDong"+id).value="";
			document.getElementById("txtKhoangThoiGianHoatDong"+id).value="";
			document.getElementById("txtMoTaHoatDong"+id).value="";
			
			$('#myModalViTriHoatDong'+id).modal('hide');
			$.ajax({ 
			    type:"post", 
			    url: "/sinhvien/suaCV/addViTriHoatDong", 
			    contentType: "application/x-www-form-urlencoded;charset=utf-8",
			    data: {
			    	viTri: txtViTriHoatDong,
			    	khoangThoiGian: txtKhoangThoiGianHoatDong,
			    	moTa: txtMoTaHoatDong,
			    	maDonVi: id
			    }, 
			    success: function(data) { 
			    	let row = document.getElementById("hoatdong");
			    	row.innerHTML = data;
			    },
			    })
		}
		
	};
	function addTruongHoc(){
		var txtTenTruong = document.getElementById("txtTenTruong").value;
		
		if(txtTenTruong!=""){
			
			document.getElementById("txtTenTruong").value="";
			$('#myModalTruongHoc').modal('hide');
			$.ajax({ 
			    type:"post", 
			    url: "/sinhvien/suaCV/addTruongHoc", 
			    contentType: "application/x-www-form-urlencoded;charset=utf-8",
			    data: {
			    	tenDonVi: txtTenTruong,
			    	
			    }, 
			    success: function(data) { 
			    	let row = document.getElementById("hocvan");
			    	row.innerHTML = data;
			    },
			    })
		}
		
	};
	function addCongTy(){
		var txtTenCongTy = document.getElementById("txtTenCongTy").value;
		
		if(txtTenCongTy!=""){
			
			document.getElementById("txtTenCongTy").value="";
			$('#myModalCongTy').modal('hide');
			$.ajax({ 
			    type:"post", 
			    url: "/sinhvien/suaCV/addCongTy", 
			    contentType: "application/x-www-form-urlencoded;charset=utf-8",
			    data: {
			    	tenDonVi: txtTenCongTy,
			    	
			    }, 
			    success: function(data) { 
			    	let row = document.getElementById("kinhnghiem");
			    	row.innerHTML = data;
			    },
			    })
		}
		
	};
	function addHoatDong(){
		var txtTenHoatDong = document.getElementById("txtTenHoatDong").value;
		
		if(txtTenHoatDong!=""){
			
			document.getElementById("txtTenHoatDong").value="";
			$('#myModalHoatDong').modal('hide');
			$.ajax({ 
			    type:"post", 
			    url: "/sinhvien/suaCV/addHoatDong", 
			    contentType: "application/x-www-form-urlencoded;charset=utf-8",
			    data: {
			    	tenDonVi: txtTenHoatDong,
			    	
			    }, 
			    success: function(data) { 
			    	let row = document.getElementById("hoatdong");
			    	row.innerHTML = data;
			    },
			    })
		}
		
	};
	function deleteHocVan(id){
		$.ajax({ 
		    type:"post", 
		    url: "/sinhvien/suaCV/deleteTruongHoc", 
		    contentType: "application/x-www-form-urlencoded;charset=utf-8",
		    data: {
		    	maDonVi: id,
		    	
		    }, 
		    success: function(data) { 
		    	let row = document.getElementById("hocvan");
		    	row.innerHTML = data;
		    },
		})
	};
	function deleteKinhNghiem(id){
		$.ajax({ 
		    type:"post", 
		    url: "/sinhvien/suaCV/deleteKinhNghiem", 
		    contentType: "application/x-www-form-urlencoded;charset=utf-8",
		    data: {
		    	maDonVi: id,
		    	
		    }, 
		    success: function(data) { 
		    	let row = document.getElementById("kinhnghiem");
		    	row.innerHTML = data;
		    },
		})
	};
	function deleteHoatDong(id){
		$.ajax({ 
		    type:"post", 
		    url: "/sinhvien/suaCV/deleteHoatDong", 
		    contentType: "application/x-www-form-urlencoded;charset=utf-8",
		    data: {
		    	maDonVi: id,
		    	
		    }, 
		    success: function(data) { 
		    	let row = document.getElementById("hoatdong");
		    	row.innerHTML = data;
		    },
		})
	};
	function deleteViTriHocVan(id){
		$.ajax({ 
		    type:"post", 
		    url: "/sinhvien/suaCV/deleteViTriHocVan", 
		    contentType: "application/x-www-form-urlencoded;charset=utf-8",
		    data: {
		    	maViTri: id,
		    	
		    }, 
		    success: function(data) { 
		    	let row = document.getElementById("hocvan");
		    	row.innerHTML = data;
		    },
		})
	};
	function deleteViTriLamViec(id){
		$.ajax({ 
		    type:"post", 
		    url: "/sinhvien/suaCV/deleteViTriLamViec", 
		    contentType: "application/x-www-form-urlencoded;charset=utf-8",
		    data: {
		    	maViTri: id,
		    	
		    }, 
		    success: function(data) { 
		    	let row = document.getElementById("kinhnghiem");
		    	row.innerHTML = data;
		    },
		})
	};
	function deleteViTriHoatDong(id){
		$.ajax({ 
		    type:"post", 
		    url: "/sinhvien/suaCV/deleteViTriHoatDong", 
		    contentType: "application/x-www-form-urlencoded;charset=utf-8",
		    data: {
		    	maViTri: id,
		    	
		    }, 
		    success: function(data) { 
		    	let row = document.getElementById("hoatdong");
		    	row.innerHTML = data;
		    },
		})
	};
	function check(){
		var kynang = document.getElementsByName('kynang');
        var sothich = document.getElementsByName('sothich');
        var chungchi = document.getElementsByName('chungchi');
        var muctieunghenghiep = document.getElementsByName('muctieunghenghiep');
        var hocvan = document.getElementsByName('hocvan');
        var kinhnghiemlamviec = document.getElementsByName('kinhnghiemlamviec');
        var hoatdong = document.getElementsByName('hoatdong');
        
        if(kynang[0].checked === true) document.getElementById('showKyNang').value=1;
        else document.getElementById('showKyNang').value=0;
        if(sothich[0].checked === true) document.getElementById('showSoThich').value=1;
        else document.getElementById('showSoThich').value=0;
        if(chungchi[0].checked === true) document.getElementById('showChungChi').value=1;
        else document.getElementById('showChungChi').value=0;
        if(muctieunghenghiep[0].checked === true) document.getElementById('showMucTieuNgheNghiep').value=1;
        else document.getElementById('showMucTieuNgheNghiep').value=0;
        if(hocvan[0].checked === true) document.getElementById('showHocVan').value=1;
        else document.getElementById('showHocVan').value=0;
        if(kinhnghiemlamviec[0].checked === true) document.getElementById('showKinhNghiemLamViec').value=1;
        else document.getElementById('showKinhNghiemLamViec').value=0;
        if(hoatdong[0].checked === true) document.getElementById('showHoatDong').value=1;
        else document.getElementById('showHoatDong').value=0;
        
	}; 
	</script>
</body>
</html>