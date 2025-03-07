package com.springdemo.mvc;

import com.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    /* 
     * Das Customer-Objekt wird im Controller erstellt und im Model gespeichert.
     *
     * Beim Absenden des Formulars erstellt Spring ein neues Customer-Objekt und
     * setzt die Eingaben aus dem Formular
     *
     * Die Validierung erfolgt automatisch durch Bean Validation (@Valid).
     */

    private String firstName;

    @NotNull(message="is required")
    @Size(min=1, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value=0, message="must be greater than or equal to 0")
    @Max(value=10, message ="must be less or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

    // Benutzerdefinierte Validierung: CourseCode muss mit dem Wert in "value" beginnen
    @CourseCode(value="HMN", message="must start with HMN")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public Customer() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
