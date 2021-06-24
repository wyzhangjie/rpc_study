package com.rpc.db.reposity;

import com.rpc.AccessingDataJpaApplication;
import com.rpc.db.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccessingDataJpaApplication.class)
public class UsersRepositoryTest  {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        User a = new User();

        User user = userRepository.save(User.builder().name("jackxx").email("123456@126.com").build());
        Assert.assertNotNull(user);
        List<User> users= userRepository.findAll();
        System.out.println(users);
        Assert.assertNotNull(users);
    }

}