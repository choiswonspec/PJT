package controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HouseDealDaoImpl;
import dao.IHouseDealDao;
import dto.HouseDeal;
import dto.HouseDetail;
import service.HouseDealServiceImpl;
import service.IHouseDealService;

@WebServlet("/HouseDealServlet")
public class HouseDealServlet extends HttpServlet  {
	
	private IHouseDealService housedealserviceimpl = HouseDealServiceImpl.getHousedealservice();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String act = req.getParameter("act");
		
		if(act.equals("search")) {
			//부동산 전체 조회
			String keyword = req.getParameter("keyword");
			req.setAttribute("hList", housedealserviceimpl.selectAll(keyword));
			RequestDispatcher disp = req.getRequestDispatcher("search.jsp");
			disp.forward(req, resp);
		}
		else if(act.equals("add")) {
			RequestDispatcher disp = req.getRequestDispatcher("BookAddForm.jsp");
			disp.forward(req,resp);
			
		}
		else if(act.equals("delete")) {
			String aptCodeStr = req.getParameter("aptCode");
			int aptCode = Integer.parseInt(aptCodeStr);
			
			//req.setAttribute("result", house_dao.delete(aptCode));
			RequestDispatcher disp = req.getRequestDispatcher("BookDeleteResult.jsp");
			disp.forward(req,resp);
		}
		else if(act.equals("read")) {
			//부동산 매물 상세조회
			String aptCodeStr = req.getParameter("aptCode");
			int aptCode = Integer.parseInt(aptCodeStr);
			System.out.println(aptCode);
			HouseDetail housedetail = housedealserviceimpl.selectOne(aptCode);
			
			req.setAttribute("housedetail", housedetail);
			RequestDispatcher disp = req.getRequestDispatcher("houseDetail.jsp");
			disp.forward(req,resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String act = req.getParameter("act");
		
		try {
			if(act.equals("search")) {
				String keyword = req.getParameter("keyword");
				
				req.setAttribute("hList", housedealserviceimpl.selectAll(keyword));
				//결과창 보여주기 
				RequestDispatcher disp = req.getRequestDispatcher("search.jsp");
				disp.forward(req,resp);
			}
			
		} catch (Exception e) {
			req.setAttribute("exception", e);
			RequestDispatcher disp = req.getRequestDispatcher("Error.jsp");
			disp.forward(req,resp);
			
		}
		
	}
}
