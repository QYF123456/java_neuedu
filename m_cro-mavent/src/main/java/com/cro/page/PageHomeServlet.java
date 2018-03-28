package com.cro.page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cro.Chli.Const;
import com.cro.entity.Address;
import com.cro.entity.CartVo;
import com.cro.entity.PageModel;
import com.cro.entity.User;
import com.cro.service.AddressService;
import com.cro.servicel.impl.AddressServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class PageHomeServlet
 */
@WebServlet("/PageHomeServlet")
public class PageHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//解决中文乱码
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				String callback=request.getParameter("callback");
				HttpSession session=request.getSession();
				Object o=session.getAttribute(Const.CURRENTUSER);
				User user=null;
				if(o!=null&&o instanceof User) {
					user=(User)o;
					}
				if (user==null) {
					CartVo vo=new CartVo();
					vo.setErrno(CartVo.CART_LOGIN);
					vo.setMessage("未登录，请登录");
					Gson gson=new Gson();
					String json=gson.toJson(vo);
					response.getWriter().write(callback+"("+json+")");
					
					return;
				} 
				String operationtype=request.getParameter("operationtype");
				if(operationtype==null||operationtype.equals("")) {
					try {
						throw new Exception("operationtype参数必须传");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				AddressService addressService=new AddressServiceImpl();
				if(operationtype.equals("1")) {
					String _pageNo=request.getParameter("pageNo");
					PageModel<Address> pageModel= addressService.findUserAddress(Integer.parseInt(_pageNo), 2, user.getId());
					Gson gson=new Gson();
					String result=gson.toJson(pageModel);
					System.out.println(result);
					response.getWriter().write(callback+"("+result+")");
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
