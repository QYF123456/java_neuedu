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
import com.cro.entity.User;
import com.cro.service.AddressService;
import com.cro.servicel.impl.AddressServiceImpl;

/**
 * Servlet implementation class InsertAddressServlet
 */
@WebServlet("/qt/InsertAddressServlet")
public class InsertAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAddressServlet() {
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
		HttpSession session=request.getSession();
		Object o=session.getAttribute(Const.CURRENTUSER);
		User user=null;
		if(o!=null&&o instanceof User) {
			user=(User)o;
		}
		if (user==null) {
			response.sendRedirect("http://localhost:8080/qyf-m-cro/login.jsp");
		} else {
			Address adr=new Address();
			try {
				adr.setUser_id(user.getId());
				//adr.setUser_id(Integer.parseInt(request.getParameter("user_id")));
				adr.setReceiver_name(request.getParameter("receiver_name"));
				adr.setReceiver_phone(request.getParameter("receiver_phone"));
				adr.setReceiver_mobile(request.getParameter("receiver_mobile"));
				adr.setReceiver_provinc(request.getParameter("receiver_provinc"));
				adr.setReceiver_city(request.getParameter("receiver_city"));
				adr.setReceiver_district(request.getParameter("receiver_district"));
				adr.setReceiver_address(request.getParameter("receiver_address"));
				adr.setReceiver_zip(request.getParameter("receiver_zip"));
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
			System.out.println("+++rrr+++"+adr);
			int  _user_id=adr.getUser_id();
			AddressService addressService=new AddressServiceImpl();
			addressService.addAddress(_user_id, adr);
			request.getRequestDispatcher("/qt/AddressServlet?pageNo=1&user_id=4").forward(request, response);
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
