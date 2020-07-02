package com.shopping.web.board.service;

import com.shopping.web.board.dao.BoardDao;
import com.shopping.web.board.dto.BoardDto;
import com.shopping.web.board.form.BoardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardDao boardDao;

    public List<BoardDto> getBoardList(BoardForm boardForm) throws Exception {
        return boardDao.getBoardList(boardForm);
    }
}

