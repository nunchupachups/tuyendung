<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>${title }</title>
	<jsp:include page="/WEB-INF/pages/layout/header.jsp" />
	<style type="text/css">
	#cke_1_top{
	display: none;
}
#cke_1_bottom{
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
        <form action="test" method="post">
          <textarea id="editor1" rows="5" cols="20" name="test1ti" class="ckeditor"></textarea>
          
          <div>${text }</div>
          
          <div id="hihi"></div>
          <div class="row mb-3">
            <div class="col-sm-11 offset-sm-1">
              <button type="submit" class="btn btn-primary">Đăng ký</button>
            </div>
          </div>
     <script >  
        // Cấu hình lại toolbar, hiển thị một vài Button.
        
        CKEDITOR.config.toolbar = [];
    
        // Cấu hình lại màu nền giao diện.
        CKEDITOR.config.resize_enabled = false;
        CKEDITOR.config.width = '500px';
        CKEDITOR.config.height = '70px';
        
    </script>
      </form>
    </div>
	
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
</body>
</html>