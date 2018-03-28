package com.cro.Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Servlet implementation class InsertCroServlet
 */
@WebServlet("/mng/InsertCroServlet")
public class InsertCroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCroServlet() {
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
		List<Category> ser= cs.FindAllCate();
		System.out.println(ser);
		request.setAttribute("sec", ser);
		request.getRequestDispatcher("/mng/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Category cate=new Category();
		try {
			cate.setId(Integer.parseInt(request.getParameter("id")));
			cate.setParent_id(Integer.parseInt(request.getParameter("parent_id")));
			cate.setName(request.getParameter("name"));
			cate.setStatus(Integer.parseInt(request.getParameter("status")));
		}catch(NumberFormatException e) {
			doGet(request,response);
			return;
		}
		//����service������������Ӧ��Ϣ
		CateServicel we= new CateServiceimpl();
		int qw=we.insertEmp(cate);
		//��ѯȫ����Ϣ
		CateServicel cs= new CateServiceimpl();
		List<Category> ser= cs.FindAllCate();
		request.setAttribute("sec", ser);
		request.getRequestDispatcher("/mng/PageServlet?pageNo=1").forward(request, response);
		
		doGet(request, response);
	}

}
