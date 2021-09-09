package com.example.apiuser.entity;

import com.example.apiuser.domain.UserDTO;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Document(value = "user")
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String cpfOrCnpj;
    private String tel;
    private String pass;

    public User(String name, String email, String cpfOrCnpj, String tel, String pass) {
        this.name = name;
        this.email = email;
        this.cpfOrCnpj = cpfOrCnpj;
        this.tel = tel;
        this.pass = pass;
    }

    public static User toUserDTO(UserDTO userDTO) {
        return new User(userDTO.getName(), userDTO.getEmail(), userDTO.getCpfOrCnpj(), userDTO.getTel(), userDTO.getPass());
    }

}
