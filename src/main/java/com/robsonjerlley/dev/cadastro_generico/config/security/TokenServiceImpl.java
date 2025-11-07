package com.robsonjerlley.dev.cadastro_generico.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.robsonjerlley.dev.cadastro_generico.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenServiceImpl implements TokenService {


    private final String secret;

    public TokenServiceImpl(@Value("${api.security.token.secret}")String secret) {
        this.secret = secret;
    }


    @Override
    public String generateToken(User user) {
        try {

            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("api-cadastro-generico")
                    .withSubject(user.getEmail())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }

    @Override
    public String validateToken(String token) {
       try{
           Algorithm algorithm = Algorithm.HMAC256(secret.getBytes(StandardCharsets.UTF_8));
           return JWT.require(algorithm)
                   .withIssuer("api-cadastro-generico")
                   .build()
                   .verify(token)
                   .getSubject();
       }catch (JWTVerificationException exception) {
           return "";
       }
    }

    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
