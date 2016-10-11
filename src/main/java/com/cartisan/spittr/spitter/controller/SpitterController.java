package com.cartisan.spittr.spitter.controller;

import com.cartisan.spittr.spitter.domain.Spitter;
import com.cartisan.spittr.spitter.repository.SpitterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Administrator on 2016/10/10.
 */
@Controller
@RequestMapping(value = "/spitters")
public class SpitterController {
    private SpitterRepository spitterRepository;

    public SpitterController(SpitterRepository spitterRepository) {

        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(){
        return "spitters/register";
    }

    @RequestMapping(value="/register", method = POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors){
        if (errors.hasErrors())
            return "spitters/register";

        spitterRepository.save(spitter);

        return "redirect:/spitters/"+spitter.getUserName();
    }

    @RequestMapping(value = "/{userName}", method = GET)
    public String showSpitterProfile(@PathVariable String userName, Model model){
        Spitter spitter = spitterRepository.findByUserName(userName);
        model.addAttribute(spitter);
        return "spitters/profile";
    }
}
