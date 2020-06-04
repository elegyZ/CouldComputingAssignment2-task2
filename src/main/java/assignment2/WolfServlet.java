package assignment2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WolfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String question = request.getParameter("question");
		List<Wolf> wolf_list = DBUtil.getWolfList(question);
		Wolf wolf = new Wolf();
		if (wolf_list.isEmpty())
		{
			String answer = WolframAlpha2.query(question);
			wolf.initWolf(question, answer);
			DBUtil.insertWolf(wolf);
		}
		else
		{
			wolf = wolf_list.get(0);
		}
		request.setAttribute("wolf", wolf);
		request.getRequestDispatcher("answer.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}
}
