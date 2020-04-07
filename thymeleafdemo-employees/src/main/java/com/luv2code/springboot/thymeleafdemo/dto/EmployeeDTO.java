package com.luv2code.springboot.thymeleafdemo.dto;

import lombok.*;
import org.hibernate.validator.constraints.Email;

//import org.hibernate.validator.constraints.Email;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {

    private int id;


    private String firstName;


    private String lastName;
    //regexp attribute that is "an additional regular expression the annotated element must match"
    @Email(regexp = ".+@.+\\..+",message="Please provide a valid email address")

    private String email;








}











