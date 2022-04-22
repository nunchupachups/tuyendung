<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>${title }</title>
	<jsp:include page="/WEB-INF/pages/layout/header.jsp" />
	<style type="text/css">
		#cke_1_top,#cke_2_top,#cke_3_top,#cke_1_bottom,#cke_2_bottom,#cke_3_bottom{
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
    <div style="height: 15px;"></div>
    <form class="row" action="/doanhnghiep/tuyendung/sua" method="post">
            <h3 style="color: rgb(6, 109, 70)" class="mb-5">Sửa tuyển dụng</h3>
            <h5 class="mb-3">Các tiêu chí nổi bật</h5>
            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label">Ngành nghề<span class="required"> *</span></label>
                <div class="col-4">
                    <select class="form-select" aria-label="Default select example" id="city" required="required" name="cmbNganhNghe" >
                        <c:forEach items="${dsNganhNghe }" var="nn">
                        	<c:if test="${nn.getMaNganhNghe()==tuyenDung.getMaNganhNghe()}">
                        		<option value="${nn.getMaNganhNghe() }" selected="selected">${nn.getTenNganhNghe() }</option>
                        	</c:if>
                        	<c:if test="${nn.getMaNganhNghe()!=tuyenDung.getMaNganhNghe()}">
                        		<option value="${nn.getMaNganhNghe() }">${nn.getTenNganhNghe() }</option>
                        	</c:if>
                        	
                        </c:forEach>
                      </select>
                </div>
                <label for="title" class="col-sm-2 col-form-label">Tên công việc<span class="required"> *</span></label>
                <div class="col-4">
                    <input type="text" class=" form-control" id="title" required="required" name="txtTenCongViec" value="${tuyenDung.getTenCongViec() }"/>
                </div>
            </div>
            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label">Hình thức làm việc<span class="required">
                        *</span></label>
                <div class="col-sm-4">
                    <select class="form-select" aria-label="Default select example" id="city" required="required"  name="cmbHinhThuc">
                        <c:forEach items="${dsHinhThuc }" var="ht">
                        	<c:if test="${ht.getMaHinhThuc()==tuyenDung.getMaHinhThuc()}">
                        		<option value="${ht.getMaHinhThuc() }" selected="selected">${ht.getTenHinhThuc() }</option>
                        	</c:if>
                        	<c:if test="${ht.getMaHinhThuc()!=tuyenDung.getMaHinhThuc()}">
                        		<option value="${ht.getMaHinhThuc() }">${ht.getTenHinhThuc() }</option>
                        	</c:if>
                        </c:forEach>
                      </select>
                </div>
                <label for="title" class="col-sm-2 col-form-label">Thời gian thử việc</label>
                <div class="col-sm-4">
                    <select class="form-select" aria-label="Default select example" id="city"  name="cmbThoiGianThuViec" >
                        <c:choose>
                        
                        <c:when test="${tuyenDung.getThoiGianThuViec().equals('6 Ngày') }">
                        	<option value="0">----------</option>
                        	<option value="6 Ngày" selected="selected">6 Ngày</option>
	                        <option value="1 Tháng">1 Tháng</option>
	                        <option value="2 Tháng">2 Tháng</option>
	                        <option value="3 Tháng">3 Tháng</option>
                        </c:when>
                        <c:when test="${tuyenDung.getThoiGianThuViec().equals('1 Tháng') }">
                        	<option value="0">----------</option>
                        	<option value="6 Ngày">6 Ngày</option>
	                        <option value="1 Tháng" selected="selected">1 Tháng</option>
	                        <option value="2 Tháng">2 Tháng</option>
	                        <option value="3 Tháng">3 Tháng</option>
                        </c:when>
                        <c:when test="${tuyenDung.getThoiGianThuViec().equals('2 Tháng') }">
                        	<option value="0">----------</option>
                        	<option value="6 Ngày">6 Ngày</option>
	                        <option value="1 Tháng">1 Tháng</option>
	                        <option value="2 Tháng" selected="selected">2 Tháng</option>
	                        <option value="3 Tháng">3 Tháng</option>
                        </c:when>
                        <c:when test="${tuyenDung.getThoiGianThuViec().equals('3 Tháng') }">
                        	<option value="0">----------</option>
                        	<option value="6 Ngày">6 Ngày</option>
	                        <option value="1 Tháng">1 Tháng</option>
	                        <option value="2 Tháng">2 Tháng</option>
	                        <option value="3 Tháng" selected="selected">3 Tháng</option>
                        </c:when>
                        <c:otherwise>
                        	<option selected value="0">----------</option>
                        	<option value="6 Ngày">6 Ngày</option>
	                        <option value="1 Tháng">1 Tháng</option>
	                        <option value="2 Tháng">2 Tháng</option>
	                        <option value="3 Tháng">3 Tháng</option>
                        </c:otherwise>
                        </c:choose>
                   
                      </select>
                </div>
            </div>
            
            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label">Sinh viên năm...</label>
                <div class="col-sm-4">
                    <select class="form-select" aria-label="Default select example" id="city"  name="cmbSinhVienNam">
                        <c:choose>
                        <c:when test="${tuyenDung.getSinhVienNam()==1 }">
                        	
                        	<option value="0">----------</option>
                        	<option value="1" selected="selected">1</option>
	                        <option value="2">2</option>
	                        <option value="3">3</option>
	                        <option value="4">4</option>
	                        <option value="5">5</option>
                        </c:when>
                        <c:when test="${tuyenDung.getSinhVienNam()==2 }">
                        	
                        	<option value="0">----------</option>
                        	<option value="1">1</option>
	                        <option value="2" selected="selected">2</option>
	                        <option value="3">3</option>
	                        <option value="4">4</option>
	                        <option value="5">5</option>
                        </c:when>
                        <c:when test="${tuyenDung.getSinhVienNam()==3 }">
                        	
                        	<option value="0">----------</option>
                        	<option value="1">1</option>
	                        <option value="2">2</option>
	                        <option value="3" selected="selected">3</option>
	                        <option value="4">4</option>
	                        <option value="5">5</option>
                        </c:when>
                        <c:when test="${tuyenDung.getSinhVienNam()==4 }">
                        	
                        	<option value="0">----------</option>
                        	<option value="1">1</option>
	                        <option value="2">2</option>
	                        <option value="3">3</option>
	                        <option value="4" selected="selected">4</option>
	                        <option value="5">5</option>
                        </c:when>
                        <c:when test="${tuyenDung.getSinhVienNam()==5 }">
                        	
                        	<option value="0">----------</option>
                        	<option value="1">1</option>
	                        <option value="2">2</option>
	                        <option value="3">3</option>
	                        <option value="4">4</option>
	                        <option value="5" selected="selected">5</option>
                        </c:when>
                        <c:otherwise>
                        	<option selected value="0">----------</option>
                        	<option value="1">1</option>
	                        <option value="2">2</option>
	                        <option value="3">3</option>
	                        <option value="4">4</option>
	                        <option value="5">5</option>
                        </c:otherwise>
                        </c:choose>
                      </select>
                </div>
                <label for="title" class="col-sm-2 col-form-label">Giới tính</label>
                <div class="col-sm-4">
                    <select class="form-select" aria-label="Default select example" id="city" name="cmbGioiTinh" >
                        <c:choose>
                        <c:when test="${tuyenDung.getGioiTinh().equals('Nam') }">
                        	<option value="0">----------</option>
                        	<option value="Nam" selected="selected">Nam</option>
	                        <option value="Nữ">Nữ</option>
	                        
                        </c:when>
                        <c:when test="${tuyenDung.getGioiTinh().equals('Nữ') }">
                        	<option value="0">----------</option>
                        	<option value="Nam">Nam</option>
	                        <option value="Nữ" selected="selected">Nữ</option>
                        </c:when>
                        <c:otherwise>
                        	<option selected value="0">----------</option>
                        	<option value="Nam">Nam</option>
	                        <option value="Nữ">Nữ</option>
                        </c:otherwise>
                        </c:choose>
                      </select>
                </div>
            </div>
            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label">Khu vực tuyển<span class="required"> *</span></label>
                <div class="col-sm-4">
                    <select class="form-select" aria-label="Default select example" id="city" required="required" name="cmbKhuVucTuyen">
                        <c:choose>
                        	<c:when test="${tuyenDung.getKhuVucTuyenDung().equals('Cả nước') }">
                        		<option value="Cả nước" selected="selected">Cả nước</option>
                        		<c:forEach items="${dsTinhThanh }" var="tt">
		                        	<option value="${tt.getTenTinhThanh() }">${tt.getTenTinhThanh() }</option>
		                        </c:forEach>
                        	</c:when>
                        	<c:otherwise>
                        		<c:forEach items="${dsTinhThanh }" var="tt">
                        			<c:if test="${tt.getTenTinhThanh().equals(tuyenDung.getKhuVucTuyenDung()) }">
                        				<option value="${tt.getTenTinhThanh() }" selected="selected">${tt.getTenTinhThanh() }</option>
                        			</c:if>
                        			<c:if test="${!tt.getTenTinhThanh().equals(tuyenDung.getKhuVucTuyenDung()) }">
                        				<option value="${tt.getTenTinhThanh() }">${tt.getTenTinhThanh() }</option>
                        			</c:if>
		                        	
		                        </c:forEach>
                        	</c:otherwise>
                        </c:choose>
                      </select>
                </div>
                <label for="title" class="col-sm-2 col-form-label">Số lượng tuyển<span class="required">
                        *</span></label>
                <div class="col-sm-4">
                    <input type="number" class="form-control" id="title" required="required" min="1" max="20" name="numSoLuong" value="${tuyenDung.getSoLuong() }" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label">Mức lương<span class="required"> *</span></label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="title" placeholder="5.000.000 - 6.500.000 VNĐ" required="required" name="txtMucLuong" value="${tuyenDung.getMucLuong() }" />
                </div>
                <label for="title" class="col-sm-2 col-form-label">Hạn đăng ký<span class="required"> *</span></label>
                <div class="col-sm-4">
                    <input type="date" class="form-control" id="title" name="dHanDangKy" required="required" value="${tuyenDung.getHanDangKy() }" />
                </div>
            </div>

            <h5 class="mb-3">Thông tin tuyển dụng</h5>
            <div class="row mb-3">
                <label for="content" class="col-sm-2 col-form-label">Tiêu đề<span class="required">
                        *</span></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="title" required="required" name="txtTieuDe" value="${tuyenDung.getTieuDe() }" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="image" class="col-sm-2 col-form-label">Mô tả công việc<span class="required">
                        *</span></label>
                <div class="col-sm-10">
                    <textarea id="post" class="form-control ckeditor" rows="5" required="required" name="txtMoTaCongViec" >${tuyenDung.getMoTaCongViec() }</textarea>
                </div>
            </div>
            <div class="row mb-3">
                <label for="post" class="col-sm-2 col-form-label">Yêu cầu công việc<span class="required">
                        *</span></label>
                <div class="col-sm-10">
                    <textarea id="post" class="form-control ckeditor" rows="5" required="required" name="txtYeuCauCongViec">${tuyenDung.getYeuCauCongViec() }</textarea>
                </div>
            </div>
            <div class="row mb-3">
                <label for="post" class="col-sm-2 col-form-label">Quyền lợi<span class="required"> *</span></label>
                <div class="col-sm-10">
                    <textarea id="post" class="form-control ckeditor" rows="5" required="required" name="txtQuyenLoi">${tuyenDung.getQuyenLoi() }</textarea>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-10 offset-sm-2">
                    <button type="submit" class="btn btn-primary">Sửa bài tuyển dụng</button>
                </div>
            </div>
            <input name="txtMaTuyenDung" value="${tuyenDung.getMaTuyenDung() }" style="visibility: hidden;"/>
        </form>
    	
	</div>
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    
    </div>
    <script >  

        CKEDITOR.config.toolbar = [];
        
    </script>
</body>
</html>