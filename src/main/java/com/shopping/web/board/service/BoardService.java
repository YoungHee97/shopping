package com.shopping.web.board.service;

import com.shopping.web.board.dao.BoardDao;
import com.shopping.web.board.dto.BoardDto;
import com.shopping.web.board.form.BoardForm;
import com.shopping.web.member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    /** 게시판 삭제*/
    public BoardDto deleteBoard(BoardForm boardForm) throws Exception {

        BoardDto boardDto = new BoardDto();

        int deleteCnt = boardDao.deleteBoard(boardForm);

        if (deleteCnt > 0) {
            boardDto.setResult("SUCCESS");
        } else {
            boardDto.setResult("FAIL");
        }

        return boardDto;
    }

    /** 게시판 - 수정 */
    public void updateBoard(BoardForm boardForm) throws Exception {

        BoardDto boardDto = new BoardDto();

        boardDto.setBoard_title(boardForm.getBoard_title());
        boardDto.setBoard_contents(boardForm.getBoard_contents());

        boardDao.updateBoard(boardForm);

    }

}

