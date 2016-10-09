package com.cartisan.spittr.spittle.repository;

import com.cartisan.spittr.spittle.domain.Spittle;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */
@Repository
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
