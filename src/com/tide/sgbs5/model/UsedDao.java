package com.tide.sgbs5.model;

import java.util.List;

public interface UsedDao {

	public  List<UsedCurrentDTO> usedShow(UsedCurrentDTO usedCurrentDto);
	public UsedCurrentDTO usedCurrentDto(String addr1, String addr2);
	public List<UsedCurrentDTO> getUsedList(String addr1, String addr2);
	

}
