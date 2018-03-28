package com.cro.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cro.entity.UserorderItemView;
import com.cro.service.UserorderItemsService;
import com.cro.servicel.impl.UserorderItemServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserorderitemServlet
 */
@WebServlet("/UserorderitemServlet")
public class UserorderitemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserorderitemServlet() {
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
	    String callback=request.getParameter("callback");
	    String order_no=request.getParameter("order_no");
	    try {
	    	UserorderItemsService userorderItemsService=new UserorderItemServiceImpl();
	    	List<UserorderItemView> userorder_items= userorderItemsService.findUserorderItemsByOrderNo(Long.parseLong(order_no));
	    	Gson gson=new Gson();
			String result=gson.toJson(userorder_items);
			System.out.println(result);
			response.getWriter().write(callback+"("+result+")");
			//request.setAttribute("userorder_items", userorder_items);
			
			//request.getRequestDispatcher("/qt/Selectdingdan.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	   
	}

	private void findUserorderItemsByOrderNo() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
