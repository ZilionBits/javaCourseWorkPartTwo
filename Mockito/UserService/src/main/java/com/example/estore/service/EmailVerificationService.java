package com.example.estore.service;

import com.example.estore.model.User;

public interface EmailVerificationService {
    void scheduleEmailConfirmation(User user);
}
