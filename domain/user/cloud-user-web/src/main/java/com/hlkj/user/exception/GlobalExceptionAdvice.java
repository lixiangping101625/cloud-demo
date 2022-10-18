package com.hlkj.user.exception;

import com.hlkj.pojo.UnifyResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Xiang-ping li
 * @descition 用这个类接收从代码里抛出的异常，组织成UnifyResponse统一响应
 * @date 2020/5/15 0015  10:31
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    //处理未知异常:模糊的非具体的返回前端，应以日志记录或打印到控制台
    @ExceptionHandler(value = Exception.class)
    @ResponseBody//由于要响应给前端，所以需要该注解
    public UnifyResponse handException(HttpServletRequest request, Exception e){
        StringBuffer url = request.getRequestURL();
        //模糊返回信息给前端。线上——记录日志，开发——控制台输出
        System.out.println(url);
        System.out.println(e);
        return new UnifyResponse(100500, "服务器内部异常", url.toString());
    }
}