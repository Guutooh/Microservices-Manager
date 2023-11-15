package com.br.microsservices.userapi.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    private String endereco;

    @NotBlank(message = "E-mail é obrigatório")
    private String email;

    private String telefone;

    private LocalDateTime dataCadastro;
}

