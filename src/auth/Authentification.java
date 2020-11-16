package auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import users.ModelUser;

@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Authentification() {
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");		
		
	if(username!=null && password!=null) {
			ModelUser modu=new ModelUser();
			if (ModelUser.chercherUser(username, password)!=null) {
				HttpSession session=request.getSession(true);				
				session.setAttribute("model", modu);
				session.setAttribute("id", ModelUser.chercherUser(username, password).getRole());
				System.out.println("le role apres connexion "+ModelUser.chercherUser(username, password).getRole());
				if (ModelUser.chercherUser(username, password).getRole().equals("admin")) {
					request.getRequestDispatcher("4admin.jsp").forward(request, response);
				}
				request.getRequestDispatcher("4users.jsp").forward(request, response);
				session.setAttribute("userID", ModelUser.chercherUser(username, password).getId_u());
				session.setAttribute("username", ModelUser.chercherUser(username, password).getNom());
			}
	
				else {
					request.setAttribute("message", "Merci de verifier vos identifiants!");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}	
		}
			else {
				request.setAttribute("message", "Verifiez vos parametres");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}