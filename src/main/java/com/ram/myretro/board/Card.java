package com.ram.myretro.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Card {

    @Id
    private UUID id;

    @NotBlank(message = "A comment must be provided always")
    @NotNull
    private String comment;

    @NotNull(message = "A CardType HAPPY|MEH|SAD must be provided")
    private CardType cardType;

    @JsonIgnore
    private UUID retroBoardId;
}
