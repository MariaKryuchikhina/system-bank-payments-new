package com.spring.rest.systembankpayments.handling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = ClientNotFoundException.class)
    public ResponseEntity<String> clientNotFoundException (ClientNotFoundException clientNotFoundException){
        return new ResponseEntity<>("Клиент с таким id не существует!", HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(value = ClientNotFoundException.class)
//    public ModelAndView handleError(HttpServletRequest req, Exception e) throws Exception{
//        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) throw e;
//
//        log.error("Request: " + req.getRequestURI() + " raised " + e);
//
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("uri", req.getRequestURL());
//        mav.addObject("status", 500);
//
//        mav.setViewName("support");
//        return mav;
//    }
}
