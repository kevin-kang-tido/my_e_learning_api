package co.istad.elearningapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String biography;

    @Column(length = 100)
    private String github;

    private boolean isBlocked;

    @Column(length = 100)
    private String jobTitle;

    @Column(length = 100)
    private String linkedIn;

    @Column(length = 100)
    private String website;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses ;

    @ManyToOne
    private User user;

}
