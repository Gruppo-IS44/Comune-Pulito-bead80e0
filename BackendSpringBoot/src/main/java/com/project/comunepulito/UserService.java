package com.project.comunepulito;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UtenteRepository userRepository;
    @Autowired
    private GestoreRepository gestoreRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Utente> user = userRepository.findByEmail(s);
        if (user.isPresent()){
            return user.get();
        }
        Optional<Gestore> gestore =gestoreRepository.findByEmail(s);
        if(gestore.isPresent()) {
        	return gestore.get();
        }
        throw new UsernameNotFoundException(String.format("Username[%s] not found"));
    }
}