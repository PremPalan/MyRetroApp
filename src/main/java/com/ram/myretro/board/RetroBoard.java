package com.ram.myretro.board;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class RetroBoard {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @NotNull
    @NotBlank(message = "A name must be provided")
    private String name;

    @Singular
    @OneToMany(mappedBy = "retroBoard")
    private List<Card> cards;
}