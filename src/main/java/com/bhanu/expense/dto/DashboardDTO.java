package com.bhanu.expense.dto;

import java.util.Map;

public class DashboardDTO {

    private Double totalExpense;
    private Map<String, Double> categoryWise;

    public DashboardDTO() {}

    public DashboardDTO(Double totalExpense, Map<String, Double> categoryWise) {
        this.totalExpense = totalExpense;
        this.categoryWise = categoryWise;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public Map<String, Double> getCategoryWise() {
        return categoryWise;
    }

    public void setCategoryWise(Map<String, Double> categoryWise) {
        this.categoryWise = categoryWise;
    }
}