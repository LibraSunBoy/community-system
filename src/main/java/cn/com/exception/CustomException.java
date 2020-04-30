package cn.com.exception;

/**
 * <pre>
 * Filename      :  CustomException
 * Package       :  cn.com.exception
 * Company       :  上海想星商务服务有限公司
 * Create Date   :  2019年12月2019/12/17日
 * </pre>
 *
 * @author : yangdong.jia
 */
public class CustomException extends RuntimeException{

    private Integer code;

    private String msg;

    public CustomException() {
    }

    public CustomException(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }

    public int getCode() {
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

    public enum CodeEnum {

        OK(200,"OK"),
        SYSTEM_ERROR(500, "系统异常"),
        ACCOUNT_ERROR(1000,"账户错误"),
        PWD_ERROR(1001,"密码错误");

        private Integer code;

        private String msg;

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

        private CodeEnum(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }
}
