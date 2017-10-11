package yingdg.exercise.springwebapp.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by yingdg on 2017/5/5.
 */
@RestController
@Scope(WebApplicationContext.SCOPE_SESSION)
@RequestMapping(value = "/user")
// 开启文件上传类
@MultipartConfig // 不实现序列化接口，加载redis后出现异常？
public class FileController implements Serializable {
    private static final long serialVersionUID = -1705709678290445745L;

    /*
        上传文件
         */
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public void uploadFile(@RequestPart("userFile") MultipartFile userFile) throws IOException {
        // 上传文件存盘
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
