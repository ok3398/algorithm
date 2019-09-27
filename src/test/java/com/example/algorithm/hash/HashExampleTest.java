package com.example.algorithm.hash;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HashExampleTest {
    @Autowired
    HashExample hashExample;

    @Test
    public void marathonPlayer() {
        String[] participant = {"leo","kiki","eden"};
        String[] completion = {"eden","kiki"};
        String rtn = hashExample.marathonPlayer(participant, completion);

        System.out.println(rtn);

    }


}
