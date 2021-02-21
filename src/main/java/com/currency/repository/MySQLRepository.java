package com.currency.repository;

import com.currency.model.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySQLRepository extends JpaRepository<CurrencyEntity, Integer> {
}
