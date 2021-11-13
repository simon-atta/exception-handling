package com.dis.exception.handler;

import com.dis.exception.handler.model.ApiFieldError;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
@Slf4j
public class GlobalValidationExceptionHandler {
    private static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS");

    private MessageSource messageSource;

    public GlobalValidationExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ApiFieldError> handleConstraintViolationException(
            ConstraintViolationException exception) {

        return exception.getConstraintViolations().stream()
                .map(fieldError ->
                        new ApiFieldError(
                                fieldError.getMessage(),
                                fieldError.getPropertyPath().toString(),
                                fieldError.getInvalidValue())
                ).collect(Collectors.toList());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ApiFieldError> handleNotFoundExceptionException(
            MethodArgumentNotValidException exception) {

        BindingResult bindingResult = exception.getBindingResult();

        return bindingResult.getFieldErrors().stream()
                .map(fieldError ->
                        new ApiFieldError(
                                fieldError.getField(),
                                fieldError.getCode(),
                                fieldError.getRejectedValue(),
                                getTranslatedMessage(fieldError.getDefaultMessage()))
                ).collect(Collectors.toList());
    }

    private String getTranslatedMessage(String message) {
        if (!Strings.isEmpty(message))
            return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());

        return "";
    }


}
