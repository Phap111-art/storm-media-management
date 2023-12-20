package com.example.stormmediamanagement.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto {
    @Schema(defaultValue = "username" , example = "tuan")
    @NotNull(message = "username cannot be null!")
    @NotEmpty(message = "username cannot be empty!")
    private String username;

    @Schema(defaultValue = "password" , example = "123456")
    @NotNull(message = "password cannot be null!")
    @NotEmpty(message = "password cannot be empty!")
    private String password;
}
