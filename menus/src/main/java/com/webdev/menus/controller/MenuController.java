package com.webdev.menus.controller;

import com.webdev.menus.constants.MenuConstants;
import com.webdev.menus.service.IMenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.webdev.menus.entity.Menu;


@RestController
@AllArgsConstructor
@RequestMapping("/api/menus")
public class MenuController {

    private final IMenuService menuService;

    @PostMapping
    public ResponseEntity<String> createMenu(@RequestBody Menu menu) {
        menuService.saveMenu(menu);
        return ResponseEntity.ok(MenuConstants.MENU_CREATED_MESSAGE);
    }


}
