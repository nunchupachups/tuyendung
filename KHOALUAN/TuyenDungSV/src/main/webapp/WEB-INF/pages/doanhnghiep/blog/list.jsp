<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <div class="container" > 
    <div style="height: 15px;"></div>
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
    	<div class="col-9">
        	<input type="text" class="form-control" id="key" placeholder="Tên tác giả, tiêu đề blog...	" >
        </div>
        <div class="col-1">
            <button class="btn btn-primary" onclick="timKiemBlog()"><i class="fas fa-search"></i></button>
        </div>
        <div class="col-2">
            <a class="btn btn-primary" href="/doanhnghiep/blog/tao" >Tạo blog</a>
        </div>
    </div>
    <hr>
    <div id="blog">
    
    	<c:if test="${blogs.isEmpty() }">
    	<h4 style="color: #c0c0c0;">Không tìm thấy bài viết nào phù hợp với yêu cầu tìm kiếm của bạn</h4>
    	</c:if>
    	<div class="row">
    	
    	
        <c:forEach items="${blogs }" var="b">
        	<div style="height:500px;width: 33%; margin-bottom: 20px;position: relative;">
			  <a href="/doanhnghiep/blog/chitiet?id=${b.getMaBlog() }" style="color: black;text-decoration: none;">
			  	<div style="height: 500px;width:100%; display: flex;flex-direction: column;box-shadow: 5px 5px 6px #00000029;	">
					   <div style="height: 320px;">
					   	<img style="width: 100%; height: 100%;" src="${contextPath }/${b.getAnh()}">
					   </div>
					   <div style="padding: 15px;">
					   		<h4>${b.getTieuDe() }</h4>
					   </div>
					   <c:if test="${b.isDaDuyet() }">
					   		<div style="position: absolute; background-color: #00B14F; bottom: 10px; right: 20px; color: white;padding: 5px;">Đã Duyệt</div>
					   </c:if>
					   <c:if test="${!b.isDaDuyet() }">
					   		<div style="position: absolute; background-color: #E7747D; bottom: 10px; right: 20px;color: white;padding: 5px;">Chưa Duyệt</div>
					   </c:if>
					   
				</div>
				</a>
			  </div>
        </c:forEach>
        </div>
        <c:if test="${soPage>1 }">
        	<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item disabled">
      <a class="page-link" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <c:forEach var="i" begin="1" end="${soPage }">
    	<c:if test="${i<4 }">
    		<li class="page-item" onclick="timKiemBlog(${i})"><a class="page-link" >${i }</a></li>
    	</c:if>
    </c:forEach>
    <li class="page-item">
      <a class="page-link" onclick="timKiemBlog(2)" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
       </c:if>
       </div>
       
       
    </div>
	
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    <script>
   
	function timKiemBlog(page){
    	var key=document.getElementById("key").value;
		$.ajax({ 
		    type:"post", 
		    url: "/doanhnghiep/blog/timkiem/page", 
		    contentType: "application/x-www-form-urlencoded;charset=utf-8",
		    data: {
		    	key: key,
		    	page: page
		    }, 
		    success: function(data) { 
		    	let row = document.getElementById("blog");
		    	row.innerHTML = data;
		    },
		})
	};
	
    </script>
</body>
</html>