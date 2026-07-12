package com.ram.myretro.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Card {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @NotBlank(message = "A comment must be provided always")
    @NotNull
    private String comment;

    @NotNull(message = "A CardType HAPPY|MEH|SAD must be provided")
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @ManyToOne
    @JoinColumn(name = "retro_board_id")
    @JsonIgnore
    private RetroBoard retroBoard;
}

// @ManyToOne: This annotation specifies a single-valued association to
// another entity class that has many-to-one multiplicity. There is also
// the @ManyToMany, @OneToOne, @OneToMany

// @JoinColumn: This annotation specifies a column for joining an entity
// association or element collection. In this case we are identifying
// which column to join, retro_board_id. Remember that the
// NamingStrategy takes place, using snake case to create the fields. You
// can see that in the previous snippet