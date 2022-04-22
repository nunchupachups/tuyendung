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
        <c:if test="${!dsQuangBa.isEmpty() }">
	        <div class="mySlide row" >
	        
	        	<c:forEach items="${dsQuangBa}" var="qb">
	        		<div class="col-6 slide-left ">
		                <h1>${qb.getTieuDe() }</h1>
		                <p>${qb.getNoiDungDaiDien() }</p>
		                <button class="btn btn-primary btn-lg">
		                    <a href="/doanhnghiep/quangba/chitiet?id=${qb.getMaQuangBa() }" style="color: white; text-decoration: none;">Xem thêm</a>
		                </button>
		            </div>
		            <div class="col-6 slide-right ">
		                <img src="${contextPath }/${qb.getHinhAnhDaiDien() }" >
		    
		            </div>
	        	</c:forEach>
	        	<div style="text-align:center" class="dots">
	            <c:forEach items="${dsQuangBa}" varStatus="theCount">
		            <span class="dot" onclick="currentSlide(${theCount.index})"></span> 
	        	</c:forEach>
	        	</div>
	        </div>
        </c:if>
      </div>
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
      <form class="row" method="post" action="/doanhnghiep/quangba" enctype="multipart/form-data">
            <h3 style="color: rgb(6, 109, 70)" class="mb-5 mt-4">Thêm bài quảng bá mới</h3>

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