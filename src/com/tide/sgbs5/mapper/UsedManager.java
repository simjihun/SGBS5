package com.tide.sgbs5.mapper;


import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tide.sgbs5.model.UsedCurrentDTO;

public class UsedManager {

	
	private static SqlSessionFactory sqlMapper;
	static{
		try {
			Reader reader = Resources.getResourceAsReader("com/tide/sgbs5/mybatis/sqlmapConfig.xml");
			System.out.println("경로 : UsedManager -- sqlMapper 접속됨");
			sqlMapper = new SqlSessionFactoryBuilder().build(reader); 
		} catch (IOException err){
			throw new RuntimeException("SQL세션팩토리 인스턴스 생성 실패" + err,err);
		}
	}
	
	public static List<UsedCurrentDTO> usedShow(UsedCurrentDTO usedCurrentDto){
		List<UsedCurrentDTO> list = null;
		SqlSession session = sqlMapper.openSession();
		list = session.selectList("usedShow",usedCurrentDto);
		return list;
	}
	
	public static UsedCurrentDTO usedCurrentDto(String addr1, String addr2){
		SqlSession session = sqlMapper.openSession();
		UsedCurrentDTO result = new UsedCurrentDTO();
		System.out.println("경로 : UsedManager -- usedCurrentDto 접속됨");
		if(addr1 != null && addr2 != null && addr1 !="" && addr2 !=""){
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("addr1",addr1);
			map.put("addr2", addr2);
			System.out.println("경로 : UsedManager -- Hashmap에 정보담음 addr1 : " + map.get(addr1) );
			if(!(session.selectOne("usedCurrentDto",map) == null)){
				result = session.selectOne("usedCurrentDto",map);
				System.out.println("경로 : UsedManager -- IF문 안에 -- 일치 " + map.get(addr1) );
			}else{
				System.out.println("경로 : UsedManager -- IF문 안에  불일치 " + map.get(addr1) );
				result.setAddr1("null");
				result.setAddr2("null");
			}
			session.close();
			return result;
		}else{
			session.close();
			System.out.println("경로 : UsedManager -- IF~else~else 둘중에 하나 공백 ");
			return result;
		}
	}
	
	public static List<UsedCurrentDTO> getUsedList(String addr1, String addr2){
		List<UsedCurrentDTO> list = null;
		SqlSession session = sqlMapper.openSession();
		System.out.println("경로 : UsedManager getUsedList -- 메소드 접근");
		if(addr1 != null && addr2 != null && addr1 !="" && addr2 !=""){
			Map<String, String> map = new HashMap<String, String> ();
			map.put("addr1" , addr1);
			map.put("addr2", addr2);
			System.out.println("경로 : UsedManager getUsedList -- 맵에 담는가" + map.get(addr1));
			list = session.selectList("usedCurrentList", map);
			session.close();
			return list;
		}else {
			list = session.selectList("usedCurrentList");
			session.close();
			return list;
		}
	}
}