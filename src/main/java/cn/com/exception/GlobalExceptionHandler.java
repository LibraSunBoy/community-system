package cn.com.exception;

import cn.com.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * Filename      :  ExceptionHandler
 * Package       :  cn.com.exception
 * Company       :  上海想星商务服务有限公司
 * Create Date   :  2019年12月2019/12/17日
 * </pre>
 *
 * @author : yangdong.jia
 */
@RestControllerAdvice
public class GlobalExceptionHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = CustomException.class)
    public Result<String> errorHandler(CustomException e){
        LOGGER.info("enter GlobalExceptionHandler.errorHandler...CustomException:{}",e);
        Result result = new Result(e.getCode(), e.getMsg(), null);
        return result;
    }

}
