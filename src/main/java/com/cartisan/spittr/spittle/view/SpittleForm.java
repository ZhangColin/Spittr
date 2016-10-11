package com.cartisan.spittr.spittle.view;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2016/10/11.
 */
@Data
public class SpittleForm {
    @NotNull
    @Size(min = 1, max = 140)
    private String message;

    @Min(-180)
    @Max(180)
    private Double longitude;

    @Min(-90)
    @Max(90)
    private Double latitude;
}
