package cn.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LdapService {

    private static final Logger LOG = LoggerFactory.getLogger(LdapService.class);

    //@Autowired
    //private LdapTemplate ldapTemplate;

    //public boolean ldapAuth(String username, String password) {
    //    LOG.debug("# username={},password={}", username, password);
    //    EqualsFilter filter = new EqualsFilter("sAMAccountName", username);
    //    boolean resp = ldapTemplate.authenticate("", filter.toString(), password);
    //    LOG.info("# ldap authenticate resp={}", resp);
    //    return resp;
    //}


}
