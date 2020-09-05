package com.shopping.web.member.dto;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDto {
    private int member_id;
    private String member_nick;
    private String member_email;
    private String member_password;

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public void setMember_nick(String member_nick) {
        this.member_nick = member_nick;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    public void setMember_password(String member_password) {
        this.member_password = member_password;
    }

    public int getMember_id() {
        return member_id;
    }

    public String getMember_nick() {
        return member_nick;
    }

    public String getMember_email() {
        return member_email;
    }

    public String getMember_password() {
        return member_password;
    }

}
