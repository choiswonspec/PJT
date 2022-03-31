package service;


import java.sql.SQLException;

import dao.IMemberDao;
import dao.MemberDaoImpl;
import dto.Member;

public class MemberServiceImpl implements IMemberService {
	
	private IMemberDao memberDaoimpl = MemberDaoImpl.getMemberDao();
	
	private static IMemberService memberServiceimpl = new MemberServiceImpl();
	
	private MemberServiceImpl() {}
	
	public static IMemberService getMemberServiceimpl() {
		return memberServiceimpl;
	}

	@Override
	public int idCheck(String id) {
		return memberDaoimpl.idCheck(id);
	}

	@Override
	public void registerMember(Member member) throws Exception {
		memberDaoimpl.registerMember(member);
		
	}

	@Override
	public Member login(String id, String pass) throws Exception {
		return memberDaoimpl.login(id, pass);
	}

	@Override
	public void delete(String id) throws SQLException {
		memberDaoimpl.delete(id);
		
	}

	@Override
	public void update(Member member) throws SQLException {
		memberDaoimpl.update(member);
		
	}

}
