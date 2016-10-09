package com.cartisan.spittr.home.controller;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Administrator on 2016/10/9.
 */
public class HomeControllerTest {
    @Test
    public void index() throws Exception {
        HomeController controller = new HomeController();
        assertThat(controller.index()).isEqualTo("home");
    }

}