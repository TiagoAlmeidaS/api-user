package com.example.apiuser.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
public class UserDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "E-mail is required")
    private String email;

    @NotBlank(message = "CPF/CNPJ is required")
    @CPF(message = "CPF valid is required")
    private String cpfOrCnpj;

    @NotBlank(message = "Number is required")
    private String tel;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank(message = "Password is required")
    private String pass;

    public UserDTO(String name, String email, String cpfOrCnpj, String tel, String pass) {
        this.name = name;
        this.email = email;
        this.cpfOrCnpj = cpfOrCnpj;
        this.tel = tel;
        this.pass = pass;
    }
}
