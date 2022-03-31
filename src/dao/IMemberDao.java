package dao;

import java.sql.SQLException;

import dto.Member;

public interface IMemberDao {
	
	int idCheck(String id);
	void registerMember(Member memberDto) throws SQLException;
	Member login(String id, String pass) throws SQLException;
	void delete(String id) throws SQLException; // id를 통해 delete
	void update(Member member) throws SQLException; // 회원정보 수정 

}
