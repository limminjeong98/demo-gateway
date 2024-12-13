package org.example.bookapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/v1/books")
@RestController
public class BookController {

    @GetMapping("/{id}")
    public ResponseEntity getBookInfo(@PathVariable("id") Long bookId) {
        return new ResponseEntity<>(
                Map.of(
                        "bookId", bookId,
                        "bookInfo", Map.of("bookName", "testbook"),
                        "timestamp", System.currentTimeMillis()
                ), HttpStatus.OK
        );
    }
}
