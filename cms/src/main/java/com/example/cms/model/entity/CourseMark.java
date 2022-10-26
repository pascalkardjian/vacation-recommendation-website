package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "marks")
public class CourseMark {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long markId;

    @ManyToOne
    @JoinColumn(name = "studentId")
    @NotEmpty
    @JsonIgnoreProperties({"marks"})
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseCode")
    @NotEmpty
    @JsonIgnoreProperties({"marks"})
    private Course course;

    @NotEmpty
    private int mark;

}
