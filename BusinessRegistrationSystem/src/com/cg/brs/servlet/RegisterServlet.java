package com.cg.brs.servlet;

import java.io.IOException;






import java.time.LocalDateTime;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.brs.bean.UserBean;
import com.cg.brs.exception.RegisterException;
import com.cg.brs.service.IRegisterService;
import com.cg.brs.service.RegisterService;
import com.cg.brs.util.ValidationUtil;





@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private IRegisterService service;
	private UserBean user;
	private String ownerName;
	private String fname;
	private String mname;
	private String lname;
	private String bname;
	private String email;
	private long phNo;
	private int ActCode;
	private int firmId;
	private LocalDateTime date;
	private String message ="Sorry your request cannot be processed as entered details do not match";
	
	
    public RegisterServlet() {
       service= new RegisterService();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session  = request.getSession();
		String action  = request.getParameter("action");
		switch(action){
		
		case "displayPage":
			//forward request to registration.html
			//dispatching request 			
						
			RequestDispatcher dispatcher = 
			request.getRequestDispatcher("register.jsp");
			
			dispatcher.forward(request,response);
			
			break;
			
		case "GoHome" :
			 RequestDispatcher dispatcher1= request.getRequestDispatcher("index.jsp");
			 dispatcher1.forward(request, response);
			 break;
			 
		case "Update":
			
			 RequestDispatcher dispatcher2= request.getRequestDispatcher("Activate.jsp");
			 dispatcher2.forward(request, response);
			 break;
		
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher =null;
		
		String act  = request.getParameter("action");
		
		switch(act){
		
		case "Register":
			fname= request.getParameter("fName");
			lname= request.getParameter("lName");
			mname= request.getParameter("mName");
			ownerName= fname+" "+lname+" "+mname;
			bname= request.getParameter("bName");
			email= request.getParameter("eMail");
			String mNo= request.getParameter("Mnumber");
			phNo= Long.parseLong(mNo);
			//ActCode=(int) Math.random()*9999;
			Random random= new Random();
			ActCode = random.nextInt(10000)+10000;
			
			System.out.println("Asdd: "+ ActCode);
			request.getSession(false).setAttribute("ActivationCode",ActCode);
			request.getSession(false).setAttribute("Email", email);
			
			user = new UserBean(ownerName, bname, email, phNo);
			try {
				firmId = service.RegisterDetailDao(user);
			} catch (RegisterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dispatcher = request.getRequestDispatcher("sucess.jsp");
			dispatcher.forward(request, response);
			
			break;
			
		case "Update":
			try {
			email= request.getParameter("eMail");
			String ActivationCode= request.getParameter("Acode");
			int CodeA= Integer.parseInt(ActivationCode);
			int Acode =	(int) request.getSession(false).getAttribute("ActivationCode");
			String sEmail= (String) request.getSession(false).getAttribute("Email");
			System.out.println(email+" "+sEmail+" "+CodeA+" "+Acode);
			Boolean flag =ValidationUtil.validateRequest(email,sEmail,CodeA,Acode);
			
			if(flag==true)
			{
			
				Boolean flag1= service.ActivateDeatailDao(email);
				if(flag1== true)
				{
					date = LocalDateTime.now();
					String datetime= date.toString();
					request.setAttribute("DT", date);
					dispatcher = request.getRequestDispatcher("Activated.jsp");
					dispatcher.forward(request, response);
					request.getSession(false).invalidate();
				}
			
			
		   }
			else
			{	
				request.setAttribute("Error1", message);
				dispatcher = request.getRequestDispatcher("Activate.jsp");
				dispatcher.forward(request, response);
			}
			
			} catch (RegisterException e) {
				// TODO Auto-generated catch block
				request.setAttribute("Error", e.getMessage());
				dispatcher = request.getRequestDispatcher("Error.jsp");
				dispatcher.forward(request, response);
			}
		}
		

}
}
