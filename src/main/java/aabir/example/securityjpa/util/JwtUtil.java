package aabir.example.securityjpa.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private final Key secretKey;
    private final long tokenValidityMinutes;

    // Constructor injection of SecretKeyUtil and application.properties value
    @Autowired
    public JwtUtil(SecretKeyUtil secretKeyUtil,
                   @Value("${jwt.tokenValidityMinutes}") long tokenValidityMinutes) {
        // Get the secret key from SecretKeyUtil based on the provided string
        this.secretKey = secretKeyUtil.getKey();
        this.tokenValidityMinutes = tokenValidityMinutes;
    }

    // Extract the username from the JWT token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extract the expiration date from the JWT token
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Generic method to extract claims from JWT token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Extract all claims from the JWT token
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    }

    // Check if the token has expired
    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Generate a JWT token based on user details
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        // In a real scenario, you could add custom claims to the token
        // For example, you might include user roles or additional user-related information
        claims.put("roles", userDetails.getAuthorities());
        claims.put("customData", "some custom data");

        // Create a token with claims and user's username
        return createToken(claims, userDetails.getUsername());
    }

    // Create a JWT token with specified claims and subject
    private String createToken(Map<String, Object> claims, String subject) {
        long currentTimeMillis = System.currentTimeMillis();
        Date issuedAt = new Date(currentTimeMillis);
        Date expiration = new Date(currentTimeMillis + tokenValidityMinutes * 60 * 1000); // Convert minutes to milliseconds

        // Set issuedAt and expiration time for the token
        return Jwts.builder().setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact(); // Compact the token (convert to its final string representation)
    }
}
