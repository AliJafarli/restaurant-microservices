package com.webdev.menus.service.impl;

import com.webdev.menus.repository.MenuRepository;
import com.webdev.menus.service.IMenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.webdev.menus.entity.Menu;



@Service
@AllArgsConstructor
public class MenuServiceImpl implements IMenuService {

    private final MenuRepository menuRepository;

    @Override
    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }
}
