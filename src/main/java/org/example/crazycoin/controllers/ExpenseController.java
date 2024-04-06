package org.example.crazycoin.controllers;

import org.example.crazycoin.controllers.dtos.responses.BaseResponse;
import org.example.crazycoin.services.interfaces.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("expense")
public class ExpenseController {
    @Autowired
    private IExpenseService service;

    @GetMapping("{userId}")
    public ResponseEntity<BaseResponse> getExpensesByUserId(@PathVariable String userId) {
        BaseResponse baseResponse = service.getExpensesByUserId(userId);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
