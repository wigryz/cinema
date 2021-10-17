package com.it.cinemabackend.auth.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Verification;
import com.it.cinemabackend.auth.domain.model.User;
import java.util.Date;

public class JwtUtils {

    private static final String JWT_SECRET = "ajshdb2t348iuhg3q47y74hap";
    private static final String JWT_ISSUER = "cinema-backend";
    private static final String AUTHENTICATION = "AUTHENTICATION";
    private static final String ACTIVATION = "ACTIVATION";
    private static final Verification JWT_VERIFIER =
        JWT.require(Algorithm.HMAC256(JWT_SECRET)).withIssuer(JWT_ISSUER);

    private JwtUtils() {}

    public static String generateJWT(User user) {
        return JWT.create()
            .withSubject(user.getUsername())
            .withIssuer(JWT_ISSUER)
            .withClaim("TYPE", AUTHENTICATION)
            .withIssuedAt(new Date())
            .withExpiresAt(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)) //one day
            .sign(Algorithm.HMAC256(JWT_SECRET));
    }

    public static String generateActivationToken(String username) {
        return JWT.create()
            .withSubject(username)
            .withIssuer(JWT_ISSUER)
            .withClaim("TYPE", ACTIVATION)
            .withIssuedAt(new Date())
            .withExpiresAt(new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000)) //month
            .sign(Algorithm.HMAC256(JWT_SECRET));
    }

    public static String getUsername(String token) throws JWTDecodeException {
        return JWT.decode(token).getSubject();
    }

    public static boolean validateJWT(String token) {
        try {
            JWT_VERIFIER.withClaim("TYPE", AUTHENTICATION).build().verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }

    public static boolean validateActivationToken(String token) {
        try {
            JWT_VERIFIER.withClaim("TYPE", ACTIVATION).build().verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }
}
