package cn.com.utils;


import cn.com.exception.CustomException;
import io.swagger.models.auth.In;

import java.io.Serializable;

/**
 * <pre>
 * Filename      :  Result
 * Package       :  cn.com.utils
 * Company       :  上海想星商务服务有限公司
 * Create Date   :  2019年12月2019/12/17日
 * </pre>
 *
 * @author : yangdong.jia
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -3948389268046368059L;

    private Integer code;

    private String msg;

    private Integer count;

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

    public Result() {
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(CustomException.CodeEnum code, T data) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

    public Result(Integer count,T data) {
        this.code = 0;
        this.msg = "";
        this.count=count;
        this.data = data;
    }

    public Result success(T data) {
        this.code = CustomException.CodeEnum.OK.getCode();
        this.msg =  CustomException.CodeEnum.OK.getMsg();
        this.data = data;
        return this;
    }

    public Result success() {
        this.code = CustomException.CodeEnum.OK.getCode();
        this.msg =  CustomException.CodeEnum.OK.getMsg();
        return this;
    }
}
