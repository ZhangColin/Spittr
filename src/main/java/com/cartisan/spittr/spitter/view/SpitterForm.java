package com.cartisan.spittr.spitter.view;

import com.cartisan.spittr.spitter.domain.Spitter;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2016/10/12.
 */
@Data
public class SpitterForm {
    @NotNull
    @Size(min = 5, max = 16, message = "{username.size}")
    private String userName;
    @NotNull
    @Size(min = 5, max = 25, message = "{password.size}")
    private String password;
    @NotNull
    @Size(min = 2, max = 30, message = "{firstName.size}")
    private String firstName;
    @NotNull
    @Size(min = 2, max = 30, message = "{lastName.size}")
    private String lastName;
    @NotNull
    @Email
    private String email;

    private MultipartFile profilePicture;


    public Spitter toSpitter() {
        return new Spitter(userName,password,firstName, lastName,email);
    }
}
