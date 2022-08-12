package com.miw.gildedrose.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * The class JwtUtil.
 *
 */
@Service
public class JwtUtil {

	private String SECRET_KEY = "secret";

	 
	/**
	 * Retrieve username from jwt token.
	 * 
	 * @param token
	 * @return
	 */
	public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

     
    /**
     * Retrieve expiration date from jwt token.
     * 
     * @param token
     * @return
     */
    public Date extractExpirationDate(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


    /**
     * Function to figure out the claims.
     * 
     * @param <T>
     * @param token
     * @param claimsResolver
     * @return
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    
    /**
     * For retrieving any information from token we will need the secret key.
     * 
     * @param token
     * @return
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }


    /**
     * Check if the token has expired.
     * 
     * @param token
     * @return
     */
    private Boolean isTokenExpired(String token) {
        return extractExpirationDate(token).before(new Date());
    }


    /**
     * Generate token for user.
     * When anybody auhtentiactes, creation of JWT out of the userdetails based on successful authentication token.
     * 
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    
    /**
     * Create jwt token based of userDetails.
     * 
     * @param claims Claims in the request.
     * @param subject person who already authenticated
     * @return String
     */
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

     
    /**
     * Validate token.
     * 
     * @param token
     * @param userDetails
     * @return
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
