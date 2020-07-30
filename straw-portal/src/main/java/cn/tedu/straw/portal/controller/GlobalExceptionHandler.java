package cn.tedu.straw.portal.controller;

import cn.tedu.straw.portal.service.ex.*;
import cn.tedu.straw.portal.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public R handleException(Throwable e) {
        if (e instanceof ParameterValidationException) {
            return R.failure(R.State.ERR_PARAMETER_INVALIDATION, e);
        } else if (e instanceof InviteCodeException){
            return R.failure(R.State.ERR_INVITE_CODE, e);
        } else if (e instanceof ClassDisabledException) {
            return R.failure(R.State.ERR_CLASS_DISABLED, e);
        } else if (e instanceof PhoneDuplicateException) {
            return R.failure(R.State.ERR_PHONE_DUPLICATE, e);
        } else if (e instanceof InsertException) {
            return R.failure(R.State.ERR_INSERT, e);
        } else if (e instanceof FileEmptyException) {
            return R.failure(R.State.ERR_UPLOAD_EMPTY, e);
        } else if (e instanceof FileSizeException) {
            return R.failure(R.State.ERR_UPLOAD_FILE_SIZE, e);
        } else if (e instanceof FileTypeException) {
            return R.failure(R.State.ERR_UPLOAD_FILE_TYPE, e);
        } else if (e instanceof FileIOException) {
            return R.failure(R.State.ERR_UPLOAD_FILE_IO, e);
        } else if (e instanceof QuestionNotFoundException) {
            return R.failure(R.State.ERR_QUESTION_NOT_FOUND, e);
        } else if (e instanceof AccessDeniedException) {
            return R.failure(R.State.ERR_ACCESS_DENIED, e);
        } else {
            log.debug("Unknown Exception", e);
            return R.failure(R.State.ERR_UNKNOWN, e);
        }
    }

}
