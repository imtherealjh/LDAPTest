package com.example.LDAPTest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import static org.springframework.ldap.query.LdapQueryBuilder.query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class LDAPController {
    @Autowired private LdapTemplate ldapTemplate; 
    
    @PostMapping("/auth")
    public UserResponse authUser(@RequestBody UserRequest userRequest) {
        List<UserResponse> users = ldapTemplate.search(query().where("objectclass").is("person")
                 .and(query().where("cn").is(userRequest.getUsername()))
                 .and(query().where("userPassword").is(userRequest.getPassword())), 
               (AttributesMapper<UserResponse>) attrs -> { 
                   return new UserResponse((String) attrs.get("uId").get(), (String) attrs.get("sn").get(), (String) attrs.get("cn").get(), (String) attrs.get("givenName").get(), (String) attrs.get("mail").get());
                });
        
         return !users.isEmpty() ? users.get(0) : null;
    }
}
