package org.example.crazycoin.services.interfaces;

import org.example.crazycoin.controllers.dtos.requests.CreateExpenseRequest;
import org.example.crazycoin.controllers.dtos.responses.BaseResponse;

public interface IExpenseService {
    BaseResponse create(CreateExpenseRequest request);
}
