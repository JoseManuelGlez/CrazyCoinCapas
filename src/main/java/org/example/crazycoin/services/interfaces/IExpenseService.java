package org.example.crazycoin.services.interfaces;

import org.example.crazycoin.controllers.dtos.requests.CreateExpenseRequest;
import org.example.crazycoin.controllers.dtos.responses.BaseResponse;
import org.example.crazycoin.entities.Expense;

public interface IExpenseService {
    BaseResponse create(CreateExpenseRequest request);
  
    BaseResponse getExpensesByUserId(String userId);

    BaseResponse delete(String id);

    BaseResponse update(String id, CreateExpenseRequest request);

    Expense findOneAndEnsureExist(String id);
}
