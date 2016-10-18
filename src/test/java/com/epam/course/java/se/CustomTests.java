package com.epam.course.java.se;

import org.junit.Test;

public class CustomTests {

    private String not666ToString(int i) throws CustomCheckedException {
        if (i == 666) {
            throw new CustomCheckedException("Paramether 'i' should not be 666");
        }

        return Integer.toString(i);
    }

    private String get13ToString() {
        try {
//            return not666ToString(13);
            return not666ToString(666);
        } catch (CustomCheckedException e) {
            throw new CustomUncheckedException("Should newer get here.", e);
        }
    }

    @Test
    public void test0() {
        try {
            get13ToString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }







}
