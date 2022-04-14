package org.supamassirichotiyakul.catermate.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.supamassirichotiyakul.catermate.repository.MenuItemRepository;
import org.supamassirichotiyakul.catermate.service.MenuItemService;
import org.supamassirichotiyakul.catermate.service.MenuItemServiceImpl;

@Configuration
public class AppConfiguration {

    // Make this a manually created bean to satisfy the capstone requirement
    @Bean
    @Autowired
    public MenuItemService menuItemService(MenuItemRepository menuItemRepository) {
        return new MenuItemServiceImpl(menuItemRepository);
    }
}
