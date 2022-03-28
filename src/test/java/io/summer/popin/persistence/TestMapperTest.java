package io.summer.popin.persistence;

import io.summer.popin.global.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class TestMapperTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void testGetTime(){
        log.info("TEST: SYSDATE = {}", testMapper.getTime());
    }

    @Test
    public void testGetPlaceKind(){
        log.info("TEST: PLACE-KIND NO.1 = {}", testMapper.getPlaceKind());
    }
}
