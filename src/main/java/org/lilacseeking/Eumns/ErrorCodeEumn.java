package org.lilacseeking.Eumns;

/**
 * @Auther: lilacseeking
 * @Date: 2018/10/21 00:44
 * @Description:
 */
public enum  ErrorCodeEumn {

    //参数错误
    MOBILE_NOT_NULL("1001","手机号不能为空"),
    PASSWORD_NOT_CORRECT("1002","密码输入错误");


    private String code;
    private String name;

    ErrorCodeEumn (String code,String name){
        this.code = code;
        this.name = name;
    }


    public static String getErrorCodeEumnCode(String code) {
        if (code == null) {
            return null;
        }
        ErrorCodeEumn[] typeEnums = ErrorCodeEumn.values();
        for (ErrorCodeEumn typeEnum : typeEnums) {
            if (typeEnum.code.equals(code)) {
                return typeEnum.name;
            }
        }
        return null;
    }

    public static ErrorCodeEumn getErrorCodeEumn(String codeName) {
        if (codeName == null) {
            return null;
        }
        ErrorCodeEumn[] typeEnums = ErrorCodeEumn.values();
        for (ErrorCodeEumn typeEnum : typeEnums) {
            if (typeEnum.name.equals(codeName)) {
                return typeEnum;
            }
        }
        return null;
    }

    public static String getErrorCodeEumnName(String codeName) {
        if (codeName == null) {
            return null;
        }
        ErrorCodeEumn[] typeEnums = ErrorCodeEumn.values();
        for (ErrorCodeEumn typeEnum : typeEnums) {
            if (typeEnum.name.equals(codeName)) {
                return typeEnum.name;
            }
        }
        return null;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
