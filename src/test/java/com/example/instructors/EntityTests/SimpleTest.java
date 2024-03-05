package com.example.instructors.EntityTests;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class SimpleTest {

    @Test
    public void addNumberEqualFour(){
        int a = 2;
        int b = 2;
        assertEquals("Sum should be 4", 3, a+b);
    }

}
