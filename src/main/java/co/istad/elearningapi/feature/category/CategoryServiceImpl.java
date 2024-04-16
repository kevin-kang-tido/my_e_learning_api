package co.istad.elearningapi.feature.category;

import co.istad.elearningapi.domain.Category;
import co.istad.elearningapi.feature.category.dto.CategoryRequest;
import co.istad.elearningapi.feature.category.dto.CategoryResponse;
import co.istad.elearningapi.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements  CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public void createNewCategory(CategoryRequest categoryRequest) {
        // check category exist or not
        Category existingCategory = categoryRepository.findByAlias(categoryRequest.alias());
        if (existingCategory != null) {
            throw new IllegalArgumentException("Category with alias " + categoryRequest.alias() + " already exists");
        }
        // new category
        Category newCategory = new Category();
        newCategory.setAlias(categoryRequest.alias());
        newCategory.setName(categoryRequest.name());
        newCategory.setIcon(categoryRequest.icon());
        newCategory.setParentCategory(categoryRequest.parentCategory());
        newCategory.setDeleted(categoryRequest.isDeleted());

        categoryRepository.save(newCategory);
    }

    @Override
    public CategoryResponse findAllCategoryByAlias(String alias) {
        Optional<Category> optionalCategory = Optional.ofNullable(categoryRepository.findByAlias(alias));
        Category category = optionalCategory.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Category with alias " + alias + " has not been found!"));
        return categoryMapper.toCategoryResponse(category);
    }

    @Override
    public Page<CategoryResponse> findAllCategoriesByPagination(int page, int size) {
        if (page < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Page number must be greater than or equal to zero");
        }

        if (size < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Size must be greater than or equal to one");
        }

        Sort sortByName = Sort.by(Sort.Direction.ASC, "name");
        PageRequest pageRequest = PageRequest.of(page, size, sortByName);

        Page<Category> accounts = categoryRepository.findAll(pageRequest);

        return accounts.map(categoryMapper::toCategoryResponse);
    }

    @Override
    public List<Category> findAllSubCategories(Long parentId) {
        List<Category> directSubCategories =  categoryRepository.findByParentCategoryId(parentId);
        List<Category> subCategories = new ArrayList<>(directSubCategories);
        if (subCategories.isEmpty()) {
            throw new IllegalArgumentException("No sub-categories found for parent ID: " + parentId);
        }
        return subCategories;
    }

}
