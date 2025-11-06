package com.webdev.menus.service;

import com.webdev.menus.entity.Menu;

import java.util.List;
import java.util.Optional;


public interface IMenuService {

    Menu saveMenu(Menu menu);

    List<Menu> getAllMenus();

    Optional<Menu> getMenuById(Long id);

    void updateMenu(Menu menu);

    void deleteMenu(Long id);
}
