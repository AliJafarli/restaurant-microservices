package com.webdev.menus.service.impl;

import com.webdev.menus.repository.MenuRepository;
import com.webdev.menus.service.IMenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.webdev.menus.entity.Menu;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class MenuServiceImpl implements IMenuService {

    private final MenuRepository menuRepository;

    @Override
    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
