package org.supamassirichotiyakul.catermate.repository;

import org.supamassirichotiyakul.catermate.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
