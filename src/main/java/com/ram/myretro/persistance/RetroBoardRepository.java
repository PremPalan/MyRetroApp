package com.ram.myretro.persistance;

import com.ram.myretro.board.RetroBoard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface RetroBoardRepository extends CrudRepository<RetroBoard,UUID> {
}