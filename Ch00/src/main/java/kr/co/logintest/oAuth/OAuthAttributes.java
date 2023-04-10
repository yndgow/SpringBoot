package kr.co.logintest.oAuth;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import org.springframework.http.ResponseEntity;

import kr.co.logintest.entity.MemberProfile;

public enum OAuthAttributes {
    GOOGLE("google", (attributes) -> {
        MemberProfile memberProfile = new MemberProfile();
        memberProfile.setName((String) attributes.get("name"));
        memberProfile.setEmail((String) attributes.get("email"));
        memberProfile.setUid((String)attributes.get("sub"));
        return memberProfile;
    }),

    NAVER("naver", (attributes) -> {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
        System.out.println(response);
        MemberProfile memberProfile = new MemberProfile();
        
        memberProfile.setName((String) response.get("name"));
        memberProfile.setUid((String)response.get("id"));
        memberProfile.setEmail(((String) response.get("email")));
        return memberProfile;
    }),

    KAKAO("kakao", (attributes) -> {
        // kakao는 kakao_account에 유저정보가 있다. (email)
    	
    	MemberProfile memberProfile = new MemberProfile();
    	
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        long id = (long)attributes.get("id");
        memberProfile.setUid(Long.toString(id));
        
        // kakao_account안에 또 profile이라는 JSON객체가 있다. (nickname, profile_image)
        Map<String, Object> kakaoProfile = (Map<String, Object>)kakaoAccount.get("profile");

        
        memberProfile.setName((String) kakaoProfile.get("nickname"));
        memberProfile.setEmail((String) kakaoAccount.get("email"));
        return memberProfile;
    });

    private final String registrationId;
    private final Function<Map<String, Object>, MemberProfile> of;

    OAuthAttributes(String registrationId, Function<Map<String, Object>, MemberProfile> of) {
        this.registrationId = registrationId;
        this.of = of;
    }

    public static MemberProfile extract(String registrationId, Map<String, Object> attributes) {
        return Arrays.stream(values())
                .filter(provider -> registrationId.equals(provider.registrationId))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .of.apply(attributes);
    }
}
