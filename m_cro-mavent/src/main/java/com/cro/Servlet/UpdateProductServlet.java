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
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/mng/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
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
		
		String _id=request.getParameter("id");
		ProductService qw=new ProductServiceimpl();
		ProductService po=new ProductServiceimpl();
		try {
			Product qa=qw.findProductById(Integer.parseInt(_id));
			if(qa!=null) {
				request.setAttribute("was", qa);
				List<Product> pl=po.FindAllProduct();
				request.setAttribute("wqa", pl);
				request.getRequestDispatcher("/mng/spupdate.jsp").forward(request, response);
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����������
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				
				String _id=request.getParameter("id");
				Product pdt=new Product();
				pdt.setId(Integer.parseInt(_id));
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
					e.printStackTrace();
				}
				ProductService qw=new ProductServiceimpl();
				int qa=qw.updateProduct(pdt);
				if(qa>0) {
					request.getRequestDispatcher("/mng/PageProduct?pageNo=1&value=1").forward(request, response);
			        //doGet(request, response);
				}
			
		        
	}

}
