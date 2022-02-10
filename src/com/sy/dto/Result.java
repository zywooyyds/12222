package com.sy.dto;

/**
 * 使用这个Result对象作为Service层方法的统一返回值
 * 这个Result对象中包括：
 * 1、当前Service层方法是否执行成功
 * 2、如果出现错误，错误信息是什么
 * 3、如果是某些操作，例如查询操作，可能需要附带一些额外的数据
 */
public class Result<T> {
    /**表示当前操作是否成功**/
    private boolean success = true;

    /**错误信息(当success为false的时候才有)**/
    private String errMsg;

    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", errMsg='" + errMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
