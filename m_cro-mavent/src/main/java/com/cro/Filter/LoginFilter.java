package com.cro.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cro.Chli.Const;
import com.cro.entity.User;
import com.cro.service.ILoginService;
import com.cro.servicel.impl.LoginServiceImpl;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/mng/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }
    private void init() {
    	
    }
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//≈–∂œtooken «∑Ò¥Ê‘⁄
		HttpServletRequest request = (HttpServletRequest)_request;
		HttpServletResponse response = (HttpServletResponse)_response;
		HttpSession session = request.getSession();
		String _tooken = null;
		
		Cookie[] cookies = request.getCookies();
		System.out.println("cookies="+cookies);
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals(Const.TOOKEN_COOKIE)) {
					_tooken=c.getValue();
					System.out.println("_tooken"+_tooken);
				}
				
			}
		}
		if(_tooken!=null) {
			
			ILoginService interservice = new LoginServiceImpl();
			User user = interservice.finUserBytooken(_tooken);
			if(user!=null) {
				session.setAttribute(Const.CURRENTUSER, user);
				// pass the request along the filter chain
				chain.doFilter(request, response);
				
			}else {
				response.sendRedirect("http://localhost:8080/qyf-m-cro/login.jsp");
			}
		}else {
			response.sendRedirect("http://localhost:8080/qyf-m-cro/mng/shibai.jsp");
		}
		
		
		/*
		HttpServletRequest request = (HttpServletRequest)_request;
		HttpServletResponse response = (HttpServletResponse)_response;
		HttpSession session = request.getSession();
		
		String _username = null;
		String _password = null;
		Cookie[] cookies = request.getCookies();
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
		if(_username==null||_password==null) {
			_username=(String) session.getAttribute("username");
			_password=(String) session.getAttribute("password");
			
		}
			ILoginService interservice = new LoginServiceImpl();
			User user=null;
			 user = interservice.login(_username, _password);
			
			if(user!=null) {
				session.setAttribute(Const.CURRENTUSER, user);
				// pass the request along the filter chain
				chain.doFilter(request, response);
				
			}else {
				response.sendRedirect("http://localhost:8080/qyf-m-cro/login.jsp");
			}
*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
