package com.cartisan.spittr.spitter.controller;

import com.cartisan.spittr.Message;
import com.cartisan.spittr.spitter.domain.Spitter;
import com.cartisan.spittr.spitter.repository.SpitterRepository;
import com.cartisan.spittr.spitter.view.SpitterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

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
    public String showRegistrationForm() {
        return "spitters/register";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(@Valid SpitterForm spitterForm,
                                      Errors errors, Model model,
                                      RedirectAttributes redirectAttributes) throws IOException {
        if (errors.hasErrors()) {
            model.addAttribute("customerErrors", errors.getFieldErrors().stream().map(fieldError -> {
                Message message = new Message();
                message.setName(fieldError.getField());
                message.setValue(fieldError.getDefaultMessage());
                return message;
            }).collect(Collectors.toList()));
            return "spitters/register";
        }
        Spitter spitter = spitterForm.toSpitter();
        spitterRepository.save(spitter);
        /*MultipartFile profilePicture = spitterForm.getProfilePicture();
        if (profilePicture!=null)
            profilePicture.transferTo(new File("/tmp/spittr/"+spitter.getUserName()+".jpg"));*/

        redirectAttributes.addFlashAttribute("spitter", spitter);
        redirectAttributes.addAttribute("userName", spitter.getUserName());
        return "redirect:/spitters/{userName}" ;
    }

    @RequestMapping(value = "/{userName}", method = GET)
    public String showSpitterProfile(@PathVariable String userName, Model model) {
        if(!model.containsAttribute("spitter")) {
            Spitter spitter = spitterRepository.findByUserName(userName);
            model.addAttribute(spitter);
        }
        return "spitters/profile";
    }
}
