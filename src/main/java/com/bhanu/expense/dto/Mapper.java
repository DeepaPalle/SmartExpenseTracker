package com.bhanu.expense.dto;

import com.bhanu.expense.entity.Expense;

public class Mapper {

    public static ExpenseDTO toExpenseDTO(Expense expense) {

        ExpenseDTO dto = new ExpenseDTO();

        dto.setId(expense.getId());
        dto.setTitle(expense.getTitle());
        dto.setAmount(expense.getAmount());
        dto.setCategory(expense.getCategory());
        dto.setDate(expense.getDate());

        return dto;
    }
}