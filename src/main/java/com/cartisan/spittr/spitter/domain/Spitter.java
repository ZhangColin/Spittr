package com.cartisan.spittr.spitter.domain;

import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/10/10.
 */
@Getter
@Entity
@Table(name = "spitters")
public class Spitter {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
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
