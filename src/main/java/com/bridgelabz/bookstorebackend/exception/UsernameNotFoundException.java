package com.bridgelabz.bookstorebackend.exception;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String email) {
        super(email + " not found");
    }
}
