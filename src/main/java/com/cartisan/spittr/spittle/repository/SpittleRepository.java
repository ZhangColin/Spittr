package com.cartisan.spittr.spittle.repository;

import com.cartisan.spittr.spittle.domain.Spittle;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(Long spittleId);
}
