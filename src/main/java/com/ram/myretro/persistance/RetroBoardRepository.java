package com.ram.myretro.persistance;

import com.ram.myretro.board.RetroBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.*;

@RepositoryRestResource(path = "retros",itemResourceRel = "retros", collectionResourceRel = "retros")
public interface RetroBoardRepository extends JpaRepository<RetroBoard,UUID> {
}