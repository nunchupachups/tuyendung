package cntt.trang.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cntt.trang.bean.Blog;
import cntt.trang.dao.BlogDAO;
import cntt.trang.dao.ThongBaoDAO;
import cntt.trang.dao.VNCharacterUtils;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
	@RequestMapping(value= {""}, method=RequestMethod.GET)
    public String blog(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
	 		BlogDAO blogDAO=new BlogDAO();
	 		ArrayList<Blog> blogs=blogDAO.timKiemBlogDaDuyetByKey("");
	 		int soPage=blogs.size();
	 		if(soPage%10==0) soPage=soPage/10;
	 		else soPage=soPage/10+1;
	 		model.addAttribute("thongBaoDAO",thongBaoDAO );
	 		if(blogs.size()<=10) model.addAttribute("blogs", blogs);
	 		else model.addAttribute("blogs", blogs.subList(0, 10));
	 		model.addAttribute("soPage", soPage);
	 		model.addAttribute("top10Blog", blogDAO.getTop10BlogByLuotXem());
	 		model.addAttribute("title", "Blog");
	 		
	    	return "blog/timkiem";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
       
    }
	@RequestMapping(value= {"/timkiem/page"}, method=RequestMethod.POST)
    public void timKiemBlog(Model model,HttpSession session,HttpServletRequest  request,HttpServletResponse response) {
	 	try {
	 		response.setContentType("text/html;charset=UTF-8");
	 		request.setCharacterEncoding("UTF-8");
	 		
	 		String key= request.getParameter("key");
	 		String p = request.getParameter("page");
	 		int page=1;
	 		if(p!=null) page= Integer.parseInt(p);
	 		BlogDAO blogDAO=new BlogDAO();
	 		
	 		ArrayList<Blog> blogs;
	 		Set<Blog> ds=new HashSet<Blog>();
	 		
	 			String keys[] =key.split(" ");
	 			for(int i=0; i< keys.length;i++) {
	 				ds.addAll(blogDAO.timKiemBlogDaDuyetByKey(VNCharacterUtils.removeAccent(keys[i])));
	 			}
	 			blogs=new ArrayList<Blog>();
	 			for (Blog b : ds) {
	 				blogs.add(b);
				}
	 			Collections.sort(blogs);
	 			
	 		int soPage=blogs.size();
	 		if(soPage%10==0) soPage=soPage/10; else soPage=soPage/10+1;
	 		
	 		List<Blog> a=null;
	 		if(page*10>blogs.size()) a= blogs.subList((page-1)*10, blogs.size());
	 		else a=blogs.subList((page-1)*10, page*10);
	 		
	 		PrintWriter out=response.getWriter();
	 		if(a.isEmpty()) 
	 			out.print("<h4 style=\"color: #c0c0c0;\">Không tìm thấy bài viết nào phù hợp với yêu cầu tìm kiếm của bạn</h4>");
	 		else {
	 			out.print("<div class=\"row\">");
	 			for (Blog b : a) {
	 				out.print("<div style=\"height:500px;width: 33%; margin-bottom: 20px;position: relative;\">\r\n" + 
	 						"			  <a href=\"/doanhnghiep/blog/chitiet?id="+b.getMaBlog() +"\" style=\"color: black;text-decoration: none;\">\r\n" + 
	 						"			  	<div style=\"height: 500px;width:100%; display: flex;flex-direction: column;box-shadow: 5px 5px 6px #00000029;	\">\r\n" + 
	 						"					   <div style=\"height: 320px;\">\r\n" + 
	 						"					   	<img style=\"width: 100%; height: 100%;\" src=\"/"+b.getAnh()+"\">\r\n" + 
	 						"					   </div>\r\n" + 
	 						"					   <div style=\"padding: 15px;\">\r\n" + 
	 						"					   		<h4>"+b.getTieuDe() +"</h4>\r\n" + 
	 						"					   </div>\r\n" + 
	 						"				</div>\r\n" + 
	 						"				</a>\r\n" + 
	 						"			  </div>");
				}
	 			out.print("</div>");
	 		}
	 		if(soPage!=1) {
	 			if(page==1) {
	 				out.print("<nav aria-label=\"Page navigation example\">\r\n" + 
		 					"  <ul class=\"pagination justify-content-center\">\r\n" + 
		 					"    <li class=\"page-item disabled\">\r\n" + 
		 					"      <a class=\"page-link\" aria-label=\"Previous\">\r\n" + 
		 					"        <span aria-hidden=\"true\">&laquo;</span>\r\n" + 
		 					"      </a>\r\n" + 
		 					"    </li>\r\n"); 	
	 				for(int i=page;i<=page+2;i++) {
	 					if(i>soPage) break;
	 					if(i==page) out.print("<li class=\"page-item active\" onclick=\"timKiemBlog("+i+")\"><a class=\"page-link\" >"+i+"</a></li>");
	 					else out.print("<li class=\"page-item\" onclick=\"timKiemBlog("+i+")\"><a class=\"page-link\" >"+i+"</a></li>");
	 				}
	 					out.print("    <li class=\"page-item\">\r\n" + 
		 					"      <a class=\"page-link\" onclick=\"timKiemBlog(2)\" aria-label=\"Next\">\r\n" + 
		 					"        <span aria-hidden=\"true\">&raquo;</span>\r\n" + 
		 					"      </a>\r\n" + 
		 					"    </li>\r\n" + 
		 					"  </ul>\r\n" + 
		 					"</nav>");
	 				
	 			}else
	 			if(page==soPage) {
	 				out.print("<nav aria-label=\"Page navigation example\">\r\n" + 
		 					"  <ul class=\"pagination justify-content-center\">\r\n" + 
		 					"    <li class=\"page-item \">\r\n" + 
		 					"      <a class=\"page-link\" onclick=\"timKiemBlog("+(page-1)+")\" aria-label=\"Previous\">\r\n" + 
		 					"        <span aria-hidden=\"true\">&laquo;</span>\r\n" + 
		 					"      </a>\r\n" + 
		 					"    </li>\r\n"); 	
	 				for(int i=page-2;i<=page;i++) {
	 					if(i<1) continue;
	 					if(i==page) out.print("<li class=\"page-item active\" onclick=\"timKiemBlog("+i+")\"><a class=\"page-link\" >"+i+"</a></li>");
	 					else out.print("<li class=\"page-item\" onclick=\"timKiemBlog("+i+")\"><a class=\"page-link\" >"+i+"</a></li>");
	 				}
	 					out.print("    <li class=\"page-item\">\r\n" + 
		 					"      <a class=\"page-link disabled\" aria-label=\"Next\">\r\n" + 
		 					"        <span aria-hidden=\"true\">&raquo;</span>\r\n" + 
		 					"      </a>\r\n" + 
		 					"    </li>\r\n" + 
		 					"  </ul>\r\n" + 
		 					"</nav>");
	 			}else
	 			{
	 				out.print("<nav aria-label=\"Page navigation example\">\r\n" + 
		 					"  <ul class=\"pagination justify-content-center\">\r\n" + 
		 					"    <li class=\"page-item \">\r\n" + 
		 					"      <a class=\"page-link\" onclick=\"timKiemBlog("+(page-1)+")\" aria-label=\"Previous\">\r\n" + 
		 					"        <span aria-hidden=\"true\">&laquo;</span>\r\n" + 
		 					"      </a>\r\n" + 
		 					"    </li>\r\n"); 	
	 				for(int i=page-1;i<=page+1;i++) {
	 					if(i<1) continue;
	 					if(i==page) out.print("<li class=\"page-item active\" onclick=\"timKiemBlog("+i+")\"><a class=\"page-link\" >"+i+"</a></li>");
	 					else out.print("<li class=\"page-item\" onclick=\"timKiemBlog("+i+")\"><a class=\"page-link\" >"+i+"</a></li>");
	 				}
	 					out.print("    <li class=\"page-item\">\r\n" + 
		 					"      <a class=\"page-link\" onclick=\"timKiemBlog("+(page+1)+")\" aria-label=\"Next\">\r\n" + 
		 					"        <span aria-hidden=\"true\">&raquo;</span>\r\n" + 
		 					"      </a>\r\n" + 
		 					"    </li>\r\n" + 
		 					"  </ul>\r\n" + 
		 					"</nav>");
	 			}
	 		}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
       
    }
}
