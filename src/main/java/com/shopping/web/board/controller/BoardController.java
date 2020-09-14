package com.shopping.web.board.controller;

import com.shopping.web.board.dto.BoardDto;
import com.shopping.web.board.form.BoardForm;
import com.shopping.web.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/getBoardList")
    @ResponseBody
    public List<BoardDto> getBoardList(HttpServletRequest request, HttpServletResponse response, BoardForm boardForm) throws Exception {
        List<BoardDto> list = boardService.getBoardList(boardForm);
        return list;
    }

    @RequestMapping(value="/boardList", method = RequestMethod.GET)
    public String getHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/board/boardList";
    }

    @RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
    public String getSignUpPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/board/boardWrite";
    }

    @RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
    public String signUpPost(HttpServletRequest request, HttpServletResponse response, Authentication authentication, BoardForm boardForm, RedirectAttributes rttr) throws Exception {
        boardService.insertBoard(boardForm, authentication.getName());

        rttr.addFlashAttribute("msg", "글이 작성되었습니다.");
        return "redirect:/board/boardList";
    }

    @RequestMapping(value = "/boardDetails")
    public String boardDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "board/boardDetails";
    }

    @RequestMapping(value = "/getBoardDetails")
    @ResponseBody
    public BoardForm getBoardDetails(HttpServletRequest request, HttpServletResponse response, BoardForm boardForm) throws Exception {

        return boardService.getBoardDetails(boardForm);
    }

    @RequestMapping( value = "/deleteBoard")
    @ResponseBody
    public BoardDto deleteBoard(HttpServletRequest request, HttpServletResponse response, BoardForm boardForm) throws Exception{

        BoardDto boardDto = boardService.deleteBoard(boardForm);

        return boardDto;
    }
}

