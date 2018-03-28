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
 * Servlet implementation class UpdateCroServlet
 */
@WebServlet("/mng/UpdateCroServlet")
public class UpdateCroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCroServlet() {
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
	   
		String _id= request.getParameter("id");
		CateServicel qw=new CateServiceimpl();
		CateServicel cs=new CateServiceimpl();
		try {
			Category qa= qw.findCategorybyid(Integer.parseInt(_id));
			if(qa!=null) {
				request.setAttribute("was", qa);
				List<Category> ser= cs.FindAllCate();
				request.setAttribute("sec", ser);
				request.getRequestDispatcher("/mng/Update.jsp").forward(request, response);
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String _id= request.getParameter("id");
		Category cat=new Category();
		cat.setId(Integer.parseInt(_id));
		try {
			cat.setParent_id(Integer.parseInt(request.getParameter("parent_id")));
			cat.setName(request.getParameter("name"));
			cat.setStatus(Integer.parseInt(request.getParameter("status")));
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		CateServicel qw=new CateServiceimpl();
		int qe=qw.UpdateCategory(cat, Integer.parseInt(_id));
		request.getRequestDispatcher("/mng/PageServlet?pageNo=1").forward(request, response);
		doGet(request, response);
	}

}
