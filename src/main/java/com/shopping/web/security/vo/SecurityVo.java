package com.shopping.web.security.vo;

public class SecurityVo {
    private String member_email;
    private String member_password;
    private String member_type;

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    public void setMember_password(String member_password) {
        this.member_password = member_password;
    }

    public void setMember_type(String member_type) {
        this.member_type = member_type;
    }

    public String getMember_email() {
        return member_email;
    }

    public String getMember_password() {
        return member_password;
    }

    public String getMember_type() {
        return member_type;
    }

}
