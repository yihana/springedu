package com.skcc.springedu;

import com.skcc.springedu.dao.UserDao;
import com.skcc.springedu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PerformanceAspectTests {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService[] userServices;

    @Autowired
    UserDao[] userDaos;

    @Test
    public void count() {
        logger.debug("");
    }
}
