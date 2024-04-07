package org.example.crazycoin;

import org.example.crazycoin.entities.Expense;
import org.example.crazycoin.entities.User;
import org.example.crazycoin.repositories.IExpenseRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostExpenseDataJpaTest {
    @Autowired
    private IExpenseRepository repository;

    @Test
    public void contextLoads() {
        Expense expense = new Expense();
        User user = new User();
        user.setId("858fa181-6e16-45dc-b8a7-706d782b8075");

        expense.setUser(user);
        expense.setMount(200.00);
        expense.setDescription("nothing");
        expense.setCategory("Food");
        expense.setDate("07/04/2024");

        Expense e = repository.save(expense);

        assertThat(e).isNotNull();
        assertThat(expense.getMount()).isNotNull();
        assertThat(expense.getMount()).isGreaterThanOrEqualTo(0.0);
        assertThat(expense.getMount()).isInstanceOf(Double.class);
        assertThat(expense.getDescription()).isInstanceOf(String.class);
        assertThat(expense.getCategory()).isInstanceOf(String.class);
        assertThat(expense.getDate()).isInstanceOf(String.class);
    }
}
