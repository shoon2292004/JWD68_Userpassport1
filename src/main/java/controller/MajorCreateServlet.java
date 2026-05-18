package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MajorBean;
import repository.MajorRepository;

/**
 * Servlet implementation class MajorCreateServlet
 */
@WebServlet("/create-major")
public class MajorCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajorCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("mname");
		int marks= Integer.parseInt(request.getParameter("mmarks"));
		
		MajorBean major=new MajorBean();
		major.setMajorName(name);
		major.setMarks(marks);
		
		MajorRepository mRepo=new MajorRepository();
		int i = mRepo.insertMajor(major);
		
		if(i!=0) {
			List<MajorBean> list=mRepo.getAllMajor();
			request.setAttribute("list", list);
			request.getRequestDispatcher("major-list.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "insert fail!");
			request.getRequestDispatcher("major-create.jsp").forward(request, response);
		}
		
	}

}
