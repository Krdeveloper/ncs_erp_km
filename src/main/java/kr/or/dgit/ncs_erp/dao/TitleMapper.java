package kr.or.dgit.ncs_erp.dao;

import java.util.List;

import kr.or.dgit.ncs_erp.dto.Title;

public interface TitleMapper {
	List<Title> selectTitleByAll();
	int insertTitleItem (Title title);//db table입력
	int updateTitleItem (Title title);//db table 값수정
	int deleteTitleItem (Title title);//delete one of the table's item
}
