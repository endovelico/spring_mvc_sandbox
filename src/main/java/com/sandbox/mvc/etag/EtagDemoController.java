package com.sandbox.mvc.etag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EtagDemoController {

    @GetMapping("/hello")
    public String hello() {
        return """
               {
                 "message": "Hello from REST",
                 "version": 1
               }
               """;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        Product product = service.findById(id);

        return ResponseEntity.ok()
                .eTag("\"" + product.getVersion() + "\"")
                .body(product);
    }
}
