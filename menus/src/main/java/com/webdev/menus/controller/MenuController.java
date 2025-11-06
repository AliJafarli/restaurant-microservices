package com.webdev.menus.controller;

import com.webdev.menus.constants.MenuConstants;
import com.webdev.menus.service.IMenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.webdev.menus.entity.Menu;

import java.util.List;


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

    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus() {
        return ResponseEntity.ok(menuService.getAllMenus());
    }

    @GetMapping
    public ResponseEntity<Menu> getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
