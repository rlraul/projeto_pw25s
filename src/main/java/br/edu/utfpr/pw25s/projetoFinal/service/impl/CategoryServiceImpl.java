package br.edu.utfpr.pw25s.projetoFinal.service.impl;

import br.edu.utfpr.pw25s.projetoFinal.model.Category;
import br.edu.utfpr.pw25s.projetoFinal.model.User;
import br.edu.utfpr.pw25s.projetoFinal.repository.CategoryRepository;
import br.edu.utfpr.pw25s.projetoFinal.repository.UserRepository;
import br.edu.utfpr.pw25s.projetoFinal.service.CategoryService;
import br.edu.utfpr.pw25s.projetoFinal.service.LoggedUserUtilsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends CrudServiceImpl<Category, Long> implements CategoryService {

    private static CategoryRepository categoryRepository;

    private static LoggedUserUtilsService loggedUserUtilsService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, LoggedUserUtilsService loggedUserUtilsService) {
        this.categoryRepository = categoryRepository;
        this.loggedUserUtilsService = loggedUserUtilsService;
    }

    @Override
    protected JpaRepository<Category, Long> getRepository() {
        return this.categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findByUserUsername(
            loggedUserUtilsService.retornaObjetoDoUsuarioLogado().getUsername()
        );
    }

    @Override
    public Category save(Category entity) {
        entity.setUser(
            loggedUserUtilsService.retornaObjetoDoUsuarioLogado()
        );
        return super.save(entity);
    }
}
