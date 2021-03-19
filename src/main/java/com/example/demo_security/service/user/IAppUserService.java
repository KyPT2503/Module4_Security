package com.example.demo_security.service.user;

import com.example.demo_security.model.AppUser;
import com.example.demo_security.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAppUserService extends IGeneralService<AppUser>, UserDetailsService {
    AppUser getCurrentUser();
}
