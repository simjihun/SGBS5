package com.tide.sgbs5.service;

import java.util.List;

import com.tide.sgbs5.model.UsedCurrentDTO;
import com.tide.sgbs5.model.UsedPageDto;

public interface UsedCurrentService {

	public List<UsedCurrentDTO> usedShow(UsedCurrentDTO usedCurrentDto);
	public UsedCurrentDTO usedCurrentDto(String addr1, String addr2);
	public List<UsedCurrentDTO> getUsedList(String addr1, String addr2);
	public UsedPageDto pagingProc(int nowPage, int nowBlock, int totalRecord);
}
