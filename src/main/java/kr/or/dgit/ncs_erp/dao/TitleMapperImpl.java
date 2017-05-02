package kr.or.dgit.ncs_erp.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs_erp.dto.Title;


public class TitleMapperImpl implements TitleMapper{
	private SqlSession sqlSession;
	private static final Log log = LogFactory.getLog(TitleMapperImpl.class);
	private String nameSpace = "kr.or.dgit.ncs_erp.dao.TitleMapper.";
	
	public TitleMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Title> selectTitleByAll() {
		log.debug("selectTitleByAll()");
		return sqlSession.selectList(nameSpace + "selectTitleByAll");
	}

}
