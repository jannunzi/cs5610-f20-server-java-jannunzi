package com.example.cs5610f20serverjavajannunzi.repositories;

import com.example.cs5610f20serverjavajannunzi.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository
    extends CrudRepository<Widget, Integer> {

    @Query(value = "select * from widgets where topic_id=:topicId", nativeQuery = true)
    public List<Widget> findWidgetsForTopic(
            @Param("topicId") String topicId);
}
