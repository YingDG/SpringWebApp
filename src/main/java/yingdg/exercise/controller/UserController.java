package yingdg.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import yingdg.exercise.repository.UserMapper;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;

/**
 * Created by yingdg on 2017/5/5.
 */
@RestController
@Scope(WebApplicationContext.SCOPE_SESSION)
@RequestMapping(value = "/user")
@MultipartConfig
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public void uploadFile(@RequestPart("userFile") MultipartFile userFile) throws IOException {
        int index = userFile.getOriginalFilename().indexOf(".");
        // 上传文件布盘
        userFile.transferTo(new File(
                "E:/uploads/" + userFile.getName() + userFile.getOriginalFilename().substring(index)));
        System.out.println(userFile.getName());
    }

}
