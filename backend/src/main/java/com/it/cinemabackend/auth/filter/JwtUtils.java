package com.it.cinemabackend.auth.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.it.cinemabackend.auth.domain.model.User;
import java.util.Date;

public class JwtUtils {

    private static final String JWT_SECRET = "ajshdb2t348iuhg3q47y74hap";
    private static final String JWT_ISSUER = "cinema-backend";
    private static final JWTVerifier JWT_VERIFIER =
        JWT.require(Algorithm.HMAC256(JWT_SECRET)).withIssuer(JWT_ISSUER).build();

    public static String generateJWT(User user) {
        return JWT.create()
            .withSubject(user.getUsername())
            .withIssuer(JWT_ISSUER)
            .withIssuedAt(new Date())
            .withExpiresAt(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))
            .sign(Algorithm.HMAC256(JWT_SECRET));
    }

    public static String getUsername(String token) throws JWTDecodeException {
        return JWT.decode(token).getSubject();
    }

    public static boolean validate(String token) {
        try {
            JWT_VERIFIER.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }
}
