package org.example.crazycoin.services.interfaces;

import org.example.crazycoin.controllers.dtos.responses.BaseResponse;

public interface IExpenseService {
    BaseResponse getExpensesByUserId(String userId);
}
