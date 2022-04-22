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
    <c:if test="${msg1!=null }">
      			<div class="alert alert-success alert-dismissible mt-3">
      			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      				${msg1 } 
      			</div>
    	</c:if> 
    	<c:if test="${msg2!=null }">
      			<div class="alert alert-danger alert-dismissible mt-3">
      			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      				${msg2 } 
      			</div>
    	</c:if> 
    
    <div class="row">
            <div class="col-4 cv-left" >
                <div class="d-flex">
                    <img class="avatar" src="${contextPath }/image/2227baef989555cb0c84.jpg" style="display: block;">
                    
                </div>
                <div style="text-align: center;">
                     <p style="font-size: 17px;font-weight: bold; margin: 15px 0 5px 0; margin-top: 15px; margin-bottom: 5px;">DƯƠNG THỊ KIỀU TRANG</p>
                     <p style="font-size: 14px;">WEB DEVELOPER</p> 
                     <hr>
                </div>  
                <div class="info">
                    <div class="row">
                        <div class="contact-icon col-2"><i class="fas fa-calendar-alt"></i></div>
                        <div class="contact-info col-10">13/06/2000</div>
                    </div>
                    <div class="row">
                        <div class="contact-icon col-2"><i class="fas fa-user"></i></div>
                        <div class="contact-info col-10">Nữ</div>
                    </div>
                    <div class="row">
                        <div class="contact-icon col-2"><i class="fas fa-phone-alt"></i></div>
                        <div class="contact-info col-10">0944510246</div>
                    </div>
                    <div class="row">
                        <div class="contact-icon col-2"><i class="fas fa-envelope"></i></div>
                        <div class="contact-info col-10">trang@gmail.com</div>
                    </div>
                    <div class="row">
                        <div class="contact-icon col-2"><i class="fas fa-map-marker-alt"></i></div>
                        <div class="contact-info col-10">An Cựu, Huế</div>
                    </div>
                    
                </div>
                <div class="cv-left-item">
                    <h5 style="margin-bottom: 20px;">MỤC TIÊU NGHỀ NGHIỆP</h5>
                    <ul class="cv-right-item-mota">
                        <li>
                            Ngắn hạn: Được tham gia đào tạo tại công ty, tích lũy thêm nhiều kinh nghiệm, 
                            rèn luyện thêm nhiều kỹ năng xử lí công việc. Có công việc ổn định.
                        </li>
                        <li>
                            Dài hạn: Trở thành nhân viên ưu tú, có cơ hội làm việc tại nước ngoài, đạt được mức lương cao.
                        </li>
                    </ul> 
                </div>
                <div class="cv-left-item">
                    <h5 style="margin-bottom: 20px;">KỸ NĂNG</h5>
                    <div>
                        <div>HTML</div>
                        <div>
                            <div style="height: 10px; background-color: white;">
                                <div style="height: 10px;width: 50%;background-color: #548CA8;"></div>
                            </div>
                        </div>
                    </div>
                    <div class="mt-2">
                        <div>HTML</div>
                        <div>
                            <div style="height: 10px; background-color: white;">
                                <div style="height: 10px;width: 40%;background-color: #548CA8;"></div>
                            </div>
                        </div>
                    </div>
                    <div class="mt-2">
                        <div>HTML</div>
                        <div>
                            <div style="height: 10px; background-color: white;">
                                <div style="height: 10px;width: 80%;background-color: #548CA8;"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="cv-left-item">
                    <h5 style="margin-bottom: 20px;">SỞ THÍCH</h5>
                    <ul>
                        <li>Đọc sách</li>
                        <li>Nghe nhạc</li>
                    </ul>
                </div>
            </div>
            <div class="col-8 cv-right">
                
                <div class="cv-right-item">
                    <div class="cv-right-item-name"><h5 >HỌC VẤN</h5></div>
                        <ul>
                            <li>
                                <div><b> Trường Đại học Khoa học Huế</b></div>
                                <div>
                                    <div class="row mb-2"    >
                                        <div class="col-8">
                                            Sinh viên khoa Công nghệ thông tin
                                        </div>
                                        <div class="col-4">
                                            08/2018 - Hiện tại
                                        </div>
                                        
                                    </div>
                                    <ul class="cv-right-item-mota">
                                        <li>
                                            Mô tả một chút nha hihiMô tả một chút nha hihiMô tả một 
                                            chút nha hihiMô tả một chút nha hihiMô tả một chút nha hihiMô tả 
                                            một chút nha hihiMô tả một chút nha hihi
                                        </li>
                                        <li>
                                            Mô tả một chút nha hihi
                                        </li>
                                    </ul>
                                </div>
                            </li>
                        </ul> 
                </div>
                <div class="cv-right-item">
                    <div class="cv-right-item-name"><h5 >KINH NGHIỆM LÀM VIỆC</h5></div>
                    <ul>
                        <li>
                            <div><b> Trường Đại học Khoa học Huế</b></div>
                            <div>
                                <div class="row mb-2"    >
                                    <div class="col-8">
                                        Sinh viên khoa Công nghệ thông tin
                                    </div>
                                    <div class="col-4">
                                        08/2018 - Hiện tại
                                    </div>
                                    
                                </div>
                                <ul class="cv-right-item-mota">
                                    <li>
                                        Mô tả một chút nha hihiMô tả một chút nha hihiMô tả một 
                                        chút nha hihiMô tả một chút nha hihiMô tả một chút nha hihiMô tả 
                                        một chút nha hihiMô tả một chút nha hihi
                                    </li>
                                    <li>
                                        Mô tả một chút nha hihi
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul> 
                    
                </div>
                <div class="cv-right-item">
                    <div class="cv-right-item-name"><h5 >HOẠT ĐỘNG</h5></div>
                    <ul>
                        <li>
                            <div><b> Trường Đại học Khoa học Huế</b></div>
                            <div>
                                <div class="row mb-2"    >
                                    <div class="col-8">
                                        Sinh viên khoa Công nghệ thông tin
                                    </div>
                                    <div class="col-4">
                                        08/2018 - Hiện tại
                                    </div>
                                    
                                </div>
                                <ul class="cv-right-item-mota">
                                    <li>
                                        Mô tả một chút nha hihiMô tả một chút nha hihiMô tả một 
                                        chút nha hihiMô tả một chút nha hihiMô tả một chút nha hihiMô tả 
                                        một chút nha hihiMô tả một chút nha hihi
                                    </li>
                                    <li>
                                        Mô tả một chút nha hihi
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul> 
                    
                </div>
                <div class="cv-right-item">
                    <div class="cv-right-item-name"><h5 >CHỨNG CHỈ</h5></div>
                    <div class="row mb-2" style="margin-left: 20px;"   >
                        <div class="col-8 chungchi-name">
                            N4 Tiếng Nhật
                        </div>
                        <div class="col-4">
                            2018
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
	
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
</body>
</html>