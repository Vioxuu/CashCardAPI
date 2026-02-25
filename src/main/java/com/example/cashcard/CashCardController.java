package com.example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {

    private final CashCardRepository cashCardRepository;

    private CashCardController(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }

    @GetMapping("/{id}")
    private ResponseEntity<CashCard> findById(@PathVariable Long id) {
        Optional<CashCard> cashcardOptional = cashCardRepository.findById(id);
        if(cashcardOptional.isPresent())
            return ResponseEntity.ok(cashcardOptional.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    private ResponseEntity<Void> createCashCard(@RequestBody CashCard cashcard, UriComponentsBuilder uriBuilder) {
        CashCard createdCashCard = cashCardRepository.save(cashcard);
        URI location = uriBuilder
                .path("/cashcards/{id}")
                .buildAndExpand(createdCashCard.id())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
