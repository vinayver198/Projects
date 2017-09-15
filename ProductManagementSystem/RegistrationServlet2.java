package com.cg.flat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet2
 */
@WebServlet("/RegistrationServlet2")
public class RegistrationServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationServlet2() 
    {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		String action  = request.getParameter("action");
		switch(action)
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
	}

}
