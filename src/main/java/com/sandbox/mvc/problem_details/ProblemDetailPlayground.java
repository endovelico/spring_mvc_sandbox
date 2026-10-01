package com.sandbox.mvc.problem_details;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProblemDetailPlayground {

    @GetMapping("/problem-detail")
    public ProblemDetail problemDetail() {

        ProblemDetail problem = ProblemDetail.forStatus(
                HttpStatus.NOT_FOUND
        );

        problem.setTitle("User not found");
        problem.setDetail("No user exists with the requested ID.");
        problem.setProperty("userId", 42);
        problem.setProperty("errorCode", "USER_NOT_FOUND");

        return problem;
    }
}


