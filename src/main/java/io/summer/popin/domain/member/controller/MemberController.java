package io.summer.popin.domain.member.controller;

import io.summer.popin.domain.member.dto.MemberProfileResponseDTO;
import io.summer.popin.domain.member.dto.ProfileUpdateDTO;
import io.summer.popin.domain.member.dto.ProfileResponseDTO;
import io.summer.popin.domain.member.dto.SessionUserDTO;
import io.summer.popin.domain.member.service.MemberService;
import io.summer.popin.domain.place.dto.MyPlaceDTO;
import io.summer.popin.domain.place.service.PlaceService;
import io.summer.popin.global.dao.UrlMapper;
import io.summer.popin.global.dto.UrlResourceDTO;
import io.summer.popin.global.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@Controller
public class MemberController {

    private final MemberService memberService;
    private final PlaceService placeService;
    private final AwsS3Service awsS3Service;

        @GetMapping("/members")
        public String getMyProfile(@SessionAttribute(value = "loginMember", required = false) SessionUserDTO loginMember, Model model) {

            ProfileResponseDTO profile = memberService.findProfileByMemberNo(loginMember.getNo());
            String profileImgUrl = memberService.getProfileImageUrl(loginMember.getNo());

            log.info("PROFILE = {}", profile);
            model.addAttribute("profile", profile);
            model.addAttribute("profileImgUrl", profileImgUrl);
            return "html/my-profile";
        }

        @GetMapping("/members/{memberNo}")
        public String getMemberProfile(@PathVariable("memberNo") Long memberNo, Model model) {

            model.addAttribute("memberProfile", memberService.findMemberProfile(memberNo));
            model.addAttribute("profileImgUrl", memberService.getProfileImageUrl(memberNo));
            model.addAttribute("hostPlaces", placeService.getPlaces(memberNo));
            return "html/member-profile";
    }


        @GetMapping("/members/update/{memberNo}")  //프로필 수정 폼
        public String showEditProfileForm(@PathVariable("memberNo") Long memberNo, Model model) {

            ProfileResponseDTO profile = memberService.findProfileByMemberNo(memberNo);
            String profileImgUrl = memberService.getProfileImageUrl(memberNo);
            ProfileUpdateDTO profileUpdateDTO = memberService.getEditProfileFormData(memberNo);

            model.addAttribute("profile", profile);
            model.addAttribute("profileImgUrl", profileImgUrl);
            model.addAttribute("profileUpdateForm", profileUpdateDTO);
            return "html/profile-update";
        }

        @PostMapping("/members/update/{memberNo}")  //프로필 수정 요청
        public String updateProfile(@PathVariable("memberNo") Long memberNo, @ModelAttribute("profileUpdateForm") ProfileUpdateDTO profileUpdateDTO
                                                , @RequestParam("profileImg") List<MultipartFile> profileImg, UrlResourceDTO urlResourceDTO) {

            memberService.updateProfile(memberNo, profileUpdateDTO);
            log.info("profileImg = {}", profileImg.isEmpty());

            if (!"".equals(profileImg.get(0).getOriginalFilename())) {
                urlResourceDTO.setMemberNo(memberNo);
                urlResourceDTO.setKindCode(1);
                awsS3Service.updateProfileImage(profileImg, urlResourceDTO);
            }

            log.info("ProfileEditResponseDTO = {}", profileUpdateDTO);
            return "redirect:/members";
        }


}
