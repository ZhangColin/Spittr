package com.cartisan.spittr.spitter.domain;

import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Administrator on 2016/10/10.
 */
@Getter
public class Spitter {
    private Long id;

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    private Spitter(){}

    public Spitter(String userName, String password, String firstName, String lastName, String email) {
        this(null, userName, password, firstName, lastName, email);
    }

    public Spitter(Long id, String userName, String password, String firstName, String lastName, String email){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, "firstName", "lastName", "userName", "password", "email");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "firstName", "lastName", "userName", "password", "email");
    }
}
