package yingdg.exercise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import yingdg.exercise.model.User;
import yingdg.exercise.repository.UserMapper;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/4/10.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @Resource
    private UserMapper mapper;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "redirect:home.html";
    }

    /*
    Rest请求
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity findUser(@PathVariable("id") int id) {
        User user = mapper.findUserById(id);
        System.out.println(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
