package com.example.algorithm.stackAndQueue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueueExampleTest {
    @Autowired
    QueueExample queueExample;

    @Test
    public void truck() {
        int[] truck = {7,4,5,6};
        System.out.println(queueExample.truck(2,10,truck));

    }
}
