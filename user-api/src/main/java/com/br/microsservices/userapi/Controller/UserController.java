package com.br.microsservices.userapi.Controller;

import com.br.microsservices.userapi.Dto.UserDTO;
import com.br.microsservices.userapi.Service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> ListarUsuarios() {
        return userService.ListarTodos();
    }

    @GetMapping("/{id}")
    public UserDTO PorId(@PathVariable Long id) {
        return userService.procuraPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO criar(@Valid @RequestBody UserDTO userDTO) {

        return userService.salvar(userDTO);
    }

    @GetMapping("/{cpf}/cpf")
    public UserDTO PorCpf(@PathVariable String cpf) {
        return userService.procuraPorCpf(cpf);
    }

    @DeleteMapping("/{id}")
    public UserDTO remover(@PathVariable Long id) {
        return userService.remover(id);
    }

    @GetMapping("/procura")
    public List<UserDTO> queryByName(
            @RequestParam(name = "nome", required = true) String nome) {

        return userService.procuraPorNome(nome);
    }

    @PatchMapping("/{id}")
    public UserDTO Editar(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.Editar(id, userDTO);
    }

    @GetMapping("/pageable")
    public Page<UserDTO> PorPagina(Pageable pageable) {
        return userService.getAllPage(pageable);
    }

    public static List<UserDTO> usuarios = new ArrayList<>();

    @PostConstruct
    public void initiateList() {

        UserDTO dto = new UserDTO();
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Eduardo");
        userDTO.setCpf("123");
        userDTO.setEndereco("Rua a");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelefone("1234-3454");
        userDTO.setDataCadastro(LocalDateTime.now());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Luiz");
        userDTO2.setCpf("456");
        userDTO2.setEndereco("Rua b");
        userDTO2.setEmail("luiz@email.com");
        userDTO2.setTelefone("1234-3454");
        userDTO2.setDataCadastro(LocalDateTime.now());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Bruna");
        userDTO3.setCpf("678");
        userDTO3.setEndereco("Rua c");
        userDTO3.setEmail("bruna@email.com");
        userDTO3.setTelefone("1234-3454");
        userDTO3.setDataCadastro(LocalDateTime.now());

        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);

    }
}
