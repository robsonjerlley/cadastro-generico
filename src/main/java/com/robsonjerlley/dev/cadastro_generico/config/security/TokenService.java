package com.robsonjerlley.dev.cadastro_generico.config.security;

import com.robsonjerlley.dev.cadastro_generico.model.User;

public interface TokenService {
    String generateToken(User user);
    String validateToken(String token);

}
