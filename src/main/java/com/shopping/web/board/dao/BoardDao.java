package com.shopping.web.board.dao;

import com.shopping.web.board.dto.BoardDto;
import com.shopping.web.board.form.BoardForm;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BoardDao {
    @Resource(name = "sqlSession")
    private SqlSession sqlSession;

    private static final String NAMESPACE = "com.shopping.web.BoardMapper";

    public List<BoardDto> getBoardList(BoardForm boardForm) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".getBoardList", boardForm);
    }
}

