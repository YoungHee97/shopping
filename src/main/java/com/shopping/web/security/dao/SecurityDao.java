package com.shopping.web.security.dao;

import com.shopping.web.security.vo.SecurityVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class SecurityDao {
    @Resource(name = "sqlSession")
    private SqlSession sqlSession;

    private static final String NAMESPACE = "com.shopping.web.SecurityMapper";

    public SecurityVo loadSecurityVoByEmail(String username) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".loadSecurityVoByEmail", username);
    }

}
