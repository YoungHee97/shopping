package com.shopping.web.board.form;

public class BoardForm {
    private int board_id;
    private String board_title;
    private String board_contents;
    private String board_date;

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
}