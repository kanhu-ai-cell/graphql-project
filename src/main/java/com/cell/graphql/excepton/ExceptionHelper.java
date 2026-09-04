package com.cell.graphql.excepton;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionHelper extends RuntimeException {

    public ExceptionHelper(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}