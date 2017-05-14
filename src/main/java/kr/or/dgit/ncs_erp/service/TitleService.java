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
	
	public int insertTitleItem(Title title) {//db table에 입력
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			int res= titleMapper.insertTitleItem(title);
			sqlSession.commit();
			return res;
		} 
	}

	public int updateTitleItem(Title title) {//db table값수정
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			int res= titleMapper.updateTitleItem(title);
			sqlSession.commit();
			return res;
		} 
	}
	public int deleteTitleItem(Title title) {//delete one of the table's item
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			int res= titleMapper.deleteTitleItem(title);
			sqlSession.commit();
			return res;
		} 
	}
}
