package com.becoder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.becoder.conn.HibernateUtil;
import com.becoder.dao.EmpDao;
import com.becoder.entity.Emp;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		
		String name = req.getParameter("name");
		String department = req.getParameter("department");
		String salary = req.getParameter("salary");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		
		Emp emp = new Emp(name, department, salary, email, password);
		System.out.println(emp);
		
		EmpDao dao = new EmpDao(HibernateUtil.getSessionFactory());
		boolean f=dao.saveEmp(emp);
		if(f) 
		{
			System.out.println("emp registration succesfully::");
		}else {
			System.out.println("somthing went Wrong....!!!!!");
		}
		
	}
	
	
	

}
