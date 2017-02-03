package com.tide.sgbs5.service;

import java.util.List;

import javax.annotation.Resource;

import com.tide.sgbs5.model.UsedCurrentDTO;
import com.tide.sgbs5.model.UsedDao;
import com.tide.sgbs5.model.UsedPageDto;

public class UsedCurrentServiceImpl implements UsedCurrentService {

	@Resource(name="usedDaoImpl")
	private UsedDao usedDao;
	
	@Override
	public List<UsedCurrentDTO> usedShow(UsedCurrentDTO usedCurrentDto) {
		System.out.println("경로 : UsedCurrentServiceImpl -- usedShow( ) 접속됨");
		return usedDao.usedShow(usedCurrentDto);
	}
	
	@Override
	public UsedCurrentDTO usedCurrentDto(String addr1, String addr2) {
		System.out.println("경로 : UsedCurrentServiceImpl -- usedCurrentDto( ) 접속됨");
		return usedDao.usedCurrentDto(addr1, addr2);
	}
	
	@Override
	public List<UsedCurrentDTO> getUsedList(String addr1, String addr2) {
		System.out.println("경로 : UsedCurrentServiceImpl -- getUsedList( ) 접속됨");
		return usedDao.getUsedList(addr1, addr2);
	}

	@Override
	public UsedPageDto pagingProc(int nowPage, int nowBlock, int totalRecord) {
		System.out.println("경로 : UsedCurrentServiceImpl -- pagingProc( ) 접속됨");
		int numPerPage = 5;  
		int pagePerBlock = 4;
		int totalPage = (int)Math.ceil((double)totalRecord / numPerPage); 
		int beginPerPage = nowPage * numPerPage;
		int totalBlock = (int)Math.ceil((double)totalPage / pagePerBlock);
		
		UsedPageDto page = new UsedPageDto();
		
		page.setBeginPerPage(beginPerPage);
		page.setNowBlock(nowBlock);
		page.setNowPage(nowPage);
		page.setNumPerPage(numPerPage);
		page.setPagePerBlock(pagePerBlock);
		page.setTotalBlock(totalBlock);
		page.setTotalPage(totalPage);
		page.setTotalRecord(totalRecord);
		return page;
	}

}
