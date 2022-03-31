package service;

import java.util.List;

import dao.HouseDealDaoImpl;
import dao.IHouseDealDao;
import dao.IMemberDao;
import dao.MemberDaoImpl;
import dto.HouseDeal;
import dto.HouseDetail;

public class HouseDealServiceImpl implements IHouseDealService {
	
	private IHouseDealDao housedealdaoimpl = HouseDealDaoImpl.getInstance();
	
	private static IHouseDealService housedealservice = new HouseDealServiceImpl();
	
	private HouseDealServiceImpl() {
	}
	
	public static IHouseDealService getHousedealservice() {
		return housedealservice;
	}


	@Override
	public HouseDetail selectOne(int aptCode) {
		return housedealdaoimpl.selectOne(aptCode);
	}

	@Override
	public List<HouseDeal> selectAll(String keyword) {
		return housedealdaoimpl.selectAll(keyword);
	}

}
