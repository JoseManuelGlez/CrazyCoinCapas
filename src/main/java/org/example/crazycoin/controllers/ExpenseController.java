package org.example.crazycoin.controllers;

import org.example.crazycoin.controllers.dtos.requests.CreateExpenseRequest;
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

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateExpenseRequest request) {
        BaseResponse baseResponse = service.create(request);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable String id, @RequestBody CreateExpenseRequest request){
        BaseResponse baseResponse = service.update(id, request);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("{userId}")
    public ResponseEntity<BaseResponse> getExpensesByUserId(@PathVariable String userId) {
        BaseResponse baseResponse = service.getExpensesByUserId(userId);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable String id){
        BaseResponse baseResponse = service.delete(id);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
