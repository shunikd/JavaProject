package com.nstcommunity.cloud.sample.domain.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nstcommunity.cloud.sample.domain.repository.UserInfoRepository;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInforService {

	@Inject
	UserInfoRepository userInfoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public String getUserInfo(String userId) {
		return userInfoRepository.getUserName(userId);
	}

}
