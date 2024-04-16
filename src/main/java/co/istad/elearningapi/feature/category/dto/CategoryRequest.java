package co.istad.elearningapi.feature.category.dto;

import co.istad.elearningapi.domain.Category;
import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(
        @NotBlank(message = "Alias is required!")
        String alias,
        @NotBlank(message = "Name is required")
        String name,
        String icon,
        Category parentCategory,
        boolean isDeleted
) {
}
