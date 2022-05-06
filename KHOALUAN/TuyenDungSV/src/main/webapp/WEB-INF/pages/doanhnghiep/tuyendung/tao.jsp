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
    <form class="row" action="/doanhnghiep/tuyendung/taotuyendung" method="post">
            <h3 style="color: rgb(6, 109, 70)" class="mb-5">Tạo tuyển dụng</h3>
            <h5 class="mb-3">Các tiêu chí nổi bật</h5>
            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label">Ngành nghề<span class="required"> *</span></label>
                <div class="col-4">
                    <select class="form-select" aria-label="Default select example" id="city" required="required" name="cmbNganhNghe" >
                        <c:forEach items="${dsNganhNghe }" var="nn">
                        	<option value="${nn.getMaNganhNghe() }">${nn.getTenNganhNghe() }</option>
                        </c:forEach>
                      </select>
                </div>
                <label for="title" class="col-sm-2 col-form-label">Tên công việc<span class="required"> *</span></label>
                <div class="col-4">
                    <input type="text" class=" form-control" id="title" required="required" name="txtTenCongViec"/>
                </div>
            </div>
            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label">Hình thức làm việc<span class="required">
                        *</span></label>
                <div class="col-sm-4">
                    <select class="form-select" aria-label="Default select example" id="city" required="required"  name="cmbHinhThuc">
                        <c:forEach items="${dsHinhThuc }" var="ht">
                        	<option value="${ht.getMaHinhThuc() }">${ht.getTenHinhThuc() }</option>
                        </c:forEach>
                      </select>
                </div>
                <label for="title" class="col-sm-2 col-form-label">Thời gian thử việc</label>
                <div class="col-sm-4">
                    <select class="form-select" aria-label="Default select example" id="city" name="cmbThoiGianThuViec" >
                        <option selected value="0">----------</option>
                        <option value="6 Ngày">6 Ngày</option>
                        <option value="1 Tháng">1 Tháng</option>
                        <option value="2 Tháng">2 Tháng</option>
                        <option value="3 Tháng">3 Tháng</option>
                   
                      </select>
                </div>
            </div>
            
            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label">Sinh viên năm...</label>
                <div class="col-sm-4">
                    <select class="form-select" aria-label="Default select example" id="city" name="cmbSinhVienNam">
                        <option selected value="0">----------</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                      </select>
                </div>
                <label for="title" class="col-sm-2 col-form-label">Giới tính</label>
                <div class="col-sm-4">
                    <select class="form-select" aria-label="Default select example" id="city" name="cmbGioiTinh" >
                        <option selected value="0">----------</option>
                        <option value="Nam">Nam</option>
                        <option value="Nữ">Nữ</option>
                      </select>
                </div>
            </div>
            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label">Khu vực tuyển<span class="required"> *</span></label>
                <div class="col-sm-4">
                    <select class="form-select" aria-label="Default select example" id="city" required="required" name="cmbKhuVucTuyen">
                        <option value="00">Cả nước</option>
                        <c:forEach items="${dsTinhThanh }" var="tt">
                        	<option value="${tt.getMaTinhThanh() }">${tt.getTenTinhThanh() }</option>
                        </c:forEach>
                      </select>
                </div>
                <label for="title" class="col-sm-2 col-form-label">Số lượng tuyển<span class="required">
                        *</span></label>
                <div class="col-sm-4">
                    <input type="number" class="form-control" id="title" required="required" min="1" max="20" name="numSoLuong" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label">Mức lương<span class="required"> *</span></label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="title" placeholder="5.000.000 - 6.500.000 VNĐ" required="required" name="txtMucLuong" />
                </div>
                <label for="title" class="col-sm-2 col-form-label">Hạn đăng ký<span class="required"> *</span></label>
                <div class="col-sm-4">
                    <input type="date" class="form-control" id="title" name="dHanDangKy" required="required" />
                </div>
            </div>

            <h5 class="mb-3">Thông tin tuyển dụng</h5>
            <div class="row mb-3">
                <label for="content" class="col-sm-2 col-form-label">Tiêu đề<span class="required">
                        *</span></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="title" required="required" name="txtTieuDe" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="image" class="col-sm-2 col-form-label">Mô tả công việc<span class="required">
                        *</span></label>
                <div class="col-sm-10">
                    <textarea id="post" class="form-control ckeditor" rows="5" required="required" name="txtMoTaCongViec"></textarea>
                </div>
            </div>
            <div class="row mb-3">
                <label for="post" class="col-sm-2 col-form-label">Yêu cầu công việc<span class="required">
                        *</span></label>
                <div class="col-sm-10">
                    <textarea id="post" class="form-control ckeditor" rows="5" required="required" name="txtYeuCauCongViec"></textarea>
                </div>
            </div>
            <div class="row mb-3">
                <label for="post" class="col-sm-2 col-form-label">Quyền lợi<span class="required"> *</span></label>
                <div class="col-sm-10">
                    <textarea id="post" class="form-control ckeditor" rows="5" required="required" name="txtQuyenLoi"></textarea>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-10 offset-sm-2">
                    <button type="submit" class="btn btn-primary">Thêm bài tuyển dụng</button>
                </div>
            </div>
        </form>
    	
	</div>
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    
    </div>
    <script >  

        CKEDITOR.config.toolbar = [];
        
    </script>
</body>
</html>