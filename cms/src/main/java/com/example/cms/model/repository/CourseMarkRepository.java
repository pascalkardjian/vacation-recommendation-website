package com.example.cms.model.repository;

import com.example.cms.model.entity.CourseMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CourseMarkRepository extends JpaRepository<CourseMark, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE marks SET mark = LEAST((mark + 5), 100) WHERE " +
            "courseCode = :code", nativeQuery = true)
    void increaseFive(@Param("code") String code);
}
