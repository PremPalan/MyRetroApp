package com.ram.myretro.board;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RetroBoard {

    private UUID id;

    @NotNull
    @NotBlank(message = "A name must be provided")
    private String name;

    @Singular
    private Map<UUID, Card> cards = new HashMap<>();
}

// @Builder: This annotation will create a Fluent API to create a
// RetroBoard instance. This annotation belongs to the Lombok library

// @Data: This annotation generates all the getters and setters and the
// toString(), hashCode(), and equals(Object o) methods. This
// makes our code cleaner, and it won’t impact the performance of the
// application. This annotation also belongs to the Lombok library.

// @Singular: This annotation from the Lombok library helps to build
// single elements by adding them to the list. It’s worth mentioning
// that once the RetroBoard instance is built, the List<Card> is an
// unmodifiable list; keep this in mind.