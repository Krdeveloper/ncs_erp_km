package kr.or.dgit.ncs_erp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs_erp.dao.TitleMapper;
import kr.or.dgit.ncs_erp.dao.TitleMapperImpl;
import kr.or.dgit.ncs_erp.dto.Title;
import kr.or.dgit.nrc_erp.util.MyBatisSqlSessionFactory;



public class TitleService {
	public static final TitleService instance = new TitleService();
	public TitleService() {}
	public static TitleService getInstance(){
		return instance;
	}
	
	public List<Title> selectTitleByAll() {//title 테이블 모든값
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			return titleMapper.selectTitleByAll();
		} 
	}
}
