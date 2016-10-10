package com.cartisan.spittr.spittle.repository;

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
            spittles.add(new Spittle("Spittle "+i, new Date()));
        }

        return spittles;
    }
}
