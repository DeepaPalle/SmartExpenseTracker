package com.bhanu.expense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhanu.expense.entity.Expense;
import com.bhanu.expense.entity.User;
import com.bhanu.expense.repository.ExpenseRepository;
import com.bhanu.expense.repository.UserRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    public Expense addExpense(Expense expense, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        expense.setUser(user);

        return expenseRepository.save(expense);
    }

    public Double getTotalExpense(String email) {
        return expenseRepository.getTotalExpenseByUser(email);
    }

    public List<Object[]> getCategoryWiseExpense(String email) {
        return expenseRepository.getCategoryWiseExpense(email);
    }

    public List<Expense> getUserExpenses(String email) {
        return expenseRepository.findByUserEmail(email);
    }
    public void deleteExpense(Long id) {

        expenseRepository.deleteById(id);
    }
    public Expense updateExpense(Long id, Expense updatedExpense) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Expense Not Found"));

        expense.setTitle(updatedExpense.getTitle());
        expense.setAmount(updatedExpense.getAmount());
        expense.setCategory(updatedExpense.getCategory());
        expense.setDate(updatedExpense.getDate());

        return expenseRepository.save(expense);
    }
}