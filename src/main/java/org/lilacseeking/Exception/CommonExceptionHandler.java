package org.lilacseeking.Exception;

import org.lilacseeking.Eumns.ErrorCodeEumn;
import org.lilacseeking.Utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


/**
 * @Auther: lilacseeking
 * @Date: 2018/11/5 23:31
 * @Description: 统一异常处理
 */
@ControllerAdvice(annotations = {Controller.class,RestController.class})
public class CommonExceptionHandler {
    // 日志组件
    public static Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @Resource
    ResponseUtil responseUtil;

    @ExceptionHandler(BusinessException.class)
    public void handlerBusinessException(Exception e , HttpServletResponse httpServletResponse){
        ErrorCodeEumn errorCodeEumn = ErrorCodeEumn.getErrorCodeEumn(e.getMessage());
        if (errorCodeEumn == null) {
            errorCodeEumn = ErrorCodeEumn.UNKNOWN_ERROR;
        }
        responseUtil.putError(errorCodeEumn.getCode(),errorCodeEumn.name(),errorCodeEumn.getName());
        responseUtil.writeMessage(httpServletResponse);
    }
}
