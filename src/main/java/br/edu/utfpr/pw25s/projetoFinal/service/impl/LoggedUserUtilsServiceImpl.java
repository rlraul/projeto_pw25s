package br.edu.utfpr.pw25s.projetoFinal.service.impl;

import br.edu.utfpr.pw25s.projetoFinal.model.User;
import br.edu.utfpr.pw25s.projetoFinal.repository.UserRepository;
import br.edu.utfpr.pw25s.projetoFinal.service.LoggedUserUtilsService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoggedUserUtilsServiceImpl implements LoggedUserUtilsService {

    private static UserRepository userRepository;

    public LoggedUserUtilsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User retornaObjetoDoUsuarioLogado() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findUserByUsername(username);
        return user;
    }
}
