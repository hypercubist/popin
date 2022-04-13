package io.summer.popin.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberClass {
    GUEST("ROLE_GUEST", "GUEST"), HOST("ROLE_HOST", "HOST"), ADMINISTRATOR("ROLE_ADMINISTRATOR", "ADMINISTRATOR");

    private final String key;
    private final String title;

}
