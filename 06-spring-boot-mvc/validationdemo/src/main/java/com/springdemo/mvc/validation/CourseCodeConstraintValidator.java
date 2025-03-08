package com.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> { // String --> Der Typ des Feldes, das validiert wird (private String courseCode; in Customer).

    private String coursePrefix; // Speichert den erforderlichen Präfix-Wert

    // Initialisiert den Validator und liest den Wert aus @CourseCode
    @Override
    public void initialize(CourseCode courseCode) { // CourseCode --> Das ist die Annotation, die verarbeitet wird (@CourseCode in Customer)
        ConstraintValidator.super.initialize(courseCode);
        coursePrefix = courseCode.value(); // Speichert den Wert aus @CourseCode(value="...")
    }

    // Validiert die Benutzereingaben
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) { // String theCode --> Das ist der Wert, den der Benutzer ins Formular eingibt (customer.courseCode).
        // Stammt aus dem Customer-Objekt, dsa sich im Model befindet. Es kommt aus der @PostMapping-Anfrage.
        // Spring übergibt diesen Wert automatisch an isValid(), wenn die Validierung geprüft wird.

        boolean result;

        if (theCode != null) {
            result = theCode.startsWith(coursePrefix);
        } else {
            result = true;
        }

        return result;
    }
}
