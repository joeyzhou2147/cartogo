package com.springapp.mvc;

/**
 * Created by yuzhou on 2015/6/26.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String welcome(ModelMap model){
        model.addAttribute("message","You are good");
        return "hello";
    }
}
