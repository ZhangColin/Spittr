package com.cartisan.spittr.spitter.repository;

import com.cartisan.spittr.spitter.domain.Spitter;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/10/10.
 */
@Repository
public interface SpitterRepository extends org.springframework.data.repository.Repository<Spitter, Long>{
    Spitter save(Spitter unsaved);

    Spitter findByUserName(String userName);
}
