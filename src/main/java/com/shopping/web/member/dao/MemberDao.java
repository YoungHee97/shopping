package com.shopping.web.member.dao;

import com.shopping.web.member.dto.MemberDto;
import com.shopping.web.member.form.MemberForm;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class MemberDao {
    @Resource(name ="sqlSession")
    private SqlSession sqlSession;

    private static final String NAMESPACE = "com.shopping.web.MemberMapper";

    public void insertMember(MemberDto memberDto) throws Exception {
        sqlSession.insert(NAMESPACE + ".insertMember", memberDto);
    }

    public int getMemberIdFromEmail(String username) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".getMemberIdFromEmail", username);
    }

    public List<MemberForm> getMemberList(MemberForm memberForm) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".getMemberList", memberForm);
    }

    public int isExistMember(MemberForm memberForm) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".isExistMember", memberForm);
    }

}
