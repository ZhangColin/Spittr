package com.cartisan.spittr.spitter.repository;

import com.cartisan.spittr.spitter.domain.Spitter;

/**
 * Created by Administrator on 2016/10/10.
 */
public interface SpitterRepository {
    Spitter save(Spitter unsaved);

    Spitter findByUserName(String userName);
}
