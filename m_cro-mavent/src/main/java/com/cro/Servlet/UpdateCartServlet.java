package com.cro.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cro.entity.Cart;
import com.cro.service.CartService;
import com.cro.servicel.impl.CartServiceimpl;

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartServlet() {
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
		
		String user_id="1";//request.getParameter("user_id");
		String product_id=request.getParameter("product_id");
		System.out.println("product_id="+product_id);
		String quantity=request.getParameter("quantity");
		System.out.println("Servlet  quantity"+quantity);
		CartService cartService=new CartServiceimpl();
		
		try {
			Integer _user_id=Integer.parseInt(user_id);
			Integer _product_id=Integer.parseInt(product_id);
			Integer _quantity=Integer.parseInt(quantity);
			Cart i=cartService.updateCartByUserIdAndProductId(_user_id, request);
			if (i!=null) {
				request.getRequestDispatcher("SelectCartServlet?pageNo=1").forward(request, response);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
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
