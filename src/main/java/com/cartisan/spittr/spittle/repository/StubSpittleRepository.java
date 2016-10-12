package com.cartisan.spittr.spittle.repository;

import com.cartisan.spittr.spittle.controller.DuplicateSpittleException;
import com.cartisan.spittr.spittle.domain.Spittle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/10/10.
 */
@Component
public class StubSpittleRepository implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {

            spittles.add(new Spittle(null, "Spittle " + i, new Date(), (double)i, (double)i));
        }

        return spittles;
    }

    @Override
    public Spittle findOne(Long spittleId) {
        if (spittleId==1)
        return new Spittle("Hello", new Date());
        return null;
    }

    @Override
    public void save(Spittle spittle) {
        throw new DuplicateSpittleException();
    }
}
