package vulnerabilities;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SupprimerLogiciel")
public class SupprimerLogiciel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SupprimerLogiciel() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String codestring=request.getParameter("id_index_vulenrabilite");
		long codelong=Long. parseLong(codestring);
		
		ModelLogiciel m=new ModelLogiciel();
		m.supprimerLogiciel(codelong);
		
		request.getRequestDispatcher("displaylogiciels.jsp").forward(request, response);
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
