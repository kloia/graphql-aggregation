package com.kloia.classroom.exception;

public class ClassroomNotFoundException extends Exception{

    private static final long serialVersionUID = -596275753027976718L;

    public ClassroomNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
