package com.ram.myretro.board;

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
public class Card {

    private UUID id;

    @NotBlank(message = "A comment must be provided always")
    @NotNull
    private String comment;

    @NotNull(message = "A CardType HAPPY|MEH|SAD must be provided")
    private CardType cardType;

    private UUID retroBoardId;
}
