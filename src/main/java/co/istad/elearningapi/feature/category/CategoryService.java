package co.istad.elearningapi.feature.category;

import co.istad.elearningapi.domain.Category;
import co.istad.elearningapi.feature.category.dto.CategoryRequest;
import co.istad.elearningapi.feature.category.dto.CategoryResponse;
import org.springframework.data.domain.Page;

import java.util.List;


public interface CategoryService  {
    void createNewCategory(CategoryRequest categoryRequest);
    CategoryResponse findAllCategoryByAlias(String alias);
    // find all category by pagination
    Page<CategoryResponse> findAllCategoriesByPagination(int page,int size);
    // find all subcategory
    List<Category> findAllSubCategories(Long parentId);



}
