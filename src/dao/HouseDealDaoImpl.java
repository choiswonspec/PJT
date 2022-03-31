package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.HouseDeal;
import dto.HouseDetail;
import util.DBUtil;

public class HouseDealDaoImpl implements IHouseDealDao {
	
	// singleton 패턴 적용
	private HouseDealDaoImpl() {}
	private static HouseDealDaoImpl instance = new HouseDealDaoImpl();
	public static HouseDealDaoImpl getInstance() {
		return instance;
	}

	@Override
	public HouseDetail selectOne(int aptCode) {
		//상세화면
		Connection conn = null;
		PreparedStatement pstmt = null; // Statement를 써도 되지만 효율성도 떨어지고 쓰기도 불편함.
		ResultSet rs = null; // select일때는 결과가 rs
		HouseDetail result = null; 
		DBUtil util = DBUtil.getInstance();
		try {
			conn = util.getConnection();
			String sql = "SELECT houseInfo.aptCode, houseInfo.aptName, houseInfo.dongCode, houseInfo.dongName, houseInfo.img, houseDeal.dealAmount, houseDeal.dealYear, houseDeal.dealMonth, houseDeal.dealDay, houseDeal.area, houseDeal.floor, houseDeal.type FROM houseDeal inner join houseInfo using(aptCode) where houseDeal.aptCode = ? limit 30";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aptCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new HouseDetail(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 사용했던 자원들 반납!!
			util.close(rs, pstmt, conn);
		}
		return result;
	}

	@Override
	public List<HouseDeal> selectAll(String keyword) {
		//리스트 화면 -> 적은 정보
		Connection conn = null;
		PreparedStatement pstmt = null; // Statement를 써도 되지만 효율성도 떨어지고 쓰기도 불편함.
		ResultSet rs = null; // select일때는 결과가 rs
		ArrayList<HouseDeal> result = new ArrayList<>(); 
		DBUtil util = DBUtil.getInstance();
		System.out.println(keyword);
		try {
			conn = util.getConnection();
			if(keyword != null) {
				String sql = "SELECT houseInfo.aptCode, houseInfo.aptName, houseInfo.dongName, houseInfo.lat, houseInfo.lng, houseDeal.dealAmount, houseDeal.area, houseDeal.floor, houseDeal.type FROM houseDeal inner join houseInfo on houseInfo.aptCode = houseDeal.aptCode where aptName like '%"+ keyword + " %' or dongName like '% "+ keyword + " %' limit 100 ";
				pstmt = conn.prepareStatement(sql);

				rs = pstmt.executeQuery();
			}
			else if(keyword == null) {
				String sql = "SELECT houseInfo.aptCode, houseInfo.aptName, houseInfo.dongName, houseInfo.lat, houseInfo.lng, houseDeal.dealAmount, houseDeal.area, houseDeal.floor, houseDeal.type FROM houseDeal inner join houseInfo on houseInfo.aptCode = houseDeal.aptCode limit 100";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}
			
			while(rs.next()) {
				int aptCode = rs.getInt("aptCode");
				String aptName = rs.getString("aptName");
				String dongName = rs.getString("dongName");
				String dealAmount = rs.getString("dealAmount");
				String area = rs.getString("area");
				String floor = rs.getString("floor");
				String type = rs.getString("type");
				String lat = rs.getString("lat");
				String lng = rs.getString("lng");
				result.add(new HouseDeal(aptCode, aptName, dongName, dealAmount, area, floor, type,lat,lng));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 사용했던 자원들 반납!!
			util.close(rs, pstmt, conn);
		}
		return result;
	}

}
