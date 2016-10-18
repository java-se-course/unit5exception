package com.epam.course.java.se;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.Formatter;

public class All {
    private void checked() throws CustomCheckedException {
//        throw new CustomCheckedException();
    }

    private void unchecked1() {
//        throw new CustomCheckedException(); // Compilation error
        throw new CustomUncheckedException();
    }

    private void unchecked2() throws CustomUncheckedException {
    }

    @Test
    public void try_test() {
        try {
            checked();
        } catch (CustomCheckedException e) {
            e.printStackTrace();
        } catch (CustomUncheckedException | IllegalArgumentException e) {
            throw e;
        } finally {
            System.out.println("Should always print this");
        }
    }

    @Test
    public void try_with_res1() throws FileNotFoundException {
        try (Formatter formatter = new Formatter("noSuchDitectory/file.txt")) {
        } // AutoCloseable::close
    }
    @Test
    public void try_with_res2() {
        try (Formatter formatter = new Formatter("noSuchDitectory/file.txt")) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } // AutoCloseable::close
    }

    private int returns() {
        try {
            checked();
            return 1;
        } catch (CustomCheckedException e) {
            e.printStackTrace();
            return 2;
        } finally {
            return 3;
        }
    }

    @Test
    public void returns_test(){
        System.out.println(returns());
    }

    @Test
    public void asserts() {
        assert 1 == 2;

    }

    public void ttt() throws RemoteException {
        try {
            throw new RemoteException();

        } catch (Exception e) {
            throw e;
        }
    }
}
