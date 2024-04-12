package co.istad.elearningapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String highSchool;

    private Boolean isBlocked;

    private String university;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;
}
