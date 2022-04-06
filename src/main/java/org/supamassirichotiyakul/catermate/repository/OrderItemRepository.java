package org.supamassirichotiyakul.catermate.repository;

import org.supamassirichotiyakul.catermate.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
