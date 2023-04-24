package br.edu.utfpr.pw25s.projetoFinal.controller;

import br.edu.utfpr.pw25s.projetoFinal.dto.user.UserDTO;
import br.edu.utfpr.pw25s.projetoFinal.model.User;
import br.edu.utfpr.pw25s.projetoFinal.service.UserService;
import br.edu.utfpr.pw25s.projetoFinal.shared.GenericResponse;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService,
                          ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public GenericResponse createUser(@Valid @RequestBody UserDTO user) {
        User userEntity = modelMapper.map(user, User.class);
        userService.save(userEntity);

        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setMessage("User saved.");
        return genericResponse;
    }

}
