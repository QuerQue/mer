package com.rental.serviceImpl;

import com.rental.dao.UserStatusDao;
import com.rental.entity.UserStatus;
import com.rental.service.UserStatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStatusServiceImpl implements UserStatusService {

    @Autowired
    UserStatusDao statusDao;

    @Override
    public List<UserStatus> getUserStatuses() {
        return statusDao.getUserStatuses();
    }
}
