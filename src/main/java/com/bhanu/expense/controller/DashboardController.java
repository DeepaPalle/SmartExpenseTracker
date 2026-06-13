package com.bhanu.expense.controller;

import com.bhanu.expense.dto.DashboardDTO;
import com.bhanu.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public DashboardDTO getDashboard(Authentication authentication) {

        String email = authentication.getName();

        Double total = expenseService.getTotalExpense(email);
        List<Object[]> data = expenseService.getCategoryWiseExpense(email);

        Map<String, Double> categoryMap = new HashMap<>();

        for (Object[] row : data) {
            String category = (String) row[0];
            Double amount = (Double) row[1];
            categoryMap.put(category, amount);
        }

        return new DashboardDTO(total, categoryMap);
    }
}