package com.epam.course.java.se;

import lombok.Data;
import lombok.NonNull;

@Data
public class Person {
    @NonNull private final String firstName;
    @NonNull private final String lastName;
}
