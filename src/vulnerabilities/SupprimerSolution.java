package vulnerabilities;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SupprimerSolution")
public class SupprimerSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SupprimerSolution() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String codestring=request.getParameter("code");
		long codelong=Long. parseLong(codestring);
		
		ModelSolution m=new ModelSolution();
		m.supprimerSolution(codelong);
		
		request.getRequestDispatcher("logicielspervulnerabilite.jsp").forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
