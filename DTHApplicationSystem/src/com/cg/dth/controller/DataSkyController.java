package com.cg.dth.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.dth.dto.accountBean;
import com.cg.dth.exception.DTHException;
import com.cg.dth.service.CustomerServiceImpl;


/**
 * Servlet implementation class DataSkyController
 */
@WebServlet("*.obj")
public class DataSkyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DataSkyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path=request.getServletPath().trim();
		String target="";
		String targetView="subAcctDetails.jsp";
		String targetError="error.jsp";
		float reccomendedRecharge=0;
		switch(path)
		{
		case "/Check.obj":
				CustomerServiceImpl costumerService = null;
				accountBean consumer = null;
				consumer = new accountBean();
				costumerService = new CustomerServiceImpl();
				long mobileNo = Long.parseLong(request.getParameter("mobile"));
				HttpSession session = request.getSession(true);
				try {
				consumer = costumerService.getOnMobile(mobileNo);
				reccomendedRecharge=costumerService.getAmount(consumer.getPackageId());
				
				} catch (DTHException e) {
					session.setAttribute("error", e.getMessage());
					target = targetError;
				}
				if (consumer.getSubscriberId() != 0) {
					session.setAttribute("error", null);
					session.setAttribute("costumer",consumer);
					target = targetView;
					reccomendedRecharge=reccomendedRecharge-consumer.getAccountBalance();
					session.setAttribute("reccomendedRecharge",reccomendedRecharge);
				} else {
					session.setAttribute("consumer", null);
					session.setAttribute("error",
							"Sorry No data Found for given ID!");
					target = targetError;
				}	
				
			break;	
			
		case "/Recharge.obj":
			
			consumer = new accountBean();
			costumerService = new CustomerServiceImpl();
			boolean flag=false;
			float amount=Float.parseFloat(request.getParameter("amount"));
			 session = request.getSession(true);
			if(amount<100)
			{
				target="less.jsp";
				break;
			}
			try
			{
				flag=costumerService.updateBalance((accountBean)session.getAttribute("costumer"), amount);
			    costumerService.updateDate((accountBean)session.getAttribute("costumer"));
			}catch (DTHException e) {
				session.setAttribute("error", e.getMessage());
				target = targetError;
			}
			if(flag==true)
			{
				target="success.jsp";
				
			}
			else
			{
				target=targetError;
				
			}
				break;
		
	}
		RequestDispatcher dispatcher = request.getRequestDispatcher(target);
		dispatcher.forward(request, response);	

	}
}
