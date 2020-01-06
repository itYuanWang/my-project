package com.example.myproject;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@SpringBootTest
public class MyProjectApplicationTests {

	@Test
	void test() {
        HashMap hashMap = new HashMap();
        for (int i = 1; i < 20; i++) {
            hashMap.put(i,"aaaa");
        }


	}

}
