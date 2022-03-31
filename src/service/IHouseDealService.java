package service;

import java.util.List;

import dto.HouseDeal;
import dto.HouseDetail;

public interface IHouseDealService {

	HouseDetail selectOne(int aptCode);
	List<HouseDeal> selectAll(String keyword);
}
