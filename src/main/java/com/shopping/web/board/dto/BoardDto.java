package com.shopping.web.board.dto;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDto {
    private int board_id;
    private String board_title;
    private String board_contents;
    private String board_date;
    private int member_id;
    private String result;
    private int board_hits;


    public void setResult(String result) {
        this.result = result;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    public void setBoard_contents(String board_contents) {
        this.board_contents = board_contents;
    }

    public void setBoard_date(String board_date) {
        this.board_date = board_date;
    }

    public void setMember_id(int member_id){this.member_id = member_id;}

    public void setBoard_hits(int board_hits){
        this.board_hits = board_hits;
    }

    public int getBoard_id() {
        return board_id;
    }

    public String getBoard_title() {
        return board_title;
    }

    public String getBoard_contents() {
        return board_contents;
    }

    public String getBoard_date() {
        return board_date;
    }

    public int getMember_id(){
        return member_id;
    }

    public String getResult() {
        return result;
    }

    public int getBoard_hits(){return board_hits;}
}

