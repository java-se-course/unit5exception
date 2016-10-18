package com.epam.course.java.se;

import lombok.Getter;
import org.junit.Test;

import java.util.Objects;

public class Exceptions {

    private String getFullName(Person person) throws NullPointerException {
//        Objects.requireNonNull(person, "Person should not be null");
        if (person == null) {
            throw new NullPointerException("Person should not be null");
        }
        return String.format("%s %s", person.getFirstName(), person.getLastName());
    }

    @Test
    public void nre() {
        System.out.println(getFullName(new Person("Bob", "White")));
//        final Person person = new Person("John", "Doe");
        final Person person = null;
        try {
            final String fullName = getFullName(person);
            System.out.println(fullName);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private int div(int a, int b) {
        return a/b;
    }

    @Test
    public void debTest() {
        div(1, 0);
    }

    @Test
    public void gender() {
//        final String genderStr = "MALE";
        final String genderStr = "incorrect";
//        final String genderStr = null;
        try {
            final Gender gender = Gender.valueOf(genderStr);

            System.out.println(gender);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.printf("Unknown gender '%s'\n", genderStr);
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Got NPE");
            throw e;
        }
    }

}
