package com.bhanu.expense.repository;

import com.bhanu.expense.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUserEmail(String email);

    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.user.email = :email")
    Double getTotalExpenseByUser(String email);

    @Query("SELECT e.category, SUM(e.amount) FROM Expense e WHERE e.user.email = :email GROUP BY e.category")
    List<Object[]> getCategoryWiseExpense(String email);
}