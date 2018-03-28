package com.cro.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cro.Chli.Const;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����½��Ϣ�ӻỰ��ɾ��
		HttpSession session=request.getSession();
		session.removeAttribute(Const.CURRENTUSER);
		//��tooken�Ƴ�
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals(Const.TOOKEN_COOKIE)) {
					Cookie c1=new Cookie(c.getName(), c.getValue());
					c1.setMaxAge(0);
					c1.setPath(request.getContextPath());
					response.addCookie(c1);
				}
			}
		}
		//��username��password��cookie�Ƴ�
		/*Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals(Const.USERNAME_COOKIE)) {
					Cookie c1=new Cookie(c.getName(), c.getValue());
					c1.setMaxAge(0);
					c1.setPath(request.getContextPath());
					response.addCookie(c1);
				}
				if(c.getName().equals(Const.PASSWORD_COOKIE)) {
					Cookie c1=new Cookie(c.getName(), c.getValue());
					c1.setMaxAge(0);
					c1.setPath(request.getContextPath());
					response.addCookie(c1);
				}
			}
		}*/
		//ҳ����ת��Login.jsp
		response.getWriter().print("<script>top.location.href=\"http://localhost:8080/qyf-m-cro/login.jsp\"</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
