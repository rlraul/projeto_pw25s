package br.edu.utfpr.pw25s.projetoFinal.service.impl;

import br.edu.utfpr.pw25s.projetoFinal.model.Category;
import br.edu.utfpr.pw25s.projetoFinal.model.User;
import br.edu.utfpr.pw25s.projetoFinal.repository.CategoryRepository;
import br.edu.utfpr.pw25s.projetoFinal.repository.UserRepository;
import br.edu.utfpr.pw25s.projetoFinal.service.CategoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends CrudServiceImpl<Category, Long> implements CategoryService {

    private static CategoryRepository categoryRepository;
    private static UserRepository userRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    protected JpaRepository<Category, Long> getRepository() {
        return this.categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findUserByUsername(username);
        return this.categoryRepository.findByUserUsername(user.getUsername());
    }

    @Override
    public Category save(Category entity) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findUserByUsername(username);
        entity.setUser(user);
        return super.save(entity);
    }
}
