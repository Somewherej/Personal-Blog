package com.somewhere.blog.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

//拦截所有异常 并进行处理
public class ControllerExceptionHandler {

    //获取日志
    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    //这个方法是可以进行异常处理的
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e){
         logger.error("Requst URL : {}, Exception: {}",request.getRequestURL(),e);

         ModelAndView mv = new ModelAndView();
         mv.addObject("url",request.getRequestURL());
         mv.addObject("exception",e);
         mv.setViewName("error/error.html");  //去哪拿页面
         return null;
    }
}
