package com.cro.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cro.entity.PageModel;
import com.cro.entity.User;
import com.cro.service.UserService;
import com.cro.servicel.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/mng/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		
		UserService userService=new UserServiceImpl();
		
		String operationtype=request.getParameter("operationtype");
		/*if(operationtype==null||operationtype.equals("")) {
			try {
				throw new Exception("operationtype�������봫");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		//��ҳ��ѯ
			String pageNo=request.getParameter("pageNo");
			PageModel< User> model=userService.findUser(Integer.parseInt(pageNo), 5);
			request.setAttribute("model", model);
			request.getRequestDispatcher("/mng/huiyuan.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
