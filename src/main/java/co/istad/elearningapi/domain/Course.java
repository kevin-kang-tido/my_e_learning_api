package co.istad.elearningapi.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,length = 100)
    private String alias;

//    private Category catId; // category Id gets from Category
    @Column(columnDefinition = "TEXT")
    private String description;

//    private Instructor insId;  // instructor Id gets from Instructor
//    private Category id;

      private boolean isDeleted;

      private boolean isFree;

      @Column(length = 100)
      private String thumbnail;

      @Column(length = 120)
      private String title;

      @ManyToOne
      private Instructor instructor;

      @ManyToOne
      private Category category;

      @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
      private List<Enrollment> enrollments;
}
