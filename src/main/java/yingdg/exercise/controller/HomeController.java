package yingdg.exercise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import yingdg.exercise.model.User;
import yingdg.exercise.repository.UserMapper;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by yingdg on 2017/4/10.
 */
@Controller
@RequestMapping({"/"})
public class HomeController {
    @Resource
    private UserMapper mapper;

    @RequestMapping
    public String index() {
        return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "home.html";
    }

    /*
    Rest请求与响应
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> findUser(@PathVariable("id") int id) {
        User user = mapper.findUserById(id);
        System.out.println(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /*
   Rest请求与响应
    */
    @RequestMapping(value = "/user/new", method = RequestMethod.PUT)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@Valid User user, Errors errors) {
        if (!errors.hasErrors()) {
            System.out.println(user);
        } else {
            System.out.println(errors.getAllErrors());
        }

        return user;
    }

}
