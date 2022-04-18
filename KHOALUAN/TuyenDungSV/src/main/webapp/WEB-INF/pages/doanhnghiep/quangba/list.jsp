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
    <div class="container">
    	
        <div class="slideshow-container" >
        
        <div class="mySlide row" >
            <div class="col-6 slide-left ">
                <h1>Tiêu đề của slide đầu tiên!</h1>
                <p>Nội dung của slide đầu tiên</p>
                <button class="btn btn-primary btn-lg">
                    Xem thêm
                </button>
            </div>
            <div class="col-6 slide-right ">
                <img src="https://www.elleman.vn/wp-content/uploads/2019/03/06/cho-cung-ELLE-Man-1-475x661.jpg" >
    
            </div>
        
            <div class=" col-6 slide-left ">
                <h1>Tiêu đề của slide đầu 2!</h1>
                <div class="slide-content">
                    <p>Nội dung của slide đầu tiênNội dung của slide đầu tiênNội dung 
                        của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung 
                        của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu
                         tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung
                          của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu 
                          tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung
                           của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide 
                           đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội
                            dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của 
                            slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu 
                            tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung 
                            của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide
                             đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội 
                             dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của 
                             slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu 
                             tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội 
                             dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của 
                             slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu 
                             tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội
                              dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung 
                              của slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của 
                              slide đầu tiênNội dung của slide đầu tiênNội dung của slide đầu tiênNội dung của slide 
                              đầu tiênNội dung của slide đầu tiên</p>
                </div>
                
                <button class="btn btn-primary btn-lg" style="margin-top: 10px;">
                    Xem thêm
                </button>
            </div>
            <div class="col-6 slide-right ">
                <img src="https://cdn.tgdd.vn/Files/2021/04/18/1344307/top-7-giong-cho-dep-nhat-the-gioi-ma-ban-khong-the-bo-qua-202104181556208411.png" >
            </div>
        
            <div style="text-align:center" class="dots">
                <span class="dot" onclick="currentSlide(0)"></span> 
                <span class="dot" onclick="currentSlide(1)"></span> 
                <span class="dot" onclick="currentSlide(2)"></span> 
              </div>
        </div>
        
      </div>
      
      <form class="row" method="post" action="/doanhnghiep/quangba">
            <h3 style="color: rgb(6, 109, 70)" class="mb-5 mt-5">Thêm bài quảng bá mới</h3>

            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label">Tiêu đề<span class="required"> *</span></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="title" name="txtTieuDe" required="required" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="content" class="col-sm-2 col-form-label">Nội dung đại diện<span class="required">
                        *</span></label>
                <div class="col-sm-10">
                    <textarea id="content" class="form-control" name="txtNoiDung" rows="3" required="required"></textarea>
                </div>
            </div>
            <div class="row mb-3">
                <label for="image" class="col-sm-2 col-form-label">Hình ảnh đại diện<span class="required">
                        *</span></label>
                <div class="col-sm-10">
                    <input class="form-control" type="file" id="image" name="imgAnhDaiDien" required="required" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="post" class="col-sm-2 col-form-label">Bài viết<span class="required"> *</span></label>
                <div class="col-sm-10">
                    <textarea id="post" class="form-control ckeditor"  name="txtBaiViet" required="required"></textarea>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-10 offset-sm-2">
                    <button type="submit" class="btn btn-primary">Thêm</button>
                </div>
            </div>
        </form>
    </div>
    
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    <script>
        //khai báo biến slideIndex đại diện cho slide hiện tại
        var slideIndex;
        // KHai bào hàm hiển thị slide
        function showSlides() {
            var i;
            var slidel = document.getElementsByClassName("slide-left");
            var slider = document.getElementsByClassName("slide-right");
            var dots = document.getElementsByClassName("dot");
            for (i = 0; i < slidel.length; i++) {
               slidel[i].style.display = "none";  
               slider[i].style.display = "none";  
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
       
            slidel[slideIndex].style.display = "block"; 
            slider[slideIndex].style.display = "block"; 
            dots[slideIndex].className += " active";
            //chuyển đến slide tiếp theo
            slideIndex++;
            //nếu đang ở slide cuối cùng thì chuyển về slide đầu
            if (slideIndex > slidel.length - 1) {
              slideIndex = 0
            }    
            //tự động chuyển đổi slide sau 5s
            setTimeout(showSlides, 5000);
        }
        //mặc định hiển thị slide đầu tiên 
        showSlides(slideIndex = 0);
       
       
        function currentSlide(n) {
          showSlides(slideIndex = n);
        }
      </script>

</body>
</html>