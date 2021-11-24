package ru.zhendozzz.autoprofi.autoprofi.exceptions;

public class EntityNotFoundException extends NullPointerException{

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String s) {
        super(s);
    }
}
