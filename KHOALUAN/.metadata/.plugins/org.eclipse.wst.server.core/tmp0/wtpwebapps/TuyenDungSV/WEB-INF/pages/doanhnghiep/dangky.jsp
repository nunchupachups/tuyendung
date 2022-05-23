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
	<style type="text/css">
		.modal-dialog{
			max-width: 1300px;
		}
		.modal-body{
			margin: 20px 77px ;
		}
	</style>
</head>
<body>
    <div class="bg">
    <jsp:include page="/WEB-INF/pages/layout/navbar.jsp" />
    <div style="height:70px;">
    </div>
    <div class="container">
    	<div style="height:20px;">
    	</div>
        <form class="row " method="post" onsubmit="return checkEmailDangNhap();" action="/doanhnghiep/dangky" enctype="multipart/form-data">
          <h3 style="color: rgb(6, 109, 70);" class="mb-5">Đăng ký tài khoản doanh nghiệp</h3>
          <!-- Thong tin dang nhap -->
          <div class="mb-4 mySlides" >
            <h5 class="mb-3">Thông tin đăng nhập</h5>
            <div class="row mb-3">
              <label for="email" class="col-sm-2 col-form-label" >Email đăng nhập<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="email" class="form-control" id="email" name="txtEmail">
                <small id="errorEmail" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="password" class="col-sm-2 col-form-label">Mật khẩu<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="password" class="form-control" id="password" name="txtMatKhau" >
                <small><i><b>Lưu ý: </b>Mật khẩu tối thiểu 8 ký tự, trong đó có ít nhất 1 ký tự chữ thường, 1 ký tự chữ hoa và 1 ký tự số.</i></small>
                <br><small id="errorPassword" style="color: red;"></small>
              </div>

            </div>
            <div class="row mb-3">
              <label for="rePassword" class="col-sm-2 col-form-label">Xác nhận mật khẩu<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="password" class="form-control" id="rePassword">
                <small id="errorRePassword" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-sm-10 offset-sm-2">
                <button type="button" class="btn btn-outline-secondary" onclick="validateThongTinDangNhap()">Tiếp <i class="fas fa-arrow-right"></i></button>
              </div>
            </div>
          </div>
          <!-- thong tin lien he -->
          <div class="mb-4 mySlides" style="display: none;">
            <h5 class="mb-3">Thông tin liên hệ</h5>
            <div class="row mb-3">
              <label for="contactName" class="col-sm-2 col-form-label" >Tên người liên hệ<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="contactName" name="txtTenLienHe" >
                <small id="errorContactName" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="contactEmail" class="col-sm-2 col-form-label">Email liên hệ<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="email" class="form-control" id="contactEmail" name="txtEmailLienHe" >
                <small id="errorContactEmail" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="contactTel" class="col-sm-2 col-form-label">Điện thoại<span class="required"> *</span></label>
              <div class="col-sm-10">
                <input type="tel" class="form-control" id="contactTel" name="txtSoDienThoai"  placeholder="0376551445" >
                <small><i><b>Lưu ý: </b>Các thuê bao di động đã chuyển về 10 số. Vui lòng nhập thông tin theo đầu số mới.</i></small>
                <br><small id="errorContactTel" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-sm-10 offset-sm-2">
                <button type="button" class="btn btn-outline-secondary" style="margin-right: 10px;" onclick="currentSlide(0)"><i class="fas fa-arrow-left"></i> Trở lại </button>
                <button type="button" class="btn btn-outline-secondary"onclick="validateThongTinLienHe()">Tiếp <i class="fas fa-arrow-right"></i></button>
              </div>
            </div>
          </div>

          <!-- thong tin doanh nghiep -->
          <div class="mb-4 mySlides" style="display: none;">
            <h5 class="mb-3">Thông tin doanh nghiệp</h5>
            <div class="row mb-3">
              <label for="enterpriseName" class="col-sm-3 col-form-label" >Tên pháp lý của doanh nghiệp<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="text" class="form-control" id="enterpriseName" name="txtTenDoanhNghiep">
                <small id="errorEnterpriseName" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="taxCode" class="col-sm-3 col-form-label">Mã số thuế<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="text" class="form-control" id="taxCode" name="txtMaSoThue" >
                <small id="errorTaxCode" style="color: red;"></small>
              </div>
            </div>
            

            <div class="row mb-3">
              <label for="city" class="col-sm-3 col-form-label">Chọn Tỉnh/Thành phố<span class="required"> *</span></label>
              <div class="col-sm-9">
                <select class="form-select" aria-label="Default select example" id="city" name="cmbTinhThanh" onchange="setQuanHuyen()">
	        		<option disabled selected value="">----------</option>
	        		<c:forEach items="${dsTinhThanh }" var="tt">

	        			<option value="${tt.getMaTinhThanh()}">${tt.getTenTinhThanh() }</option> 
	        		</c:forEach>
	        		
                </select>
                <small id="errorCity" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="district" class="col-sm-3 col-form-label">Chọn Quận/Huyện<span class="required"> *</span></label>
              <div class="col-sm-9">
                <select class="form-select" aria-label="Default select example" id="district" name="cmbQuanHuyen" onchange="setXaPhuong()">              
                	<option disabled selected value="">----------</option>
                </select>
                <small id="errorDistrict" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="ward" class="col-sm-3 col-form-label">Chọn Xã/Phường/Thị trấn<span class="required"> *</span></label>
              <div class="col-sm-9">
                <select class="form-select" aria-label="Default select example" id="ward" name="cmbXaPhuong" > 
                	
                </select>
                <small id="errorWard" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="street" class="col-sm-3 col-form-label">Địa chỉ đường<span class="required"> *</span></label>
              <div class="col-sm-9">
                <input type="text" class="form-control" id="street" name="txtDiaChiDuong">
                <small id="errorStreet" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="field" class="col-sm-3 col-form-label">Chọn lĩnh vực hoạt động<span class="required"> *</span></label>
              <div class="col-sm-9">
                <select class="form-select" aria-label="Default select example" id="field" name="cmbLinhVucHoatDong" >
                  <c:forEach items="${dsLinhVuc }" var="lv">
                	<optgroup title="${lv.getTenLinhVuc() }" label="${lv.getTenLinhVuc() }">
                		<c:forEach items="${linhVucHoatDongCap2DAO.getAllLinhVucHoatDongByIdCap1(lv.getMaLinhVuc()) }" var="lvc1">
                			<option title="${lvc1.getTenLinhVuc() }" value="${lvc1.getMaLinhVuc() }">${lvc1.getTenLinhVuc() }</option>
                		</c:forEach>
                	</optgroup>
        			
        			</c:forEach>
                </select>
                <small id="errorField" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <label for="enterpriseType" class="col-sm-3 col-form-label">Chọn loại hình doanh nghiệp<span class="required"> *</span></label>
              <div class="col-sm-9">
                <select class="form-select" aria-label="Default select example" id="enterpriseType" name="cmbLoaiHinhDoanhNghiep" required="required">
                  <c:forEach items="${dsLoaiHinhDoanhNghiep }" var="lhdn">
        			<option value="${lhdn.getMaLoaiHinhDoanhNghiep() }">${lhdn.getTenLoaiHinhDoanhNghiep() }</option>
        			</c:forEach>
                </select>
                <small id="errorEnterpriseType" style="color: red;"></small>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-sm-9 offset-sm-3">
                <button type="button" class="btn btn-outline-secondary" style="margin-right: 10px;" onclick="currentSlide(1)"><i class="fas fa-arrow-left"></i> Trở lại </button>
                <button type="button" class="btn btn-outline-secondary" onclick="validateThongTinDoanhNghiep()">Tiếp <i class="fas fa-arrow-right"></i></button>
              </div>
            </div>
          </div>
          <div class="mb-4 mySlides" style="display: none;">  
            <h5 class="mb-3">Chứng minh doanh nghiệp</h5>
            <div class="row mb-3">
              <label for="certificate" class="col-sm-6 col-form-label">Tải lên giấy phép kinh doanh/Giấy chứng nhận thành lập công ty/Giấy chứng nhận đăng ký thuế của doanh nghiệp<span class="required"> *</span></label>
              <div class="col-sm-6">
                <input class="form-control" type="file" id="certificate" multiple required="required" name="giayChungNhan" accept="image/*">
              </div>
            </div>
          
          
          <div class="row mb-3">
            <div class="col-sm-11 offset-sm-1">
              <button type="button" class="btn btn-outline-secondary" style="margin-right: 10px;" onclick="currentSlide(2)"><i class="fas fa-arrow-left"></i> Trở lại </button>
            </div>
          </div>
          <!-- button Dangky -->
          <div class="row mb-3"> 
            <div class="col-sm-11 offset-sm-1">
              <small><i>Bằng việc nhấn nút Đăng ký, Quý khách đã đồng ý với <a href="" data-bs-toggle="modal" data-bs-target="#myModalDieuKhoanDichVu">điều khoản dịch vụ</a> của chúng tôi.</i></small>  
            </div>
          </div>
      
          <div class="alert alert-danger alert-dismissible mt-3 d-none" id="msgCheckEmail">
      			
      				Email đăng nhập đã tồn tại. Vui lòng chọn email khác.
      	</div>
          <div class="row mb-3">
            <div class="col-sm-11 offset-sm-1">
              <button type="submit"  class="btn btn-primary">Đăng ký</button>
            </div>
          </div>
        </div>
      </form>
    </div>
	<jsp:include page="/WEB-INF/pages/layout/footer.jsp" />
    </div>
    <!-- The Modal -->
		        <div class="modal" id="myModalDieuKhoanDichVu">
		            <div class="modal-dialog">
		                <div class="modal-content">
		
		                    <!-- Modal Header -->
		                    <div class="modal-header">
		                        <h4 class="modal-title">ĐIỀU KHOẢN SỬ DỤNG DỊCH VỤ VỚI DOANH NGHIỆP</h4>
		                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
		                    </div>
		
		                    <!-- Modal body -->
		                    <div class="modal-body">
		                    	<h3>1. ĐIỀU KHOẢN CHUNG</h3>
		                    	<p>Bằng cách truy cập hoặc sử dụng trang web, các dịch vụ do trang web cung cấp, dù truy cập bằng cách nào, 
		                    	bạn đồng ý chịu sự ràng buộc của các điều khoản sử dụng này 
		                    	("Điều khoản sử dụng").Các Điều khoản sử dụng này ảnh hưởng đến quyền và 
		                    	nghĩa vụ pháp lý của bạn. Nếu bạn không đồng ý chịu sự ràng buộc của tất cả các Điều khoản sử dụng này, bạn không 
		                    	truy cập hay sử dụng Dịch vụ. Nếu Bạn có bất kỳ câu hỏi nào liên quan đến Điều Khoản này, vui lòng liên hệ chúng 
		                    	tôi tại email: ketnoidoanhnghiepdhkh@gmail.com </p>

								<p>Chúng tôi có thể cập nhật Điều Khoản này theo thời gian vì các lý do pháp 
								lý hoặc theo quy định hoặc để cho phép hoạt động thích hợp của trang web. 
								Mọi thay đổi sẽ được thông báo tới bạn bằng một thông báo phù hợp trên trang web của chúng tôi. 
								Những thay đổi này sẽ áp dụng cho việc sử dụng trang web. Sau khi chúng tôi đã thông báo đến bạn, 
								Nếu bạn không muốn chấp nhận Điều Khoản mới, bạn không nên tiếp tục sử dụng trang web. 
								Nếu bạn tiếp tục sử dụng trang web kể từ ngày sự thay đổi có hiệu lực, việc sử dụng trang web 
								thể hiện bạn đồng ý bị ràng buộc bởi Điều Khoản mới.</p>
								<h3 class="mt-5">2. ĐỊNH NGHĨA VÀ GIẢI THÍCH</h3>
								<ol>
									<li>"<b>Trang web</b>" chỉ hệ thống trang web kết nối doanh nghiệp và sinh viên này.</li>
									
								</ol>
		                    	<h3 class="mt-5">3. ĐĂNG KÝ</h3>
		                    	<p>Để sử dụng Dịch vụ bạn phải tạo một tài khoản theo yêu cầu của trang web, bạn cam kết 
		                    	rằng việc sử dụng tài khoản phải tuân thủ các quy định của trang web, đồng thời tất cả các thông tin bạn cung cấp cho chúng 
		                    	tôi là đúng, chính xác, đầy đủ với tại thời điểm được yêu cầu. Mọi quyền lợi và nghĩa vụ của bạn sẽ căn cứ trên thông tin 
		                    	tài khoản bạn đã đăng ký, do đó nếu có bất kỳ thông tin sai 
		                    	lệch nào chúng tôi sẽ không chịu trách nhiệm trong trường hợp thông tin đó làm ảnh hưởng hoặc hạn chế quyền lợi của bạn.</p>
		                    	<h3 class="mt-5">4. MẬT KHẨU VÀ BẢO MẬT</h3>
		                    	<ol>
		                    		<li>Khi bạn đăng ký sử dụng trang web bạn sẽ được yêu cầu khởi tạo mật khẩu. Để tránh việc gian lận, 
		                    		bạn phải giữ mật khẩu này bảo mật và không được tiết lộ hoặc chia sẻ với bất kỳ người nào.Nếu bạn biết hoặc 
		                    		nghi ngờ người khác biết mật khẩu của bạn, 
		                    		bạn nên thông báo với chúng tôi ngay lập tức bằng cách liên hệ với chúng tôi tại email ketnoidoanhnghiepdhkh@gmail.com</li>
		                    		<li>Nếu chúng tôi có lý do để tin rằng có khả năng có hành vi vi phạm bảo mật hoặc sử dụng không đúng mục đích trang web, 
		                    		chúng tôi có thể yêu cầu bạn thay đổi mật khẩu hoặc chúng tôi có thể tạm dừng tài khoản của bạn.</li>
		  							<li>Trường hợp bạn mất Mật khẩu hoặc hoặc sử dụng không đúng mục đích trang web:
		  									<ul style="list-style-type: none;">
		  										<li>
												Bạn phải chịu tất cả sự mất mát hoặc thiệt hại phát sinh; và</li>
												<li>
												Bạn chịu trách nhiệm sẽ bồi thường hoàn toàn cho trang web trong trường hợp trang web có xảy ra mất mát hoặc thiệt hại.</li>
		                    				
		                    				</ul>
		                    				</li>
		                    	</ol>
		                    	<h3 class="mt-5">5. QUYỀN TRUY CẬP VÀ THU THẬP THÔNG TIN</h3>
		                    	<ol>
		                    		<li>Khi sử dụng trang web, bạn thừa nhận rằng chúng tôi có quyền thu thập các thông tin sau của bạn:
		                    			<ul>
		                    				<li>Thông tin liên hệ: bao gồm các thông tin bạn cung cấp cho chúng tôi để liên hệ như tên, số điện thoại, địa chỉ email;…</li>
		                    				<li>Thông tin xác minh doanh nghiệp: như các thông tin về tên pháp lý của doanh nghiệp; mã số thuế; hình ảnh giấy tờ xác minh;…</li>
		                    			</ul>
										
									</li>
		                    		<li>Bạn thừa nhận và đồng ý một mình chịu trách nhiệm về hình thức, 
		                    		nội dung và tính xác thực của bất kỳ hồ sơ hoăc tài liệu nào do bạn đăng tải trên trang web, 
		                    		đồng thời đồng ý một mình chịu trách nhiệm cho bất kỳ hệ quả nào phát sinh từ việc đăng tải này.</li>
		                    		
		                    		<li>Bạn hiểu và thừa nhận rằng thông tin liên hệ do bạn cung cấp, sẽ được công bố cho các sinh viên và tài khoản khách trên website.</li>
		                    		<li>Trang web có quyền xỏa tài khoản và tất cả thông tin của bạn sau một thời gian dài không hoạt động.</li>
		                    		
		                    	</ol>
		                    	<h3 class="mt-5">6. TUYÊN BỐ MIỄN TRỪ TRÁCH NHIỆM</h3>
		                    	<ol>
		                    		<li>Chúng tôi không tuyên bố hay đảm bảo rằng dịch vụ sẽ không bị lỗi hay không bị gián đoạn; 
		                    		rằng các lỗi sẽ được khắc phục; hoặc rằng dịch vụ hoặc máy chủ cung cấp dịch vụ không bị nhiễm bất kỳ thành phần 
		                    		có hại nào, bao gồm nhưng không giới hạn ở vi-rút. Chúng tôi không đưa ra bất kỳ tuyên bố hay đảm bảo nào rằng thông tin 
		                    		(bao gồm mọi hướng dẫn) về dịch vụ chính xác, đầy đủ hoặc hữu ích. Bạn xác nhận rằng bạn tự chịu rủi ro khi sử dụng dịch vụ. 
		                    		Trang web không đảm bảo rằng việc bạn sử dụng dịch vụ là hợp pháp trong bất kỳ khu vực pháp lý cụ thể nào và chúng tôi 
		                    		từ chối đưa ra các bảo đảm đó một cách cụ thể. Một số khu vực pháp lý giới hạn hoặc không cho phép tuyên bố miễn 
		                    		trừ trách nhiệm về bảo đảm ngụ ý hay các bảo đảm khác, vì vậy tuyên bố miễn trừ trách nhiệm trên có thể không áp 
		                    		dụng cho bạn trong phạm vi luật pháp của khu vực pháp lý đó áp dụng cho bạn và các điều khoản sử dụng này. </li>
		                    	</ol>
		                    	<h3 class="mt-5">7. HIỆU LỰC THỎA THUẬN CỦA HỢP ĐỒNG</h3>
		                    	<ol>	
		                    		<li>Các điều khoản quy định tại Quy định sử dụng này có thể được cập nhật, chỉnh sửa bất cứ lúc nào mà không 
		                    		cần phải thông báo trước tới người sử dụng. Chúng tôi sẽ công bố rõ trên Website, về những thay đổi, bổ sung đó.</li>
		                   			<li>Trong trường hợp một hoặc một số điều khoản Quy định sử dụng này xung đột với các quy định của luật pháp và bị Tòa án tuyên là vô hiệu, 
		                   			điều khoản đó sẽ được chỉnh sửa cho phù hợp với quy định pháp luật hiện hành, và phần còn lại của Quy định sử dụng vẫn giữ nguyên giá trị.</li>
		                    		<li>Thỏa thuận này có giá trị như Hợp Đồng. Doanh Nghiệp hiểu rằng, đây là hợp đồng điện tử, 
		                    		Giá trị pháp lý của hợp đồng điện tử không thể bị phủ nhận chỉ vì hợp đồng đó được thể hiện 
		                    		dưới dạng thông điệp dữ liệu theo Pháp Luật về Giao Dịch Điện Tử. Bằng cách đọc và chấp nhận đăng ký, 
		                    		Doanh Nghiệp hoàn toàn đồng ý và đã hiểu các điều khoản trong Hợp Đồng này và Hợp Đồng có hiệu lực kề từ thời điểm này. 
		                    		Nếu vi phạm các Điều khoản này, bạn đồng ý chịu hoàn toàn trách nhiệm và bồi thường thiệt hại (Nếu có) với Trang web.</li>
		                    	</ol>
		                    	<h3 class="mt-5">THÔNG TIN LIÊN LẠC</h3>
		                    	<p>Nếu bạn có câu hỏi về Điều khoản sử dụng này, vui lòng gửi email tới địa chỉ ketnoidoanhnghiepdhkh@gmail.com để được giải đáp nhanh nhất.</p>
		                    </div>
		
		                    <!-- Modal footer -->
		                    <div class="modal-footer">
		                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
		                    </div>
		
		                </div>
		            </div>
		        </div>
 <!-- The Modal -->
		        <div class="modal" id="myModalChinhSachBaoMat">
		            <div class="modal-dialog">
		                <div class="modal-content">
		
		                    <!-- Modal Header -->
		                    <div class="modal-header">
		                        <h4 class="modal-title">Danh sách sinh viên ứng tuyển</h4>
		                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
		                    </div>
		
		                    <!-- Modal body -->
		                    <div class="modal-body">
		                    	<span style="color: #c0c0c0;">Chưa có đăng ký nào</span>
		                    
		                    
		                    </div>
		
		                    <!-- Modal footer -->
		                    <div class="modal-footer">
		                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
		                    </div>
		
		                </div>
		            </div>
		        </div>
