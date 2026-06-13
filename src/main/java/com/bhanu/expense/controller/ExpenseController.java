package com.bhanu.expense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.bhanu.expense.dto.ExpenseDTO;
import com.bhanu.expense.dto.Mapper;
import com.bhanu.expense.entity.Expense;
import com.bhanu.expense.service.ExpenseService;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ExpenseDTO addExpense(@RequestBody Expense expense,
                                 Authentication authentication) {

        String email = authentication.getName();

        return Mapper.toExpenseDTO(
                expenseService.addExpense(expense, email)
        );
    }

    @GetMapping("/my")
    public List<ExpenseDTO> getMyExpenses(Authentication authentication) {

        String email = authentication.getName();

        return expenseService.getUserExpenses(email)
                .stream()
                .map(Mapper::toExpenseDTO)
                .toList();
    }
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {

        expenseService.deleteExpense(id);

        return "Expense Deleted Successfully";
    }
    @PutMapping("/{id}")
    public ExpenseDTO updateExpense(
            @PathVariable Long id,
            @RequestBody Expense expense) {

        return Mapper.toExpenseDTO(
                expenseService.updateExpense(id, expense)
        );
    }
}