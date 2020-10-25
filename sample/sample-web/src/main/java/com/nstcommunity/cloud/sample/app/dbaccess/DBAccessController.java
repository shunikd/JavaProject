package com.nstcommunity.cloud.sample.app.dbaccess;


import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nstcommunity.cloud.sample.domain.service.UserInforService;


@Controller
@RequestMapping("dbaccess")
public class DBAccessController {

    private static final Logger logger = LoggerFactory
            .getLogger(DBAccessController.class);

    @Inject
    UserInforService userInfoService;
    
    @ModelAttribute
    public DBAccessForm setUpForm() {
    	DBAccessForm form = new DBAccessForm();
        return form;
    }
    
    @GetMapping("/")
    public String dbaccess(Model model) {
        logger.info("dbaccess started");

        String userId = "000001";
        
        
        
        String userName = userInfoService.getUserInfo(userId);
        
        logger.info("---------------------------------");
        logger.info(userName);
        logger.info("---------------------------------");
        
        model.addAttribute("userName", userName);


        return "dbaccess/home";
    }

    
    
}
