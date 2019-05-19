package com.rental.serviceImpl;

import com.rental.dao.UserRoleDao;
import com.rental.entity.UserRole;
import com.rental.service.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleDao userRoleDao;

    @Override
    public List<UserRole> getUserRoles() {
        return userRoleDao.getUserRoles();
    }
}
