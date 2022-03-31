package dao;

import java.util.List;
import dto.HouseDeal;
import dto.HouseDetail;

public interface IHouseDealDao {
	// int insert(HouseDeal book);
	//int delete(int no);
	HouseDetail selectOne(int aptCode);
	List<HouseDeal> selectAll(String keyword);
}
