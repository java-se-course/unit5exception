package com.epam.course.java.se;

import org.junit.Test;

import java.io.FileNotFoundException;

public class Bug {
    private interface TestClass<T extends Throwable> {
        void test() throws T;
    }

    @Test
    public void test() {
        try {
            bug();
        } catch (Exception e) {
            System.err.println("Got exception of type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }

    private void bug() {
        final TestClass<FileNotFoundException> tc =
                new TestClass<FileNotFoundException>() {
                    @Override
                    public void test() throws FileNotFoundException {
                        throw new FileNotFoundException();
                    }
                };

        final TestClass tc2 = tc;

        final TestClass<RuntimeException> tc3 = tc2;

        tc3.test();
    }

}
