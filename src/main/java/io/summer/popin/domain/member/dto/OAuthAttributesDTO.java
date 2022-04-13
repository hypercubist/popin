package io.summer.popin.domain.member.dto;


import io.summer.popin.domain.model.MemberClass;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@ToString
@Getter
public class OAuthAttributesDTO {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String nickname;
    private String email;
    private Long id;


    @Builder
    public OAuthAttributesDTO(Map<String, Object> attributes, String nameAttributeKey, String nickname, String email, Long id) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.nickname = nickname;
        this.email = email;
        this.id = id;
    }

    public static OAuthAttributesDTO of(String registrationId, String userNameAttributeName ,Map<String, Object> attributes) {

        return ofKakao("id", attributes);
    }

    private static OAuthAttributesDTO ofKakao(String userNameAttributeName, Map<String, Object> attributes) {

        Map<String,Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");
        Map<String, Object> kakaoprofile = (Map<String, Object>) kakaoAccount.get("profile");
        Long kakaoId =  (Long)attributes.get("id");

        return OAuthAttributesDTO.builder()
                .nickname((String)kakaoprofile.get("nickname"))
                .email((String)kakaoAccount.get("email"))
                .id(kakaoId)
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    //OAuthAttributesDTO에서 entity생성시점은 처음 가입할때 => 기본 권한 guest로 주기
    public LoginMemberInfoDTO toEntity() {
        return LoginMemberInfoDTO.builder()
                .nickname(nickname)
                .id(id)
                .email(email)
                .memberClass(MemberClass.GUEST.name())
                .build();
    }


}
