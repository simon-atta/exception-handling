package com.dis.exception.handler;

import com.dis.exception.handler.model.ApiError;
import com.dis.exception.handler.excpetion.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@Slf4j
public class GlobalBusinessExceptionHandler {
    private static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS");

    private final MessageSource messageSource;

    public GlobalBusinessExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(value = ConflictException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError conflictErrorHandler(ConflictException e) {
        return businessErrorHandler(e, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = ForbiddenException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiError forbiddenErrorHandler(ForbiddenException e) {
        return businessErrorHandler(e, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = PasswordMisMatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiError passwordMisMatchExceptionHandler(PasswordMisMatchException e) {
        return businessErrorHandler(e, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError forbiddenErrorHandler(NotFoundException e) {
        return businessErrorHandler(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiError unauthorizedErrorHandler(UnauthorizedException e) {
        return businessErrorHandler(e, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError businessErrorHandler(BusinessException businessException,
                                         HttpStatus httpStatus) {
        ApiError errorInfo = new ApiError(
                httpStatus.getReasonPhrase(),
                DATE_FORMAT.format(System.currentTimeMillis()),
                getTranslatedMessage(businessException.getCode())
        );

        log.warn("business exception:errorInfo={}", errorInfo, businessException);
        return errorInfo;
    }


    private String getTranslatedMessage(String message) {
        if (!Strings.isEmpty(message))
            return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());

        return "";
    }


}
