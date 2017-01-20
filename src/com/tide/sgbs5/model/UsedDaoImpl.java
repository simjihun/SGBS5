package com.tide.sgbs5.model;

import java.util.ArrayList;
import java.util.List;

import com.tide.sgbs5.mapper.UsedManager;

public class UsedDaoImpl implements UsedDao {

	@Override
	public List<UsedCurrentDTO> usedShow(String rsd_id) {
		List<UsedCurrentDTO> result = new ArrayList<UsedCurrentDTO>();
		System.out.println("경로 : UsedDaoImpl -- usedShow -- rsd_id값 : " + rsd_id);
		result = UsedManager.usedShow(rsd_id);
		return result;
	}
	
	
	@Override
	public UsedCurrentDTO usedCurrentDto(String addr1, String addr2) {
		UsedCurrentDTO result = new UsedCurrentDTO();
		System.out.println("경로 : UsedDaoImpl -- usedCurrentDto -- addr1값 : " + addr1 + " addr2값 : " + addr2);
		result = UsedManager.usedCurrentDto(addr1, addr2);
		return result;
	}

	@Override
	public List<UsedCurrentDTO> getUsedList(String addr1, String addr2) {
		List<UsedCurrentDTO> result = new ArrayList<UsedCurrentDTO>();
		System.out.println("경로 : UsedDaoImpl -- getUsedList( ) 접속됨");
		System.out.println("경로 : UsedDaoImpl -- 정상적으로 값이 들어옴");
		System.out.println("경로 : UsedDaoImpl Before -- addr1 : " +addr1 + " // " + "addr2 : " + addr2);
		result = UsedManager.getUsedList(addr1, addr2);
		System.out.println("경로 : UsedDaoImpl After -- addr1 : " +result.size());
		return result;
	}
}
