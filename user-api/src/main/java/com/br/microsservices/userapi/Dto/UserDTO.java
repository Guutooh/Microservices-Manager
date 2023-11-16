package com.br.microsservices.userapi.Dto;

import com.br.microsservices.userapi.Model.User;
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

    public static UserDTO convert(User user) {

        UserDTO userDTO = new UserDTO();

        userDTO.setNome(user.getNome());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setCpf(user.getCpf());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setDataCadastro(user.getDataCadastro());
        return userDTO;
    }

}

