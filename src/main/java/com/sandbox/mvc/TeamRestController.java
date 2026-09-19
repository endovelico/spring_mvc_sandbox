package com.sandbox.mvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class TeamRestController {

    // GET /api/users
    @GetMapping
    public List<String> getPlayers() {

        return List.of("Alice", "Bob", "Charlie");
    }

    // GET /api/users/10
    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        return "User " + id;
    }

    // GET /api/users/search?name=Alice
    @GetMapping("/search")
    public String search(@RequestParam String name) {
        return "Searching for " + name;
    }

    // GET /api/users/filter?age=20
    @GetMapping("/filter")
    public String optional(
            @RequestParam(required = false) Integer age) {
        return "Age = " + age;
    }

    // POST /api/users
    @PostMapping
    public Map<String, Object> create(
            @RequestBody NFLRequest request) {



        return Map.of(
                "name", "request.name()",
                "age", 1
        );
    }

    // PUT /api/users/5
    @PutMapping("/{id}")
    public String update(
            @PathVariable Long id,
            @RequestBody NFLRequest request) {

        return "Updated " + id;
    }

    // DELETE /api/users/5
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return "Deleted " + id;
    }

    // Custom HTTP status
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/created")
    public NFLRequest created(
            @RequestBody NFLRequest request) {
        return request;
    }

    // ResponseEntity
    @GetMapping("/entity")
    public ResponseEntity<String> entity() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Spring");

        return new ResponseEntity<>(
                "Hello",
                headers,
                HttpStatus.ACCEPTED
        );
    }

    // Request headers
    @GetMapping("/header")
    public String header(
            @RequestHeader("User-Agent") String agent) {

        return agent;
    }

    // Cookies
    @GetMapping("/cookie")
    public String cookie(
            @CookieValue("JSESSIONID") String session) {

        return session;
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public User getJson(@PathVariable Long id) {
        return new User(id, "Alice", "alice@example.com");
    }

    @GetMapping(value = "/{id}", produces = "text/plain")
    public String getText(@PathVariable Long id) {
        return "Alice";
    }

}
