package org.ranjan.user.exception;

public class ResourceNotFountException extends RuntimeException{

    public ResourceNotFountException(){
        super("User not found for this Id");
    }

    public ResourceNotFountException(Long id){

        super("User not found for this id: "+id);
    }
}
