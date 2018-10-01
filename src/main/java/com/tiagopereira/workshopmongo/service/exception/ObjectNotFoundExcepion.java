package com.tiagopereira.workshopmongo.service.exception;

public class ObjectNotFoundExcepion extends  RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundExcepion(String msg){
        super(msg);
    }
}
