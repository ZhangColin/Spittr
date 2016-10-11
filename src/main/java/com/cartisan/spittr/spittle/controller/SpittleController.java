package com.cartisan.spittr.spittle.controller;

import com.cartisan.spittr.spittle.domain.Spittle;
import com.cartisan.spittr.spittle.repository.SpittleRepository;
import com.cartisan.spittr.spittle.view.SpittleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Administrator on 2016/10/9.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {

        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = GET)
    public String spittles(Model model,
                           @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING)Long max,
                           @RequestParam(value = "count", defaultValue = "20") int count){
        model.addAttribute(spittleRepository.findSpittles(max, count));
        return "spittles/spittles";
    }

    @RequestMapping(value="/{spittleId}", method =  GET)
    public String showSpittle(@PathVariable Long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittles/spittle";
    }

    @RequestMapping(method = POST)
    public String saveSpittle(SpittleForm form){
        spittleRepository.save(new Spittle(null, form.getMessage(),new Date(), form.getLongitude(), form.getLatitude()));
        return "redirect:/spittles";
    }
}
