package com.cartisan.spittr.spittle.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 2016/10/12.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Spittle not found")
public class SpittleNotFoundException extends RuntimeException {
}
