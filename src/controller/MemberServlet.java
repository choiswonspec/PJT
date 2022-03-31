package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Member;
import service.IMemberService;
import service.MemberServiceImpl;


@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet{
	
	private IMemberService memberServiceimpl = MemberServiceImpl.getMemberServiceimpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/index.jsp";
		if(act.equals("mvlogin")) { // 로그인 페이지로 단순 이동
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}else if(act.equals("mvjoin")) { // 회원가입 페이지로 단순 이동
			response.sendRedirect(request.getContextPath() + "/join.jsp");
		}else if(act.equals("mvindex")) { // main 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}else if(act.equals("idcheck")) {
			int cnt = idCheck(request, response);
			response.getWriter().append(cnt + "");
		}else if(act.equals("login")) {
			path = loginMember(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		}else if(act.equals("logout")) {
			path = loginOutMember(request, response);
			response.sendRedirect(request.getContextPath() + path);
		}else if(act.equals("join")) {
			path = registerMember(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		}else if(act.equals("mvmyPage")) {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("userInfo");
			request.setAttribute("userInfo", member);
			request.getRequestDispatcher("/myPage.jsp").forward(request, response);
		}else if(act.equals("update")) {
			path = update(request, response);
			response.sendRedirect(request.getContextPath() + path);
			
		}else if(act.equals("delete")) {
			path = delete(request, response);
			response.sendRedirect(request.getContextPath() + path);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
		
	}
	
	private String update(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("userInfo");
		
		System.out.println(member.toString());
		
		String memberID = member.getMemberID();
		String after_password = request.getParameter("password");
		String after_name = request.getParameter("name");
		String after_email = request.getParameter("email");
		Member new_member = new Member(memberID,after_password,after_name,after_email);
		System.out.println(new_member.toString());
		session.setAttribute("userInfo", new_member);
		try {
			memberServiceimpl.update(new_member);
			System.out.println("update 성공");
			return "/myPage.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원 정보 수정 중 문제가 발생했습니다.");
			return "/error.jsp";
		}
		
	}
	private String delete(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("userInfo");
		String memberID = member.getMemberID();
		session.invalidate(); //session 비워버리기.
		try {
			memberServiceimpl.delete(memberID);
			System.out.println(memberID + ": delete 성공");
			return "/index.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원 삭제 중 문제가 발생했습니다.");
			return "/error.jsp";
		}
	}
	
	private int idCheck(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 1;
		String id = request.getParameter("ckid");
		cnt = memberServiceimpl.idCheck(id);
		return cnt;
		
	}
	
	private String registerMember(HttpServletRequest request, HttpServletResponse response) {
		Member member = new Member();
		member.setMemberID(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		System.out.println(member.toString());
		try {
			memberServiceimpl.registerMember(member);
			return "/login.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원 가입 중 문제가 발생했습니다.");
			return "/error.jsp";
		}
	}
	
	private String loginMember(HttpServletRequest request, HttpServletResponse response) {
		Member member = null;
		
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		
		try {
			member = memberServiceimpl.login(id, pass);
			if(member != null) { // 로그인 성공
//				session setting
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", member);
				
				String idsv = request.getParameter("idsave");
				
				if("saveok".equals(idsv)) { // 아이디 저장 체크
	//				Cookie setting
					Cookie cookie = new Cookie("loginid", id);
					cookie.setMaxAge(60*60*24*365*20);
					cookie.setPath(request.getContextPath());
					
					response.addCookie(cookie);
					
				} else { // 아이디 저장 체크 X
					Cookie[] cookies = request.getCookies();
					if(cookies != null) {
						for(int i=0;i<cookies.length;i++) {
							if(cookies[i].getName().equals("loginid")) {
								cookies[i].setMaxAge(0);
								response.addCookie(cookies[i]);
								break;
							}
						}
					}
				}
				
				return "/index.jsp";
			} else { // 로그인 실패
				request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요.");
				return "/login.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 처리중 문제 발생!!");
			return "/error.jsp";
		}
		
	}
	
	private String loginOutMember(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		session.setAttribute("userInfo", null);
//		session.removeAttribute("userInfo");
		session.invalidate();
		return "/index.jsp";
		
	}

}
