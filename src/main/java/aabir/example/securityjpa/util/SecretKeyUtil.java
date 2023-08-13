package aabir.example.securityjpa.util;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.security.Key;

@Service
public class SecretKeyUtil {

    private final String secretKeyString;

    // Constructor injection of the secret key string from application.properties
    public SecretKeyUtil(@Value("${jwt.secret-key}") String secretKeyString) {
        this.secretKeyString = secretKeyString;
    }

    // Use the provided JWT secret key string to generate a symmetric key
    public Key getKey() {
        // Generate a symmetric key based on the provided secret key string
        // Note: The key generation uses HMAC-SHA-256 algorithm
        return Keys.hmacShaKeyFor(secretKeyString.getBytes());
    }
}
