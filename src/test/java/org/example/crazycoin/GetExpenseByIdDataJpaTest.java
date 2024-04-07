package org.example.crazycoin;

import org.example.crazycoin.entities.Expense;
import org.example.crazycoin.repositories.IExpenseRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class GetExpenseByIdDataJpaTest {
    @Autowired
    private IExpenseRepository repository;

    @Test
    public void contextLoads() {
        List<Expense> expense = repository.findByUserId("858fa181-6e16-45dc-b8a7-706d782b8075");
        assertThat(expense).isNotNull();
    }
}
