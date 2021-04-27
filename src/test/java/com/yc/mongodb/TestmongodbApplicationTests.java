package com.yc.mongodb;

import com.yc.mongodb.bean.Spring;
import com.yc.mongodb.dao.SpringDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestmongodbApplicationTests {
    @Autowired
    private SpringDao springDao;

    @Test
    public void testFindByName() {
        System.out.println(springDao.findByName("张三"));
    }

    @Test
    public void testUpdate(){
        springDao.update("age",1,100);
    }

    @Test
    public void testInsert(){
        springDao.insert(new Spring(1,20,"张三"));
    }

    @Test
    public void testDelete(){
        springDao.delete(1);
    }
}
