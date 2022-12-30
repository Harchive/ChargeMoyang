package com.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class Service_TBDAOImpl implements Service_TBDAO {
	SqlSession sqlSession;
	@Autowired
	public Service_TBDAOImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@Override
	public int insert(Service_TBDTO board) {
		return sqlSession.insert("com.project.service.write", board);
	}

	@Override
	public List<Service_TBDTO> boardList() {
		return sqlSession.selectList("com.project.service.selectall");
	}

	@Override
	public Service_TBDTO getBoardInfo(String board_no) {
		return sqlSession.selectOne("com.project.service.read", board_no);
	}

	@Override
	public int update(Service_TBDTO board) {
		return sqlSession.update("com.project.service.update", board);
	}

	@Override
	public int delete(String board_no) {
		return sqlSession.delete("com.project.service.delete",board_no);
	}

	@Override
	public List<Service_TBDTO> search(String tag, String data) {
		Map<String,String> map =new HashMap<String, String>();
		map.put("tag", tag);
		map.put("data", data);
		return sqlSession.selectList("com.project.service.dynamicSearch", map);
	}

	@Override
	public List<Service_TBDTO> findByCategory(String board_category) {
		return sqlSession.selectList("com.project.service.categorySelect", 
				board_category);
	}

}
