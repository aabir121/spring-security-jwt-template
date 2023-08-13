package aabir.example.securityjpa.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AuthenticationResponse {
    private final String jwt;
}
