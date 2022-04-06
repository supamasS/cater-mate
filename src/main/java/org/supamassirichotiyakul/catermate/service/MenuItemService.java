package org.supamassirichotiyakul.catermate.service;

import org.supamassirichotiyakul.catermate.model.MenuItem;

import java.util.List;

public interface MenuItemService {
    List<MenuItem> getAllMenuItems();
    void saveMenuItem(MenuItem menuItem);
    MenuItem getMenuItemById(long id);
    void deleteMenuItemById(long id);
}
