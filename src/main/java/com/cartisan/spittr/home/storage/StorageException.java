package com.cartisan.spittr.home.storage;

/**
 * Created by Administrator on 2016/10/12.
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
