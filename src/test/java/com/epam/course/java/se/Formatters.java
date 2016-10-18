package com.epam.course.java.se;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Locale;

public class Formatters {
    @Test
    public void test1() throws FileNotFoundException {
        final Formatter formatter = new Formatter("thereIsNoSuchFile.txt");
        formatter.format(Locale.CANADA, "Abc, %d", 11);
        formatter.flush();
        formatter.close();
    }

    @Test
    public void test2() {
        try {
            writeToFile();
        } catch (RuntimeException e) {
            final Throwable cause = e.getCause();
            if (cause != null) {
                System.out.println(cause.getMessage());
                System.out.println(cause.getLocalizedMessage());
            }
            throw e;
        }

    }

    private void writeToFile() {
        // new Formatter("thereIsNoSuchFile.txt"); // Compilation error
        Formatter formatter = null;
        try {
//            final Formatter formatter = new Formatter("thereIsNoSuchDirectory/file.txt");
            //formatter = new Formatter("file.txt");
            formatter = new Formatter("thereIsNoSuchDirectory/file.txt");
            formatter.format(Locale.CANADA, "Abc, %d", 11);
            final int i = 1 / 0;
            formatter.flush();
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
            throw new RuntimeException("No file!", e);
        }
    }

    private void writeToFileWithRes() {
        // new Formatter("thereIsNoSuchFile.txt"); // Compilation error
        try(Formatter formatter = new Formatter("file.txt")) {
//            final Formatter formatter = new Formatter("thereIsNoSuchDirectory/file.txt");
            //formatter = new Formatter("file.txt");
            formatter.format(Locale.CANADA, "Abc, %d", 11);
            final int i = 1 / 0;
            formatter.flush();
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
            throw new RuntimeException("No file!", e);
        } finally {
            throw new CustomUncheckedException();
        }
    }

    @Test
    public void test3() {
        try {
            writeToFileWithRes();
        } catch (RuntimeException e) {
            final Throwable cause = e.getCause();
            if (cause != null) {
                System.out.println(cause.getMessage());
                System.out.println(cause.getLocalizedMessage());
            }
            throw e;
        }
    }

}
