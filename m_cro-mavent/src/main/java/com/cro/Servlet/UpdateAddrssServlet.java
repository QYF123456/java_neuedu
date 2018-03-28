package com.cro.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cro.entity.Address;
import com.cro.service.AddressService;
import com.cro.servicel.impl.AddressServiceImpl;

/**
 * Servlet implementation class UpdateAddrssServlet
 */
@WebServlet("/qt/UpdateAddrssServlet")
public class UpdateAddrssServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAddrssServlet() {
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
		AddressService addressService=new AddressServiceImpl();
		Address addresses=addressService.findAddressByid(Integer.parseInt(_id));
		request.setAttribute("qa", addresses);
		request.getRequestDispatcher("/qt/homeupdate.jsp").forward(request, response);
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
		Address address=new Address();
		address.setId(Integer.parseInt(_id));
		try {
			address.setUser_id(Integer.parseInt(request.getParameter("user_id")));
			address.setReceiver_name(request.getParameter("receiver_name"));
			address.setReceiver_phone(request.getParameter("receiver_phone"));
			address.setReceiver_mobile(request.getParameter("receiver_mobile"));
			address.setReceiver_provinc(request.getParameter("receiver_provinc"));
			address.setReceiver_city(request.getParameter("receiver_city"));
			address.setReceiver_district(request.getParameter("receiver_district"));
			address.setReceiver_address(request.getParameter("receiver_address"));
			address.setReceiver_zip(request.getParameter("receiver_zip"));
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println(address);
		AddressService addressService=new AddressServiceImpl();
		int adr=addressService.updateUserAddressByUserid(Integer.parseInt(_id), address);
		request.getRequestDispatcher("/qt/AddressServlet?pageNo=1").forward(request, response);
		doGet(request, response);
	}

}
