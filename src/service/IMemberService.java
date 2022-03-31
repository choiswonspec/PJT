package service;

import java.sql.SQLException;

import dto.Member;

public interface IMemberService {
	int idCheck(String id);
	void registerMember(Member member) throws Exception;
	Member login(String id, String pass) throws Exception;
	void delete(String id) throws SQLException; // id를 통해 delete
	void update(Member member) throws SQLException; // 회원정보 수정 
	
//	구현해 보세요!!!
//	void updateMember(MemberDto memberDto) throws Exception;
//	void deleteMember(String id) throws Exception;
//	MemberDto infoMember(String id) throws Exception;

}
