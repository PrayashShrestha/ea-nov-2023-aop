package edu.miu.springaop.aop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AopIsAwesomeHeaderException extends RuntimeException {
    public AopIsAwesomeHeaderException(String message) {
        super(message);
    }
}
