package com.funnycode.todoapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepositoryJPA extends JpaRepository<Todo,Integer> {
    @Query("select t from Todo t where t.title=?1 or t.detail=?2")
    List<Todo> findAllByTitleOrDetail(String title, String detail);
}
