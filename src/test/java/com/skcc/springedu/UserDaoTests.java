package com.skcc.springedu;

import com.skcc.springedu.dao.UserDao;
import com.skcc.springedu.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTests {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserDao userDao;

    @Test
    public void selectAll() {
        List<User> userList = userDao.selectAll();
        logger.debug("{}", userList);
    }
}
