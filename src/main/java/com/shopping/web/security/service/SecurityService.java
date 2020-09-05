package com.shopping.web.security.service;

import com.shopping.web.security.dao.SecurityDao;
import com.shopping.web.security.details.SecurityDetails;
import com.shopping.web.security.vo.SecurityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService implements UserDetailsService{
    @Autowired
    private SecurityDao securityDao;

    @Override
    public SecurityDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        SecurityDetails securityDetails = null;
        try {
            securityDetails = loadSecurityDetailsByEmail(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (securityDetails == null) throw new UsernameNotFoundException("");

        return securityDetails;
    }

    private SecurityDetails loadSecurityDetailsByEmail(String username) throws Exception {
        SecurityDetails securityDetails = new SecurityDetails();

        SecurityVo securityVo = securityDao.loadSecurityVoByEmail(username);

        if (securityVo == null) return null;

        securityDetails.setUsername(securityVo.getMember_email());
        securityDetails.setPassword(securityVo.getMember_password());

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

        if (securityVo.getMember_type().equals("admin")) roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        else if (securityVo.getMember_type().equals("user")) roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        else if (securityVo.getMember_type().equals("restricted")) roles.add(new SimpleGrantedAuthority("ROLE_RESTRICTED"));

        securityDetails.setAuthorities(roles);

        return securityDetails;
    }

}
