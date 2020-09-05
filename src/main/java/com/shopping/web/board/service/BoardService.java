package com.shopping.web.board.service;

import com.shopping.web.board.dao.BoardDao;
import com.shopping.web.board.dto.BoardDto;
import com.shopping.web.board.form.BoardForm;
import com.shopping.web.member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardDao boardDao;
    @Autowired
    private MemberDao memberDao;

    public List<BoardDto> getBoardList(BoardForm boardForm) throws Exception {
        return boardDao.getBoardList(boardForm);
    }

    public void insertBoard(BoardForm boardForm, String username) throws Exception {
        BoardDto boardDto = new BoardDto();

        boardDto.setBoard_title(boardForm.getBoard_title());
        boardDto.setBoard_contents(boardForm.getBoard_contents());
        boardDto.setMember_id(memberDao.getMemberIdFromEmail(username));

        boardDao.insertBoard(boardDto);
    }

    public BoardForm getBoardDetails(BoardForm boardForm) throws Exception {
        return boardDao.getBoardDetails(boardForm);
    }

}

