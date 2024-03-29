package kr.co.logintest.service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import kr.co.logintest.entity.Member;
import kr.co.logintest.entity.MemberProfile;
import kr.co.logintest.oAuth.OAuthAttributes;
import kr.co.logintest.repo.MemberRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
OAuth2 로그인 성공시 DB에 저장하는 작업
*/
@Slf4j
@Service
@RequiredArgsConstructor
public class OAuthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

	private final MemberRepo memberRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
	    OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
	    OAuth2User oAuth2User = delegate.loadUser(userRequest); // OAuth 서비스(kakao, google, naver)에서 가져온 유저 정보를 담고있음
	
	    String registrationId = userRequest.getClientRegistration()
	                                       .getRegistrationId(); // OAuth 서비스 이름(ex. kakao, naver, google)
	    String userNameAttributeName = userRequest.getClientRegistration()
	                                              .getProviderDetails()
	                                              .getUserInfoEndpoint()
	                                              .getUserNameAttributeName(); // OAuth 로그인 시 키(pk)가 되는 값
	    Map<String, Object> attributes = oAuth2User.getAttributes(); // OAuth 서비스의 유저 정보들
	    log.info("regId : " + registrationId);
	    log.info("userna : " + userNameAttributeName);
	    log.info("user: "+ oAuth2User);
	    MemberProfile memberProfile = OAuthAttributes.extract(registrationId, attributes); // registrationId에 따라 유저 정보를 통해 공통된 UserProfile 객체로 만들어 줌
	    memberProfile.setProvider(registrationId);
	    
	    Member member = saveOrUpdate(memberProfile);
	    log.info("user: "+ member);
	    Map<String, Object> customAttribute = customAttribute(attributes, userNameAttributeName, memberProfile, registrationId);
	
	    return new DefaultOAuth2User(
	            Collections.singleton(new SimpleGrantedAuthority("USER")),
	            customAttribute,
	            userNameAttributeName);
	
	}
	
	private Map<String, Object> customAttribute(Map<String, Object> attributes, String userNameAttributeName, MemberProfile memberProfile, String registrationId) {
	    Map<String, Object> customAttribute = new LinkedHashMap<>();
	    customAttribute.put(userNameAttributeName, attributes.get(userNameAttributeName));
	    customAttribute.put("provider", registrationId);
	    customAttribute.put("name", memberProfile.getName());
	    customAttribute.put("email", memberProfile.getEmail());
	    return customAttribute;
	
	}
	
	private Member saveOrUpdate(MemberProfile memberProfile) {
	
	    Member member = memberRepository.findByEmailAndProvider(memberProfile.getEmail(), memberProfile.getProvider())
	    		.map(m -> m.update(memberProfile.getName(), memberProfile.getEmail())) // OAuth 서비스 사이트에서 유저 정보 변경이 있을 수 있기 때문에 우리 DB에도 update
	            .orElse(memberProfile.toMember());
	    return memberRepository.save(member);
	}


}