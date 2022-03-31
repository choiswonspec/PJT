package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Member;
import util.DBUtil;

public class MemberDaoImpl implements IMemberDao{
	
	private DBUtil dbUtil = DBUtil.getInstance();
	
	private static MemberDaoImpl memberdaoimpl = new MemberDaoImpl();
	
	private MemberDaoImpl() {}

	public static IMemberDao getMemberDao() {
		return memberdaoimpl;
	}
	
	// 아이디 체크
	@Override
	public int idCheck(String id) {
		int cnt = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder loginMember = new StringBuilder();
			loginMember.append("select count(memberID) \n");
			loginMember.append("from member \n");
			loginMember.append("where memberID = ?");
			pstmt = conn.prepareStatement(loginMember.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = Integer.parseInt(rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 1;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return cnt;
	}

	@Override
	public void registerMember(Member member) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder registerMember = new StringBuilder();
			registerMember.append("insert into member() \n");
			registerMember.append("values (?, ?, ?, ?)");
			pstmt = conn.prepareStatement(registerMember.toString());
			pstmt.setString(1, member.getMemberID());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
	}

	@Override
	public Member login(String id, String pass) throws SQLException {
		Member member = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder loginMember = new StringBuilder();
			loginMember.append("select * \n");
			loginMember.append("from member \n");
			loginMember.append("where memberID = ? and password = ? \n");
			pstmt = conn.prepareStatement(loginMember.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setMemberID(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setName(rs.getString(3));
				member.setEmail(rs.getString(4));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return member;
	}

	@Override
	public void delete(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder registerMember = new StringBuilder();
			registerMember.append("delete from member \n");
			registerMember.append("where memberID=?");
			pstmt = conn.prepareStatement(registerMember.toString());
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
	}

	@Override
	public void update(Member member) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			String sql = "UPDATE member SET password= ?, name=? , email=? WHERE memberID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getMemberID());
			
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
	}
	

}
