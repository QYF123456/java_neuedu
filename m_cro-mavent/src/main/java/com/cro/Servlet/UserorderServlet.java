package com.cro.Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cro.Chli.Const;
import com.cro.entity.CartVo;
import com.cro.entity.PageModel;
import com.cro.entity.Product;
import com.cro.entity.User;
import com.cro.entity.Userorder;
import com.cro.entity.UserorderItemView;
import com.cro.entity.UserorderView;
import com.cro.entity.Userorder_item;
import com.cro.service.UserorderItemsService;
import com.cro.service.UserorderService;
import com.cro.servicel.impl.UserorderItemServiceImpl;
import com.cro.servicel.impl.UserorderServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserorderServlet
 */
@WebServlet("/UserorderServlet")
public class UserorderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserorderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
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
			return;
		} 
		String operationtype=request.getParameter("operationtype");
		if(operationtype==null||operationtype.equals("")) {
			try {
				throw new Exception("operationtype�������봫");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String callback=request.getParameter("callback");
		UserorderService userorderService=new UserorderServiceImpl();
		UserorderItemsService userorderItemsService=new UserorderItemServiceImpl();
		if(operationtype.equals("1")) {  //�µ�
			try {
				Userorder userorder=userorderService.createOrder(user.getId(), request);
				Gson gson=new Gson();
				String result=gson.toJson(userorder);
				System.out.println("result�µ�="+result);
				response.getWriter().write(callback+"("+result+")");
				//response.sendRedirect("http://127.0.0.1:8020/web%20page/gerenzhongxin/dingdan.html");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (operationtype.equals("2")) {   //��ҳ��ȡ
			PageModel<UserorderView> pageModel=userorderService.findPageUserorder(user.getId(), request);
			request.setAttribute("pageModel", pageModel);
			try {
				String value=request.getParameter("value");
				if(value.equals("1")) {
					Gson gson=new Gson();
					String result=gson.toJson(pageModel);
					System.out.println(result);
					response.getWriter().write(callback+"("+result+")");
					//request.getRequestDispatcher("/qt/dingdan.jsp").forward(request, response);
					
				}else if (value.equals("0")) {
					request.getRequestDispatcher("/mng/dingdan.jsp").forward(request, response);
				}
				
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}else if (operationtype.equals("3")) {
			String _order_no=request.getParameter("order_no");
			String _pageNo=request.getParameter("pageNo");
			try {
				PageModel<UserorderView> userorder=userorderService.findUserorderByOrderNo(Long.parseLong(_order_no), Integer.parseInt(_pageNo), 5);
				Gson gson=new Gson();
				String result=gson.toJson(userorder);
				System.out.println(result);
				response.getWriter().write(callback+"("+result+")");
				request.setAttribute("qauserorder", userorder);
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
		}else if (operationtype.equals("4")) {
			String _order_no=request.getParameter("order_no");
			String _status=request.getParameter("status");
			int i= userorderService.updateStatus(Long.parseLong(_order_no), Integer.parseInt(_status));
			
			//String _pageNo=request.getParameter("pageNo");
			try {
				PageModel<UserorderView> userorder=userorderService.findUserorderByOrderNo(Long.parseLong(_order_no),1, 5);
			
				Gson gson=new Gson();
				String result=gson.toJson(userorder);
				response.getWriter().write(callback+"("+result+")");
				//request.setAttribute("qauserorder", userorder);
				
			}catch (NumberFormatException e) {
				e.printStackTrace();
			} 
			
			/*try {
				request.getRequestDispatcher("UserorderServlet?operationtype=2&pageNo=1&pageSize=1&value=1").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}else if (operationtype.equals("5")) {
			String _order_no=request.getParameter("order_no");
			List<Product> products=userorderService.SelectProductByUserorderItem(Long.parseLong(_order_no));
			
			
			request.setAttribute("qd", products);
			try {
				request.getRequestDispatcher("/qt/dingdanproduct.jsp").forward(request, response);
				
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
