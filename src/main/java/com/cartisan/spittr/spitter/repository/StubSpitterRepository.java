package com.cartisan.spittr.spitter.repository;

import com.cartisan.spittr.spitter.domain.Spitter;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/10/11.
 */
@Component
public class StubSpitterRepository implements SpitterRepository {
    @Override
    public Spitter save(Spitter unsaved) {
        return null;
    }

    @Override
    public Spitter findByUserName(String userName) {
        return null;
    }
}
