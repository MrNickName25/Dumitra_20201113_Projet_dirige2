package jUnit4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Test;

import auth.Authentification;

public class TestAuth {
	Authentification auth=new Authentification();
	HttpServletRequest request;
	HttpServletResponse response;
	String page="";
	
	
	
	@Test
	public void testAuthentification() throws ServletException, IOException {
		request.setAttribute("user", "admin");
		request.setAttribute("pass", "admin");
	auth.doGet(request, response);
	auth.toString();
	page.toString();
	}
}
