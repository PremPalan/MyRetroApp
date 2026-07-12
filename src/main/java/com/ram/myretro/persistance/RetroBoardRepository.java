package com.ram.myretro.persistance;

import com.ram.myretro.board.RetroBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface RetroBoardRepository extends JpaRepository<RetroBoard,UUID> {
}

// public interface JpaRepository<T, ID> extends ListCrudRepository<T, ID>,
// ListPagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {
//
//      void flush();
//
//      <S extends T> S saveAndFlush(S entity);
//
//      <S extends T> List<S> saveAllAndFlush(Iterable<S> entities);
//
//      void deleteAllInBatch(Iterable<T> entities);
//
//      void deleteAllByIdInBatch(Iterable<ID> ids);
//
//      void deleteAllInBatch();
//
//      T getReferenceById(ID id);
//
//      @Override
//      <S extends T> List<S> findAll(Example<S> example);
//
//      @Override
//      <S extends T> List<S> findAll(Example<S> example, Sort sort);
//}