package com.shopping.web.board.dao;

import com.shopping.web.board.dto.BoardDto;
import com.shopping.web.board.form.BoardForm;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.xml.stream.events.Namespace;
import java.util.List;

@Repository
public class BoardDao {
    @Resource(name = "sqlSession")
    private SqlSession sqlSession;

    private static final String NAMESPACE = "com.shopping.web.BoardMapper";

    public List<BoardDto> getBoardList(BoardForm boardForm) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".getBoardList", boardForm);
    }

    public void insertBoard(BoardDto boardDto) throws Exception {
        sqlSession.insert(NAMESPACE + ".insertBoard", boardDto);
    }

    public BoardForm getBoardDetails(BoardForm boardForm) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".getBoardDetails", boardForm);
    }

    /** 게시판 - 삭제  */
    public int deleteBoard(BoardForm boardForm) throws Exception {

        return sqlSession.delete(NAMESPACE + ".deleteBoard", boardForm);
    }

    /** 게시판 - 수정  */
    public int updateBoard(BoardForm boardForm) throws Exception {

        return sqlSession.update(NAMESPACE + ".updateBoard", boardForm);
    }

    /** 게시판 조회수 - 수정 */
    public int updateBoardHits(BoardForm boardForm) throws Exception{

        return sqlSession.update(NAMESPACE+ ".updateBoardHits", boardForm);
    }
}

