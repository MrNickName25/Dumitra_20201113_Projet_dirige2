package vulnerabilities;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SupprimerVulnerabilite")
public class SupprimerMenace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SupprimerMenace() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String codestring=request.getParameter("id_index_vulnerabilite");
		long codelong=Long.parseLong(codestring);
		
		ModelMenace m=new ModelMenace();
		m.supprimerMenace(codelong);
		
		request.getRequestDispatcher("displayvulnerabilites.jsp").forward(request, response);
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
