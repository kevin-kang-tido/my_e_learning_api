package co.istad.elearningapi.feature.category;

import co.istad.elearningapi.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByAlias(String alias);

    List<Category> findByParentCategoryId(long parentId);
}
