package com.cro.page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cro.Chli.Const;
import com.cro.entity.User;
import com.cro.entity.ViewLogin;
import com.cro.service.ILoginService;
import com.cro.servicel.impl.LoginServiceImpl;
import com.cro.utils.MD5Utils;
import com.google.gson.Gson;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/view/LoginServlet")
public class PageLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageLoginServlet() {
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
		/**
		 * �����Ự
		 * */
		HttpSession session=request.getSession();
		
		String _tooken=null;
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals(Const.TOOKEN_COOKIE)) {
					_tooken=c.getValue();
				}
			}
		}
		if(_tooken!=null) {
			ILoginService login=new LoginServiceImpl();
			User user=login.finUserBytooken(_tooken);
			if(user!=null) {
				session.setAttribute(Const.TOOKEN_COOKIE, _tooken);
				ViewLogin vo=new ViewLogin();
				vo.setErrno(ViewLogin.LOGIN_SUCC);
				vo.setUser(user);
				//request.getRequestDispatcher("http://127.0.0.1:8020/web%20page/gerenzhongxin/gouwuche.html").forward(request, response);
				//response.sendRedirect("http://127.0.0.1:8020/web%20page/gerenzhongxin/gouwuche.html");
				//System.out.println("���ܹ���ȥô��");
				/*Gson gson=new Gson();
				String json=gson.toJson(vo);
				System.out.println(json);
				response.getWriter().write(callback+"("+json+")");*/
				return;
			}
		}
		/* String _username=null;
		 String _password=null;
		 Cookie[] cookies=request.getCookies();
		 if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("username")) {
					_username=c.getValue();
				}
				if(c.getName().equals("password")) {
					_password=c.getValue();
				}
			}
		}
		if(_username!=null&&_password!=null) {
			ILoginService login=new LoginServiceImpl();
			User user=login.login(_username, _password);
			if(user!=null) {
				session.setAttribute(Const.CURRENTUSER, user);
				response.sendRedirect("http://localhost:8080/qyf-m-cro/mng/index.jsp");
				return;
			}
		}
		*/
		
		//��ȡҳ��������Ϣ
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(password!=null) {
			password=MD5Utils.GetMD5Code(password);
		}
		//������Ӧ��Ϣ
		ILoginService login=new LoginServiceImpl();   //��service��ķ���
		User user=login.login(username, password);   //ִ��LoginServiceImpl()�е�login��������������Ϣ�����ж�
		
		
		
		if(user!=null) {  //���user��Ϊ�գ��û���¼��Ϣ��ȷ����ת��index.jspҳ��
			//����tooken���û���������ļ���
			String tooken=MD5Utils.GetMD5Code(user.getUsername()+user.getPassword());
			
			Cookie tooken_cookie=new Cookie(Const.TOOKEN_COOKIE, tooken);
			tooken_cookie.setMaxAge(7*24*3600);
			tooken_cookie.setPath(request.getContextPath());
			response.addCookie(tooken_cookie);
			
			/*//���û���������ͨ��cookieд���ͻ���
			Cookie username_cookie=new Cookie(Const.USERNAME_COOKIE,user.getUsername());
			Cookie password_cookie=new Cookie(Const.PASSWORD_COOKIE, user.getPassword());
			username_cookie.setMaxAge(7*24*3600);
			password_cookie.setMaxAge(7*24*3600);
			username_cookie.setPath(request.getContextPath());
			password_cookie.setPath(request.getContextPath());
			response.addCookie(username_cookie);
			response.addCookie(password_cookie);*/
			
			//request.setAttribute("user", user);
			session.setAttribute(Const.CURRENTUSER, user);
			//session.setAttribute("username", username);
			//session.setAttribute("password", password);
			
			ViewLogin vo=new ViewLogin();
			vo.setErrno(ViewLogin.LOGIN_SUCC);
			vo.setUser(user);
			Gson gson=new Gson();
			String json=gson.toJson(vo);
			System.out.println(json); 
			response.getWriter().write(callback+"("+json+")");
		}else {  //����userΪ�գ���¼��Ϣ���û��������������,����������
			ViewLogin vo=new ViewLogin();
			vo.setErrno(ViewLogin.LOGIN_FAIL);
			vo.setMessage("��¼ʧ��");
			Gson gson=new Gson();
			String json=gson.toJson(vo);
			System.out.println(json);
			response.getWriter().write(callback+"("+json+")");
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
