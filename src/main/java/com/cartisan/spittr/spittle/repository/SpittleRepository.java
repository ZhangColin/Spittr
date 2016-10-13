package com.cartisan.spittr.spittle.repository;

import com.cartisan.spittr.spittle.domain.Spittle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/10/9.
 */
@Repository
public interface SpittleRepository extends org.springframework.data.repository.Repository<Spittle, Long> {
    Page<Spittle> findAll(Pageable pageable);

    Spittle findOne(Long spittleId);

    void save(Spittle spittle);
}
