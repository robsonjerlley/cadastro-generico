package com.robsonjerlley.dev.cadastro_generico.service.impl;

import com.robsonjerlley.dev.cadastro_generico.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public AuthorizationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado com o E-mail:" + email));
    }
}
