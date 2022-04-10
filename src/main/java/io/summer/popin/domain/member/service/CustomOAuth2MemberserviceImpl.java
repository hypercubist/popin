package io.summer.popin.domain.member.service;

import io.summer.popin.domain.member.dao.MemberMapper;
import io.summer.popin.domain.member.dto.LoginMemberInfoDTO;
import io.summer.popin.domain.member.dto.OAuthAttributesDTO;
import io.summer.popin.domain.member.dto.SessionUserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Optional;

//로그인 이후 가져온 사용자의 정보들을 기반으로 가입/정보 업데이트/세션 저장 처리 클래스
@Slf4j
@RequiredArgsConstructor
@Service
public class CustomOAuth2MemberserviceImpl implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final MemberMapper memberMapper;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest memberRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(memberRequest);

        String registrationId = memberRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = memberRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        log.info("userNameAttributeName = {}", userNameAttributeName);
        log.info("registrationId = {}", registrationId);

        OAuthAttributesDTO attributes = OAuthAttributesDTO.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());  //3

        LoginMemberInfoDTO loginMemberInfoDTO = saveOrUpdate(attributes);

        log.info("loginMemberInfoDTO = {}", loginMemberInfoDTO);

        httpSession.setAttribute("loginMemberInfoDTO", new SessionUserDTO(loginMemberInfoDTO));  //4

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(loginMemberInfoDTO.getMemberClass())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }


    private LoginMemberInfoDTO saveOrUpdate(@ModelAttribute OAuthAttributesDTO attributes) {

        log.info("ID IS HERE = {} ", attributes.getId());
      LoginMemberInfoDTO loginMemberInfoDTO = memberMapper.findMemberById(attributes.getId());

      LoginMemberInfoDTO infoDTO = Optional.ofNullable(loginMemberInfoDTO)
                                        .map(entity -> entity.update(attributes.getNickname(), attributes.getEmail()))
                                                .orElse(attributes.toEntity());


      if(loginMemberInfoDTO == null) {
          memberMapper.saveMember(infoDTO);
      }else {
          memberMapper.updateMember(infoDTO);
      }

        return memberMapper.findMemberById(attributes.getId());
    }

}
