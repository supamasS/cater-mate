package org.supamassirichotiyakul.catermate.service;

import org.supamassirichotiyakul.catermate.exception.MenuItemNotFoundException;
import org.supamassirichotiyakul.catermate.model.MenuItem;
import org.supamassirichotiyakul.catermate.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuItemService {
    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public void saveMenuItem(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem getMenuItemById(long id) {
        MenuItem menuItem = menuItemRepository.getById(id);
        if(menuItem == null) {
            throw new MenuItemNotFoundException();
        }
        return menuItem;
    }

    @Override
    public void deleteMenuItemById(long id) {
        menuItemRepository.deleteById(id);
    }
}
