package com.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Spring ruft CourseCodeConstraintValidator auf, wenn die Validierung geprüft wird.
@Constraint(validatedBy = CourseCodeConstraintValidator.class) // Verknüpft die Validierungsklasse
@Target({ElementType.METHOD, ElementType.FIELD}) // Kann auf Felder und Methoden angewendet werden
@Retention(RetentionPolicy.RUNTIME) // Annotationm bleibt zur Laufzeit erhalten
public @interface CourseCode {

    // define default course code
    // Wird in Customer verwendet (@CourseCode(value="HMN")).
    public String value() default "WAL";

    // define default error message
    public String message() default "must start with WAL";

    // define default groups (wird für komplexe Validierungen verwendet)
    public Class<?>[] groups() default {};

    // define default payloads (Erlaubt das Hinzufügen zusätzlicher Validierungsmetadaten)
    public Class<? extends Payload>[] payload() default {};

}
