package com.cro.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cro.Chli.Const;
import com.cro.entity.Cart;
import com.cro.entity.PageModel;
import com.cro.entity.User;
import com.cro.entity.view.Cartvo;
import com.cro.service.CartService;
import com.cro.servicel.impl.CartServiceimpl;

/**
 * Servlet implementation class SelectCartServlet
 */
@WebServlet("/SelectCartServlet")
public class SelectCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCartServlet() {
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
			String _pageNo=request.getParameter("pageNo");
			
			CartService cartService=new CartServiceimpl();
			PageModel<Cartvo> cart=cartService.findUserCart(Integer.parseInt(_pageNo), 1, user.getId());
			
			request.setAttribute("qaq", cart);
			int num=cartService.findCartProductCountByCartQuantity(user.getId());
			request.setAttribute("num", num);
			request.getRequestDispatcher("/qt/gouwuche.jsp").forward(request, response);
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
