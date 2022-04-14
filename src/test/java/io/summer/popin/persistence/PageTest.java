package io.summer.popin.persistence;

import io.summer.popin.domain.search.dao.SearchMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PageTest {

    @Autowired
    SearchMapper searchMapper;

/*
    @Test
    public void pageTest(){
        log.info(String.valueOf(searchMapper.placeCount()));
    }
*/

}
