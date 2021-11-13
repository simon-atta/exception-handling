package com.dis.exception.handler;

import com.dis.exception.handler.model.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
@Slf4j
public class GlobalTechnicalExceptionHandler {
    private static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS");

    private MessageSource messageSource;

    public GlobalTechnicalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ApiError mvcExceptionHandler(HttpServletRequest req, HttpRequestMethodNotSupportedException e) {
        return mvcErrorInfo(req, e.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public ApiError mvcExceptionHandler(HttpServletRequest req, HttpMediaTypeNotSupportedException e) {
        return mvcErrorInfo(req, e.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public ApiError mvcExceptionHandler(HttpServletRequest req, HttpMediaTypeNotAcceptableException e) {
        return mvcErrorInfo(req, e.getMessage());
    }

    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError mvcExceptionHandler(HttpServletRequest req, MissingPathVariableException e) {
        return mvcErrorInfo(req, e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError mvcExceptionHandler(HttpServletRequest req, MissingServletRequestParameterException e) {
        return mvcErrorInfo(req, e.getMessage());
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError mvcExceptionHandler(HttpServletRequest req, MissingRequestHeaderException e) {
        return mvcErrorInfo(req, e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError mvcExceptionHandler(HttpServletRequest req, NoHandlerFoundException e) {
        return mvcErrorInfo(req, e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleNullPointerException(HttpServletRequest req, NullPointerException e) {
        return mvcErrorInfo(req, e.getMessage());
    }

    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleClassCastException(HttpServletRequest req, ClassCastException e) {
        return mvcErrorInfo(req, e.getMessage());
    }


    private ApiError mvcErrorInfo(HttpServletRequest req, String detail) {
        return new ApiError(
                "",
                "",
                detail,
                req.getRequestURL().toString(),
                DATE_FORMAT.format(System.currentTimeMillis())
        );
    }
}
