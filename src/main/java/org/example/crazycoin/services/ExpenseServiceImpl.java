package org.example.crazycoin.services;


import org.example.crazycoin.controllers.dtos.responses.BaseResponse;
import org.example.crazycoin.entities.Expense;
import org.example.crazycoin.repositories.IExpenseRepository;
import org.example.crazycoin.services.interfaces.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements IExpenseService {
    @Autowired
    private IExpenseRepository repository;

    @Override
    public BaseResponse getExpensesByUserId(String userId) {
        List<Expense> expenses = repository.findByUserId(userId);

        return BaseResponse.builder()
                .data(expenses)
                .message("Expenses found correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }
}