<script>

function setQuanHuyen(){
	var maTinhThanh = document.getElementById("city").value;
	document.getElementById("ward").innerHTML="<option disabled selected>----------</option>";
	$.ajax({ 
	    type:"post", 
	    url: "/doanhnghiep/dangky/quanhuyen", 
	    contentType: "application/x-www-form-urlencoded;charset=utf-8",
	    data: {
	    	maTinhThanh: maTinhThanh,
	    }, 
	    success: function(data) { 
	    	var row = document.getElementById("district");
	    	row.innerHTML += data;
	    	
	    },
	    })
};

function setXaPhuong(){
	var maQuanHuyen = document.getElementById("district").value;
	$.ajax({ 
	    type:"post", 
	    url: "/doanhnghiep/dangky/xaphuong", 
	    contentType: "application/x-www-form-urlencoded;charset=utf-8",
	    data: {
	    	maQuanHuyen: maQuanHuyen,
	    }, 
	    success: function(data) { 
	    	var row = document.getElementById("ward");
	    	row.innerHTML = data;
	    },
	    })
};
function validateThongTinDangNhap(){
	var kt= true;
	var checkEmail= /^[a-zA-Z][a-zA-Z0-9_\.]{3,63}@[a-zA-Z0-9]{2,}(\.[a-zA-Z0-9]{2,4}){1,2}$/;
	var checkPassword= /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
	
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var rePassword = document.getElementById("rePassword").value;
	if(!checkEmail.test(email)) {	
		document.getElementById("errorEmail").innerText="Email không hợp lệ";
		kt=false;
	}
	else document.getElementById("errorEmail").innerText="";
	if(!checkPassword.test(password)) {	
		document.getElementById("errorPassword").innerText="Mật khẩu không hợp lệ";
		kt=false;
	}
	else document.getElementById("errorPassword").innerText="";
	if(rePassword!=password) {	
		document.getElementById("errorRePassword").innerText="Mật khẩu không khớp";
		kt=false;
	}
	else document.getElementById("errorRePassword").innerText="";
	if(kt) currentSlide(1);
};
function validateThongTinLienHe(){
	var kt= true;
	var checkEmail= /^[a-zA-Z][a-zA-Z0-9_\.]{3,63}@[a-zA-Z0-9]{2,}(\.[a-zA-Z0-9]{2,4}){1,2}$/;
	var checkTel= /^0[35789][0-9]{8}$/;
	
	var contactName = document.getElementById("contactName").value;
	var contactEmail = document.getElementById("contactEmail").value;
	var contactTel = document.getElementById("contactTel").value;
	if(!checkEmail.test(contactEmail)) {	
		document.getElementById("errorContactEmail").innerText="Email không hợp lệ";
		kt=false;
	}
	else document.getElementById("errorContactEmail").innerText="";
	if(!checkTel.test(contactTel)) {	
		document.getElementById("errorContactTel").innerText="Số điện thoại không hợp lệ";
		kt=false;
	}
	else document.getElementById("errorContactTel").innerText="";
	if(contactName=="") {	
		document.getElementById("errorContactName").innerText="Tên người liên hệ không được bỏ trống";
		kt=false;
	}
	else document.getElementById("errorContactName").innerText="";
	if(kt) currentSlide(2);
};
function validateThongTinDoanhNghiep(){
	var kt= true;
	var checkTaxCode= /^([0-9]{10}|[0-9]{13})$/;
	
	var enterpriseName = document.getElementById("enterpriseName").value;
	var taxCode = document.getElementById("taxCode").value;
	var city = document.getElementById("city").value;
	var district = document.getElementById("district").value;
	var ward = document.getElementById("ward").value;
	var street = document.getElementById("street").value;
	var field = document.getElementById("field").value;
	var enterpriseType = document.getElementById("enterpriseType").value;
	
	console.log(city);
	if(enterpriseName==""){
		document.getElementById("errorEnterpriseName").innerText="Tên doanh nghiệp không được bỏ trống";
		kt=false;
	}
	else  document.getElementById("errorEnterpriseName").innerText="";
	if(!checkTaxCode.test(taxCode)) {	
		document.getElementById("errorTaxCode").innerText="Mã số thuế không hợp lệ";
		kt=false;
	}
	else document.getElementById("errorTaxCode").innerText="";
	if(city==""){
		document.getElementById("errorCity").innerText="Tỉnh/Thành phố không được bỏ trống";
		kt=false;
	}
	else  document.getElementById("errorCity").innerText="";
	if(district==""){
		document.getElementById("errorDistrict").innerText="Quận/huyện không được bỏ trống";
		kt=false;
	}
	else document.getElementById("errorDistrict").innerText="";
	if(ward==""){
		document.getElementById("errorWard").innerText="Xã/phường/thị trấn không được bỏ trống";
		kt=false;
	}
	else document.getElementById("errorWard").innerText="";
	if(street==""){
		document.getElementById("errorStreet").innerText="Địa chỉ đường không được bỏ trống";
		kt=false;
	}
	else document.getElementById("errorStreet").innerText="";
	if(field==""){
		document.getElementById("errorField").innerText="Lĩnh vực hoạt động không được bỏ trống";
		kt=false;
	}
	else document.getElementById("errorField").innerText="";
	if(enterpriseType==""){
		document.getElementById("errorEnterpriseType").innerText="Loại hình doanh nghiệp không được bỏ trống";
		kt=false;
	}
	else document.getElementById("errorEnterpriseType").innerText="";
	
	
	if(kt) currentSlide(3);
};
function checkEmailDangNhap(){
	var email = document.getElementById("email").value;
	var kt=false;
	$.ajax({ 
	    type:"post", 
	    url: "/doanhnghiep/dangky/checkemaildangnhap", 
	    contentType: "application/x-www-form-urlencoded;charset=utf-8",
	    data: {
	    	email: email,
	    }, 
	    async: false,
	    success: function(data) { 
	    	console.log(data);
	    	var x=document.getElementById("msgCheckEmail");
	    	if(data=="true"){
	    		x.className="alert alert-danger alert-dismissible mt-3 d-block"; 
	    		kt=false;
	    	}
	    	else {
	    		x.className="alert alert-danger alert-dismissible mt-3 d-none";
	    		kt=true;
	    	}
	    },
	    })
	console.log(kt);
	  return kt;
};
</script>
</body>
</html>