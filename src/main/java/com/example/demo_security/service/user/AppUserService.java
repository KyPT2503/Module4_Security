package com.example.demo_security.service.user;

import com.example.demo_security.model.AppUser;
import com.example.demo_security.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService implements IAppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser findById(Long id) {
        return appUserRepository.getOne(id);
    }

    @Override
    public void remove(Long id) {
        appUserRepository.delete(appUserRepository.getOne(id));
    }

    @Override
    public AppUser update(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser add(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.getByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(appUser.getRole());
        return new User(username, appUser.getPassword(), roles);
    }
}
