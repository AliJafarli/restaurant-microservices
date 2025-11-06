package com.webdev.menus.service;

import com.webdev.menus.entity.Menu;

import java.util.List;


public interface IMenuService {

    Menu saveMenu(Menu menu);

    List<Menu> getAllMenus();
}
