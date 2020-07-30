package cn.tedu.straw.portal.service.ex;

/**
 * 上传的文件为空，例如：没有选择文件，或选择的文件是0字节的
 */
public class FileEmptyException extends FileUploadException {

    public FileEmptyException() {
    }

    public FileEmptyException(String message) {
        super(message);
    }

    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    public FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
