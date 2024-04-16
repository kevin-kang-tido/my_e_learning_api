package co.istad.elearningapi.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BasedErrorResponse {
    private BasedError error;
}
