package com.shopping.web.member.service;

import com.shopping.web.member.dao.MemberDao;
import com.shopping.web.member.dto.MemberDto;
import com.shopping.web.member.form.MemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void insertMember(MemberForm memberForm) throws Exception {
        MemberDto memberDto = new MemberDto();

        memberDto.setMember_email(memberForm.getMember_email());
        memberDto.setMember_nick(memberForm.getMember_nick());
        memberDto.setMember_password(passwordEncoder.encode(memberForm.getMember_password()));

        memberDao.insertMember(memberDto);
    }
    public List<MemberForm> getMemberList(MemberForm memberForm) throws Exception {
        return memberDao.getMemberList(memberForm);
    }
    public void insertMemberAsList(List<MemberForm> list) throws Exception {
        for (MemberForm memberForm : list) {
            if (memberDao.isExistMember(memberForm) != 0) {
                continue;
            }
            MemberDto memberDto = new MemberDto();
            memberDto.setMember_nick(memberForm.getMember_nick());
            memberDto.setMember_email(memberForm.getMember_email());
            memberDto.setMember_password(memberForm.getMember_password());
            memberDao.insertMember(memberDto);
        }
    }


}
