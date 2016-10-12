package com.cartisan.spittr.home.storage;

/**
 * Created by Administrator on 2016/10/12.
 */
public class StorageFileNotFoundException extends StorageException {
    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
