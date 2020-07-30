package cn.tedu.straw.portal.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class R<T> {

    private Integer state;
    private String message;
    private T data;

    public static R ok() {
        return new R().setState(State.OK);
    }

    public static <T> R ok(T data) {
        return new R<T>().setState(State.OK).setData(data);
    }

    public static R failure(Integer state, String message) {
        return new R().setState(state).setMessage(message);
    }

    public static R failure(Integer state, Throwable e) {
        return failure(state, e.getMessage());
    }

    public static interface State {
        int OK = 2000;
        int ERR_PARAMETER_INVALIDATION = 4000;
        int ERR_INVITE_CODE = 4001;
        int ERR_CLASS_DISABLED = 4002;
        int ERR_PHONE_DUPLICATE = 4003;
        int ERR_INSERT = 4004;
        int ERR_UPLOAD_EMPTY = 4005;
        int ERR_UPLOAD_FILE_SIZE = 4006;
        int ERR_UPLOAD_FILE_TYPE = 4007;
        int ERR_UPLOAD_FILE_IO = 4008;
        int ERR_QUESTION_NOT_FOUND = 4009;
        int ERR_ACCESS_DENIED = 5000;
        int ERR_UNKNOWN = 9999;
    }

}
