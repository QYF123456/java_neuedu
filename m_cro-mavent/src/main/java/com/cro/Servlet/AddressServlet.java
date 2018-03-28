package com.cro.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cro.Chli.Const;
import com.cro.entity.Address;
import com.cro.entity.PageModel;
import com.cro.entity.User;
import com.cro.service.AddressService;
import com.cro.servicel.impl.AddressServiceImpl;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/qt/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
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
			String _user_id=request.getParameter("user_id");
			String _pageNo=request.getParameter("pageNo");
			
			AddressService addressService=new AddressServiceImpl();
			PageModel<Address> pageModel= addressService.findUserAddress(Integer.parseInt(_pageNo), 10, Integer.parseInt(_user_id));
			
			request.setAttribute("qwe", pageModel);
			request.getRequestDispatcher("/qt/home.jsp").forward(request, response);
		
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
