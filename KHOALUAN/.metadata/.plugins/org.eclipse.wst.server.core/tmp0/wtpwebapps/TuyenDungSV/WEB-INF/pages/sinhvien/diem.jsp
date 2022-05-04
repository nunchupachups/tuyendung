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
    	<h5><b>KẾT QUẢ HỌC TẬP</b></h5>
    <hr>


    <div class="row">
        <div class="col-2">
        	<span style="float:right;"><b>Khóa nhập học :</b></span>
        </div>
        <div class="col-10">
            ${khoa }
        </div>
    </div>

    <div class="row ">
        <div class="col-2">
        	<span style="float:right;"><b>Ngành học :</b></span>
        </div>
        <div class="col-10">
            ${nganh }
        </div>
    </div>
    <div class="row">
        <div class="col-2">
        	<span style="float:right;"><b>Số tín chỉ đã tích luỹ :</b></span>
        </div>
        <div class="col-2">
            ${soTinChi }
        </div>
        <div class="col-5">
        	<span style="float:right;"><b>Điểm trung bình tích luỹ 	:</b></span>
        </div>
        <div class="col-3">
            ${GPA }
        </div>
    </div>


<table class="table table-bordered table-hover" style="margin-top:20px">
    <thead style="background-color: #d2d2d2;">
        <tr>
            <th class="text-center" rowspan="2" style="width:100px">Mã<br />học phần</th>
            <th class="text-center" rowspan="2">Tên học phần</th>
            <th class="text-center" rowspan="2" style="width:40px">Số TC</th>
            <th class="text-center" colspan="3" style="width:210px">Điểm đánh giá học phần</th>
        </tr>
        <tr>
            <th class="text-center" style="width:70px">Hệ 10</th>
            <th class="text-center" style="width:70px">Đ.Chữ</th>
            <th class="text-center" style="width:70px">Hệ 4</th>
        </tr>
    </thead>
    <tbody>
    	<c:set var="hocky" value="0"></c:set>
    	<c:set var="namhoc" value="0"></c:set>
    	<c:forEach items="${ketQuas }" var="kq">
    	<c:if test="${kq.getHocKy()!=hocky||kq.getNamHoc()!=namhoc }">
           <tr style="background-color: #f2f2f2;">	
                    <td colspan="2" class="table-cell-title">
                        <b>Học kỳ: ${kq.getHocKy() } - Năm học: ${kq.getNamHoc() }</b>
                    </td>
                    <td colspan="6" class="table-cell-title">
                        Tổng số TC tích lũy: <b>${kq.getTongSoTinChiTheoKy() }</b>
                    </td>
                </tr>
	        <c:set var="hocky" value="${kq.getHocKy()}"></c:set>
	    	<c:set var="namhoc" value="${kq.getNamHoc()}"></c:set>
        </c:if>
            <tr>
                <td class="text-center">
                    ${kq.getMaHocPhan() }
                </td>
                <td>
                    ${kq.getTenHocPhan() }
                </td>
                <td class="text-center">${kq.getSoTinChi() }</td>
                <td class="text-center">${kq.getDiemHe10() }</td>
                <td class="text-center">${kq.getDiemChu() }</td>
                <td class="text-center">${kq.getDiemHe4() }</td>
            </tr>
           </c:forEach>
    </tbody>
</table>
    </div>
	
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    <a href="/sinhvien/CV/id?id=${maSinhVien}" style="text-decoration: none; color: black;">
    	<div class="btn-xemcv" >
    	<h5>Xem CV </h5>
    	</div>
    </a>
    <a href="/sinhvien/diem/id?id=${maSinhVien}" style="text-decoration: none; color: black;">
    	<div class="btn-xemdiem" style="background-color: orange;">
    	<h5>Xem điểm</h5>
    	</div>
    </a>
    
    
</body>
</html>