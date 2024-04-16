    package co.istad.elearningapi.domain;


    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    import lombok.ToString;

    import java.util.List;

    @Setter
    @Getter
    @NoArgsConstructor
    @Entity
    @Table(name = "categories")
//    @ToString
    public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true, nullable = false)
        private String alias;

        @Column(nullable = false, unique = true)
        private String name;

        private String icon;

        private boolean isDeleted;

        @ManyToOne
        @JoinColumn(name = "parent_category_id")
        private Category parentCategory;
//        @Column(name = "parent_category_id")
//        private Long parentCategoryId;

        @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
        private List<Course> courses;
    }
