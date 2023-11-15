package com.br.microsservices.userapi.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;
}
