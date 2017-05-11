package yingdg.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import yingdg.exercise.repository.UserMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by yingdg on 2017/5/5.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public void uploadFile(@RequestPart("userFile") MultipartFile userFile) throws IOException {
        userFile.transferTo(new File("E:/uploads/" + userFile.getName()));
        System.out.println(userFile.getName());
    }

}
