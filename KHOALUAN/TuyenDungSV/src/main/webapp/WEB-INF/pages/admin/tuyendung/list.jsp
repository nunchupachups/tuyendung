<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>${title }</title>
	<jsp:include page="/WEB-INF/pages/layout/header.jsp" />
	<style type="text/css">
		.active{
		background-color: transparent;}
	</style>
</head>
<body>
    <div class="bg">
    <jsp:include page="/WEB-INF/pages/layout/navbar.jsp" />
    <div style="height:70px;">
    </div>
    <div class="container">
    <div style="height: 15px;"></div>
    	<nav>
		  <div class="nav nav-tabs" id="nav-tab" role="tablist">
		    <button class="nav-link active" id="nav-chuaduyet-tab" data-bs-toggle="tab" data-bs-target="#nav-chuaduyet" type="button" role="tab" aria-controls="nav-chuaduyet" aria-selected="true">Tuyển dụng chưa duyệt (${tuyenDungChuaDuyets.size() })</button>
		    <button class="nav-link" id="nav-daduyet-tab" data-bs-toggle="tab" data-bs-target="#nav-daduyet" type="button" role="tab" aria-controls="nav-daduyet" aria-selected="false">Tuyển dụng đã duyệt (${tuyenDungDaDuyets.size() })</button>
		  </div>
		</nav>
		<div class="tab-content" id="nav-tabContent">
		  <div class="tab-pane fade show active" id="nav-chuaduyet" role="tabpanel" aria-labelledby="nav-chuaduyet-tab">
		  	<div style="margin: 50px 20px;">
		  	<c:if test="${tuyenDungChuaDuyets.isEmpty() }">
		    	<h4 style="color: #c0c0c0;">Không có tuyển dụng nào</h4>
		    	</c:if>
		        <c:forEach items="${tuyenDungChuaDuyets }" var="td">
		        	<div class="row">
			        	<div class="col-9">
			        	<h5><a style="text-decoration: none;" href="/admin/tuyendung/chitiet?id=${td.getMaTuyenDung() }">${td.getTieuDe() }</a></h5>
			        <h6><a style="text-decoration: none; color: black;" href="/admin/doanhnghiep/chitiet?id=${td.getMaDoanhNghiep() }">${doanhNghiepDAO.getDoanhNghiepById(td.getMaDoanhNghiep()).getTenDoanhNghiep().toUpperCase() }</a></h6>
			        	</div>
			        	<c:if test="${td.getPhanHoi()==null||td.getPhanHoi().equals('') }">
			            <div class="col-3 d-flex">
			            	<div >
				            	<form action="/admin/tuyendung/duyet" onsubmit="return duyet()" method="get">
								     <input type="hidden" value="${td.getMaTuyenDung() }" name="id"/>
								     <input style="margin-right: 10px;" class="btn btn-primary" type="submit" value="Duyệt"/>
								</form>
							</div>
				        		<div><a class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#myModal${td.getMaTuyenDung() }">Phản hồi</a></div>
				        	
			        	</div>
			            </c:if>
		        	</div>
		        	<hr>
		        	<!-- The Modal -->
		        <div class="modal" id="myModal${td.getMaTuyenDung() }">
		            <div class="modal-dialog">
		                <div class="modal-content">
		
		                    <!-- Modal Header -->
		                    <div class="modal-header">
		                        <h4 class="modal-title">Nhập nội dung phản hồi</h4>
		                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
		                    </div>
		
		                    <!-- Modal body -->
		                    <form action="/admin/tuyendung/phanhoi" method="post">
		                    <div class="modal-body">
		                    	<textarea class="form-control" rows="5" name="txtPhanHoi" placeholder="Không nhập quá 100 ký tự" maxlength="100"></textarea>
		                    	<input value="${td.getMaTuyenDung() }" name="txtMaTuyenDung" type="hidden"/>
		                    </div>
		
		                    <!-- Modal footer -->
		                    
		                    <div class="modal-footer">
		                        <button type="submit" class="btn btn-primary" >Gửi</button>
		                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
		                    </div>
							</form>
		                </div>
		            </div>
		        </div>
		        </c:forEach>
		  </div>
			</div>
		  <div class="tab-pane fade" id="nav-daduyet" role="tabpanel" aria-labelledby="nav-daduyet-tab">
		  	<div  style="margin: 50px 20px;">
		  	<c:if test="${tuyenDungDaDuyets.isEmpty() }">
		    	<h4 style="color: #c0c0c0;">Không có tuyển dụng nào</h4>
		    	</c:if>
		        <c:forEach items="${tuyenDungDaDuyets }" var="td">
		        	<h5><a style="text-decoration: none;" href="/admin/tuyendung/chitiet?id=${td.getMaTuyenDung() }">${td.getTieuDe() }</a></h5>
			        <h6><a style="text-decoration: none; color: black;" href="/admin/doanhnghiep/chitiet?id=${td.getMaDoanhNghiep() }">${doanhNghiepDAO.getDoanhNghiepById(td.getMaDoanhNghiep()).getTenDoanhNghiep().toUpperCase() }</a></h6>
		        	<hr>
		        </c:forEach>
			</div>
			</div>
		</div>
    </div>
	
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    <script>
    	function duyet(){
    		var kt = confirm("Duyệt bài tuyển dụng này?");
        	return kt;
        	
    	};
    </script>
</body>
</html>