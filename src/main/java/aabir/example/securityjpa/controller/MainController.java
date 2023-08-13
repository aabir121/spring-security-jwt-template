package aabir.example.securityjpa.controller;

import aabir.example.securityjpa.model.AuthenticationRequest;
import aabir.example.securityjpa.model.AuthenticationResponse;
import aabir.example.securityjpa.service.CustomUserDetailsService;
import aabir.example.securityjpa.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtTokenUtil;

    public MainController(AuthenticationManager authenticationManager,
                          CustomUserDetailsService userDetailsService,
                          JwtUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    // Endpoint for the home page
    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome to the home page</h1>");
    }

    // Endpoint for users
    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome, user!</h1>");
    }

    // Endpoint for administrators
    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome, admin!</h1>");
    }

    // Endpoint for user authentication
    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            // Authenticate user's credentials using the authentication manager
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException ex) {
            // Handle incorrect credentials
            throw new Exception("Incorrect username or password");
        }

        // Load user details from the userDetailsService
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

        // Generate a JWT token for the authenticated user
        String jwtToken = jwtTokenUtil.generateToken(userDetails);

        // Return the JWT token in the response
        return new AuthenticationResponse(jwtToken);
    }
}
