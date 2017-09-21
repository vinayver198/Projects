package com.cg.lab5.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.lab5.bean.BillDetail;
import com.cg.lab5.bean.Consumer;
import com.cg.lab5.exception.ConsumerException;
import com.cg.lab5.services.EBillService;
import com.cg.lab5.services.EBillServiceImpl;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BillServlet() 
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException,
			IOException 
	{
		String action = request.getParameter("action");
		
		switch(action)
		{
		case "login":
		RequestDispatcher dispatcher = 
		request.getRequestDispatcher("Login.jsp");
		
		dispatcher.forward(request,response);
		
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		String action = request.getParameter("action");
		RequestDispatcher dispatcher;
		switch(action)
		{
		case "Login":
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			
			if(user.equals("vinay") && pass.equals("vinay18"))
					{
					
					dispatcher = request.getRequestDispatcher("eBill.jsp");
					
					dispatcher.forward(request,response);
					
						
					}
			else
			{
				System.out.println("failure");
			}
			break;
			
		case "Calculate Bill":
			String ConsumerNum1 =request.getParameter("ConsumerNum");
			String LMMR1        =request.getParameter("LMMR");
			String CMMR1        =request.getParameter("CMMR");
			
			int consumerNum = Integer.valueOf(ConsumerNum1);
			float LMMR = Float.valueOf(LMMR1);
			float CMMR = Float.valueOf(CMMR1);
			
			float unitConsumed = LMMR-CMMR;
			float netAmount    = (float) ((unitConsumed*1.15)+100);
			BillDetail billDetail = new BillDetail(consumerNum,CMMR,unitConsumed,netAmount,Date.valueOf(LocalDate.now()));
			
			EBillService service = new EBillServiceImpl();
			try 
			{
			Consumer consumer	=service.addConsumer(billDetail);
				
				request.setAttribute("consumerName",consumer.getConsumerName() );
				request.setAttribute("ConsumerNo", consumerNum);
				request.setAttribute("unitConsumed", unitConsumed);
				request.setAttribute("netAmount", netAmount);
				
				dispatcher = request.getRequestDispatcher("success.jsp");
				
				dispatcher.forward(request,response);
				
			} catch (ConsumerException e) 
			{
				String errorMsg = e.getMessage();
				request.setAttribute("errorMsg", errorMsg);
				dispatcher = request.getRequestDispatcher("error.jsp");
				
				dispatcher.forward(request,response);
			}
			
			
			break;
		}
	}

}
