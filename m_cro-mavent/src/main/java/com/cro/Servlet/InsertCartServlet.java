package com.cro.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cro.Chli.Const;
import com.cro.entity.Cart;
import com.cro.entity.User;
import com.cro.service.CartService;
import com.cro.servicel.impl.CartServiceimpl;

/**
 * Servlet implementation class InsertCartServlet
 */
@WebServlet("/InsertCartServlet")
public class InsertCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCartServlet() {
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
		
		HttpSession session=request.getSession();
		Object o=session.getAttribute(Const.CURRENTUSER);
		User user=null;
		if(o!=null&&o instanceof User) {
			user=(User)o;
		}
		if (user==null) {
			response.sendRedirect("http://localhost:8080/qyf-m-cro/login.jsp");
		} else {
			Cart cart=new Cart();
			try {
				cart.setUser_id(user.getId());
				cart.setProduct_id(Integer.parseInt(request.getParameter("product_id")));
				cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
				cart.setChecked(Integer.parseInt(request.getParameter("checked")));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			CartService cartService=new CartServiceimpl();
			cartService.addProducttoCart(user.getId(), cart);
			request.getRequestDispatcher("SelectCartServlet?pageNo=1").forward(request, response);
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
