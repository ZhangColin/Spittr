package com.cartisan.spittr.spittle.controller;

import com.cartisan.spittr.spittle.domain.Spittle;
import com.cartisan.spittr.spittle.repository.SpittleRepository;
import com.cartisan.spittr.spittle.view.SpittleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {

        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = GET)
    public String spittles(Model model,
                           @RequestParam(value = "pageSize", defaultValue = "0")int pageSize,
                           @RequestParam(value = "count", defaultValue = "20") int count){

        model.addAttribute(spittleRepository.findAll(new PageRequest(pageSize, count)).getContent());
        return "spittles/spittles";
    }

    @RequestMapping(value="/{spittleId}", method =  GET)
    public String showSpittle(@PathVariable Long spittleId, Model model) {
        Spittle spittle = spittleRepository.findOne(spittleId);
        if (spittle==null)
            throw new SpittleNotFoundException();
        model.addAttribute(spittle);
        return "spittles/spittle";
    }

    @RequestMapping(method = POST)
    public String saveSpittle(SpittleForm form){
        spittleRepository.save(new Spittle(null, form.getMessage(),new Date(),
                form.getLongitude(), form.getLatitude()));
        return "redirect:/spittles";
    }

    /*@ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateSpittle(){
        return "error/duplicate";
    }*/
}
