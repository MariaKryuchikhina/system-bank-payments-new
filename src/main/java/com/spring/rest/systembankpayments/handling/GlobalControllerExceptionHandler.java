package com.spring.rest.systembankpayments.handling;

import com.spring.rest.systembankpayments.exceptions.ClientNotFoundException;
import com.spring.rest.systembankpayments.exceptions.InfoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ClientNotFoundException.class)
    public ResponseEntity<Object> clientNotFoundException (ClientNotFoundException clientNotFoundException){
        log.info("Throw ClientNotFoundException");
        return new ResponseEntity<>(clientNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(value = ClientNotFoundException.class)
//    public ResponseEntity<Object> handleNotFound (RuntimeException ex, WebRequest request){
//        log.info("Throw ClientNotFoundException");
//        String bodyOfResponse = "Клиент не найден!";
//        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
//    }

    @ExceptionHandler(value = InfoException.class)
    public ModelAndView handleError(HttpServletRequest req, Exception e) throws Exception{
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) throw e;

        log.error("Request: " + req.getRequestURI() + " raised " + e);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("uri", req.getRequestURL());
        mav.addObject("status", 500);

        return mav;
    }
}
