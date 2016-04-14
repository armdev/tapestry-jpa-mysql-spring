package com.tapestry.pages;

import com.tapestry.dao.services.UserService;
import com.tapestry.dao.user.UserDAO;
import java.util.Date;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;

//http://jumpstart.doublenegative.com.au/jumpstart/
public class Index {

    @Inject
    @Autowired
    private UserService userService;

    public Long getCount(){        
        return userService.getCount();
    }
    
    
    
    public String getUsername() {
        return "Simple User !!!";
    }

    public Date getCurrentTime() {
        return new Date();
    }
}
