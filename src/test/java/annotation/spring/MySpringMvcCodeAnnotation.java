package com.travel.sky.parselog.test;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

public class MySpringMvcCodeAnnotation {

//    @ExceptionHandler//可以对web的服务器端运行错误， 做统一的处理
//		使得http status code 从原本的500改成200， 
//		并去执行用@ExceptionHandler注解的方法。  前提是实现了这个方法的Class被 那个访问的Controller 继承了
//    @ApplicationScope//
//
//    @ControllerAdvice//YXIE
//    @CookieValue//yixie
//    @CrossOrigin//yixie
//    @DeleteMapping
//    @ExceptionHandler
//    @GetMapping
//    @InitBinder//yixie
//    @Mapping
//    @MatrixVariable
//    @ModelAttribute//yixie
//    @PatchMapping
//    @PathVariable
//    @PostMapping
//    @PutMapping
//    @RequestAttribute
//    @RequestBody
//    @RequestHeader
//    @RequestMapping
//    @RequestParam
//    @RequestPart
//    @RequestScope//yixie
//    @ResponseBody//yixie
//    @ResponseStatus//YIXIE
//    @RestController
//    @RestControllerAdvice
//    @SessionAttribute
//    @SessionScope//yixie

    private String annotation;

    private String getAnnotation() {
        return null;
    }

}
