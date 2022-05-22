package io.summer.popin.persistence;

import io.summer.popin.domain.member.dao.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

   /* @Test
    public void testFindByNo(){
        log.info("TEST: MemberVO = {}", memberMapper.findProfileByMemberNo(1L));
    }*/


}
