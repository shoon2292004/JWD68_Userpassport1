package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MajorBean;
import repository.MajorRepository;

/**
 * Servlet implementation class MajorUpdateServlet
 */
@WebServlet("/major-update")
public class MajorUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajorUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getParameter("id")!=null) {
			int id= Integer.parseInt(request.getParameter("id"));
			
			MajorRepository mRepo = new MajorRepository();
			MajorBean resObj = mRepo.getbyMajorId(id);
			if (resObj!=null) {
				request.setAttribute("majorObj", resObj);
				request.getRequestDispatcher("major-edit.jsp").forward(request, response);
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String majorName = request.getParameter("mname");
		int marks = Integer.parseInt(request.getParameter("mmarks"));
		int id = Integer.parseInt(request.getParameter("mid"));
		
		MajorBean obj = new MajorBean();
		obj.setId(id);
		obj.setMajorName(majorName);
		obj.setMarks(marks);
		
		MajorRepository mRepo = new MajorRepository();
		int i = mRepo.updateMajor(obj);
		
		if(i!=0) {
			request.setAttribute("message", "update success!");
			//response.sendRedirect("major-list");
			request.getRequestDispatcher("major-list").forward(request, response);
		}else {
			request.setAttribute("error", "update fail");
			request.getRequestDispatcher("major-edit.jsp").forward(request, response);
		}
		
	}

}
