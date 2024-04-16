package co.istad.elearningapi.feature.User.dto;

import java.util.List;

public record RoleResponse(
        String name,
        List<RoleAuthorityResponse> authorities
) {
}
