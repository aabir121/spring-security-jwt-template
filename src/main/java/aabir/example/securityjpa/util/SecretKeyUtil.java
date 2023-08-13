package aabir.example.securityjpa.util;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.security.Key;

@Service
public class SecretKeyUtil {
    // Use the provided JWT secret key string to generate a symmetric key
    public Key getKey() {
        // Generate a symmetric key based on the provided secret key string
        // Note: The key generation uses HMAC-SHA-256 algorithm
        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }
}
