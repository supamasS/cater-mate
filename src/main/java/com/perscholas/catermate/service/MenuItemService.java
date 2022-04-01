package com.perscholas.catermate.service;

import com.perscholas.catermate.model.MenuItem;

import java.util.List;

public interface MenuItemService {
    List<MenuItem> getAllMenuItems();
    void saveMenuItem(MenuItem menuItem);
    MenuItem getMenuItemById(long id);
    void deleteMenuItemById(long id);
}
