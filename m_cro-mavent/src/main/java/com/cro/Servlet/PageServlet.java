package com.cro.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cro.dao.impl.CateDaoImpl;
import com.cro.entity.Category;
import com.cro.entity.PageModel;
import com.cro.entity.view.CategoryView;
import com.cro.service.CateServicel;
import com.cro.servicel.impl.CateServiceimpl;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/mng/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
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
		
		String _pageNo=request.getParameter("pageNo");
		 CateServicel catService=  new  CateServiceimpl();
		 //��ҳģ��
		 PageModel<CategoryView> pageModel=catService.findAllCateService(Integer.parseInt(_pageNo), 4);
		 
		 
		 request.setAttribute("pageModel", pageModel);		 
		 request.getRequestDispatcher("/mng/fenlei.jsp").forward(request, response);
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
