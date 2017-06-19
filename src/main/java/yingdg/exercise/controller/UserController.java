package yingdg.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
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

    /*
    上传文件
     */
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public void uploadFile(@RequestPart("userFile") MultipartFile userFile) throws IOException {
        // 上传文件布盘
        userFile.transferTo(new File("E:/uploads/" + new String(userFile.getOriginalFilename())));

        // 打印上传源文件名称，包括后缀名
        System.out.println(userFile.getOriginalFilename());
    }

    /*
    下载文件
     */
    @RequestMapping(value = "/getFile/{filename}")
    public ResponseEntity<byte[]> getFile(@PathVariable String filename) throws IOException {
        // url中'.'会作为分隔符处理，故用'_'临时代替，后端再切换回来
        File file = new File("E:/uploads/" + filename.replace("_", "."));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", filename.replace("_", "."));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.CREATED);
    }

}
