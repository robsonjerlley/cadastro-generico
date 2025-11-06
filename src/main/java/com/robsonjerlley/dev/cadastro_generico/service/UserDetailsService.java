package com.robsonjerlley.dev.cadastro_generico.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {

    UserDetails loadUserByUsername(String email);


}
