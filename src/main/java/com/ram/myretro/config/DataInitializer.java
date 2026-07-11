package com.ram.myretro.config;

import com.ram.myretro.board.Card;
import com.ram.myretro.board.CardType;
import com.ram.myretro.board.RetroBoard;
import com.ram.myretro.service.RetroBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final RetroBoardService retroBoardService;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        RetroBoard retroBoard = retroBoardService.save(RetroBoard.builder()
                .name("Spring Boot Conference")
                .build());

        retroBoardService.addCardToRetroBoard(retroBoard.getId(), Card.builder()
                .comment("Spring Boot Rocks!")
                .cardType(CardType.HAPPY)
                .retroBoardId(retroBoard.getId())
                .build());

        retroBoardService.addCardToRetroBoard(retroBoard.getId(), Card.builder()
                .comment("Meet everyone in person")
                .cardType(CardType.HAPPY)
                .retroBoardId(retroBoard.getId())
                .build());

        retroBoardService.addCardToRetroBoard(retroBoard.getId(), Card.builder()
                .comment("When is the next  one?")
                .cardType(CardType.MEH)
                .retroBoardId(retroBoard.getId())
                .build());

        retroBoardService.addCardToRetroBoard(retroBoard.getId(), Card.builder()
                .comment("Not enough time to talk to everyone")
                .cardType(CardType.SAD)
                .retroBoardId(retroBoard.getId())
                .build());
    }
}