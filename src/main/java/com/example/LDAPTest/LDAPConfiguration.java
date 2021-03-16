package com.example.LDAPTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LDAPConfiguration {
    @Bean
    public LdapContextSource contextSource(){
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://localhost:8389");
        contextSource.setBase("dc=springframework,dc=org");
        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate(){
        LdapTemplate template = new LdapTemplate(contextSource());
        return template;
    }
}
