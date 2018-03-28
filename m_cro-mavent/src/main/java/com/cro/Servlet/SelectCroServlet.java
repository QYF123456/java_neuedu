package com.cro.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cro.entity.Category;
import com.cro.service.CateServicel;
import com.cro.servicel.impl.CateServiceimpl;

/**
 * Servlet implementation class SelectCroServlet
 */
@WebServlet("/mng/SltCro")
public class SelectCroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCroServlet() {
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
		
		CateServicel cs= new CateServiceimpl();
		//List<Category> ser= cs.FindAllCate();
		//request.setAttribute("sec", ser);
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
