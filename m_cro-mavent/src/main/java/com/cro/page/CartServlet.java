package com.cro.page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cro.Chli.Const;
import com.cro.entity.Cart;
import com.cro.entity.CartCheckedVo;
import com.cro.entity.CartVo;
import com.cro.entity.PageModel;
import com.cro.entity.User;
import com.cro.entity.view.Cartvo;
import com.cro.service.CartService;
import com.cro.servicel.impl.CartServiceimpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		CartService cartService=new CartServiceimpl();
		
		if(operationtype.equals("1")) { //查询购物车列表
			String _pageNo=request.getParameter("pageNo");
			PageModel<Cartvo> cart=cartService.findUserCart(Integer.parseInt(_pageNo), 5, user.getId());
			CartVo vo=new CartVo();
			vo.setErrno(CartVo.CART_SUCCESS);
			vo.setPageModel(cart);
			Gson gson=new Gson();
			String result=gson.toJson(vo);
			//System.out.println("result Servlet="+result);
			response.getWriter().write(callback+"("+result+")");
		}else if (operationtype.equals("2")) {//全选、取消全选、单选、取消单选
			try {
				CartCheckedVo vo=cartService.updateCartcheckedByUseridAndProductid(user.getId(), request);
				
				Gson gson=new Gson();
				String result=gson.toJson(vo);
				//System.out.println(result);
				response.getWriter().write(callback+"("+result+")");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (operationtype.equals("3")) { //更新购物车数量
			Cart i=cartService.updateCartByUserIdAndProductId(user.getId(), request);
			Gson gson=new Gson();
			String result=gson.toJson(i);
			//System.out.println(result);
			response.getWriter().write(callback+"("+result+")");
		}else if (operationtype.equals("4")) {
			int po=cartService.findCartproductCountByUserId(user.getId());
			Gson gson=new Gson();
			String result=gson.toJson(po);
			//System.out.println(result);
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
