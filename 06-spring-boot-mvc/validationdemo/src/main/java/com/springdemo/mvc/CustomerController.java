package com.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // InitBinder wird aufgerufen, bevor das Daten-Binding beginnt
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // Entfernt automatisch führende und folgende Leerzeichen aus allen String-Inputs
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    // Empfängt GET-Anfragen an "/"
    @GetMapping("/")
    public String showForm(Model model) {
        // Erstellt ein neues Customer-Objekt und speichert es im Model
        model.addAttribute("customer", new Customer());
        // Gibt den Namen der View zurück (Spring ruft die passende HTML-Datei auf)
        return "customer-form";
    }

    // Verarbeitet das abgesendete Formular
    @PostMapping("/processForm")
    public String processForm(
            // valid: tell spring to perform validation
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult) { // Speichert mögliche Validierungsfehler

        // Debug-Ausgabe: Zeigt den Nachnamen in der Konsole
        System.out.println("Last name:|" + customer.getLastName() + "|");

        // Debug-Ausgabe: Zeigt alle Validierungsfehler
        System.out.println("\n\n\n\n");
        System.out.println("Binding results: " + bindingResult.toString());

        // Falls Valdierungsfehler vorhanden sind, zeige das Formular erneut mit Fehlermeldungen
        if (bindingResult.hasErrors()) {
            return "customer-form";
        }
        // Falls alles korrekt ist, leite zur Bestätigungsseite weiter    
        else {
            return "customer-confirmation";
        }

    }
}
