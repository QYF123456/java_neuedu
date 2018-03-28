package com.cro.Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cro.entity.Category;
import com.cro.entity.Product;
import com.cro.service.CateServicel;
import com.cro.service.ProductService;
import com.cro.servicel.impl.CateServiceimpl;
import com.cro.servicel.impl.ProductServiceimpl;

/**
 * Servlet implementation class InsertProductServlet
 */
@WebServlet("/mng/InsertProductServlet")
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����������
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append("Served at: ").append(request.getContextPath());
				
				CateServicel cs= new CateServiceimpl();
				List<Category> ser= cs.FindAllCate();
				request.setAttribute("sec", ser);
				request.getRequestDispatcher("/mng/spadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Product pdt=new Product();
		try {
			pdt.setCategory_id(Integer.parseInt(request.getParameter("category_id")));
			pdt.setName(request.getParameter("name"));
			pdt.setSubtitle(request.getParameter("subtitle"));
			pdt.setMain_image(request.getParameter("main_image"));
			pdt.setSub_images(request.getParameter("sub_images"));
			pdt.setDetail(request.getParameter("detail"));
			String qw=request.getParameter("price");
			BigDecimal qa= new BigDecimal(qw);
			pdt.setPrice(qa);
			pdt.setStock(Integer.parseInt(request.getParameter("stock")));
			pdt.setStatus(Integer.parseInt(request.getParameter("status")));
			
		}catch(NumberFormatException e) {
			doGet(request, response);
			return;
		}
		ProductService po=new ProductServiceimpl();
		int pl=po.insertProduct(pdt);
		System.out.println("pl="+pl);
		request.getRequestDispatcher("/mng/PageProduct?pageNo=1&value=1").forward(request, response);
	}

}
