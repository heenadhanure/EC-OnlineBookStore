package com.nit.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nit.entity.UserRegister;
import com.nit.model.UserRequest;
import com.nit.model.UserRequestDto;

public interface UserRegisterService {

	public UserRegister  insertUserRegister(UserRequestDto userRequestDto);

	public UserRequest getUserRegisterDetails(Long  id);

	public UserRegister checkUserDetails(UserRequestDto userRequestDto);

	public UserRegister uploadMultiUserRegister(UserRequestDto userRequestDto, MultipartFile[] files);

	public List<UserRegister> getAllUsersRegisterDetails();

	
	

}
