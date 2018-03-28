package com.cro.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cro.entity.PageModel;
import com.cro.entity.Product;
import com.cro.service.ProductService;
import com.cro.servicel.impl.ProductServiceimpl;

/**
 * Servlet implementation class PageProduct
 */
@WebServlet("/mng/PageProduct")
public class PageProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageProduct() {
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
		
		
        String _pageNo=request.getParameter("pageNo");
        String _value=request.getParameter("value");
        ProductService productService=new ProductServiceimpl();
        //��ҳģ��
        PageModel<Product> pageModel=productService.FindAllProductByPage(Integer.parseInt(_pageNo), 4);
        System.out.println("totalpage="+pageModel.getTotalPage());
        request.setAttribute("pageModel", pageModel);	
        if(Integer.parseInt(_value)>0) {
        	 request.getRequestDispatcher("/mng/shangpin.jsp").forward(request, response);
        }else {
        	request.getRequestDispatcher("/mng/qt/gspadd.jsp").forward(request, response);
		}
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
