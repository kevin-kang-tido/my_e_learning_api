package co.istad.elearningapi.feature.category.dto;

import co.istad.elearningapi.domain.Category;

public record CategoryResponse(
        String alias,
        String name,
        String icon,
        Category parentCategory

) {
}
