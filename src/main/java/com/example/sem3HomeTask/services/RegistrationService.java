package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private DataProcessingService dataProcessingService;

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {

        return dataProcessingService;
    }

    public void processRegistration(User user) {

        notificationService.notifyUser(user);
        dataProcessingService.addUserToList(user);
        notificationService.sendNotification("User " + user.getName() + " add to db");

    }

}
