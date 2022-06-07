package com.oshop.service;


import java.util.List;
import java.util.Locale;

import javax.mail.MessagingException;

import com.oshop.dto.UserDTO;
import com.oshop.dto.user.Profile;
import com.oshop.dto.user.Register;
import com.oshop.entity.User;
import com.oshop.exception.UserAlreadyExistException;
import com.oshop.exception.UserNotFoundException;

public interface UserService {
	
	List<UserDTO> getAll();
	List<UserDTO> getAllIsEnabled();
	User getByEmail(String email);
	User getCurrentUser();
	boolean existsByEmail(String email);
	boolean existsByUsername(String username);
	boolean existsByPasswordAndToken(String username, String token);
	boolean existsByEmailAndPassword(String email, String password);
	boolean tokenValidation(String token);
	String verifyRegistrationWithToken(String verificationToken, Locale locale);
	void sendTokenResetPassword(String email) throws UserNotFoundException, MessagingException;
	void updatePasswordWithToken(String token, String newPassword);
	User register(Register user) throws UserAlreadyExistException, MessagingException;
	User changePassword(User user, String newPassword);
	User updateProfile(User user, Profile profile);
	UserDTO save(UserDTO userDTO);
	void delete(Integer userId);
	void updateStatus(Integer id, Boolean status);
}
