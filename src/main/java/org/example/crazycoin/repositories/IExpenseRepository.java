package org.example.crazycoin.repositories;

import org.example.crazycoin.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExpenseRepository extends JpaRepository<Expense, String> {
    List<Expense> findByUserId(String userId);
}
