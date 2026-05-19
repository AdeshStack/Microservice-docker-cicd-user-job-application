package com.smarthireai.smarthireai.GlobalException;
// custom exception
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }
}
//@ExceptionHandler(UserNotFoundException.class)
//public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
//    return ResponseEntity.status(404).body(ex.getMessage());
//}