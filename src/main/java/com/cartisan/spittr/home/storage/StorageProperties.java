package com.cartisan.spittr.home.storage;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Administrator on 2016/10/12.
 */
@ConfigurationProperties("storage")
@Data
public class StorageProperties {
    private String location="upload-dir";
}
