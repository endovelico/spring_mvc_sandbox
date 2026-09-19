
package com.sandbox.mvc.init_binder;
import com.sandbox.mvc.formatter.LocalDatePropertyEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/users")
public class UserController {

    /*
     * @InitBinder is called by Spring MVC when preparing
     * the WebDataBinder for this controller.
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {

        /*
         * Only these fields are allowed to be bound
         * from incoming request data.
         */
        binder.setAllowedFields(
                "username",
                "email",
                "birthDate"
        );


        /*
         * Register a custom PropertyEditor.
         *
         * This tells Spring how to convert incoming
         * text into a LocalDate.
         */
        binder.registerCustomEditor(
                LocalDate.class,
                new LocalDatePropertyEditor()
        );
    }

    @PostMapping
    public String createUser(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam LocalDate birthDate) {

        return String.format(
                "User created: %s, %s, %s",
                username,
                email,
                birthDate
        );
    }

    @GetMapping
    public String getUsers() {
        return "Users";
    }
}