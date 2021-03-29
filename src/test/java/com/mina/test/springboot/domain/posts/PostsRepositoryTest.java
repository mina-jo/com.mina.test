package com.mina.test.springboot.domain.posts;

import com.mina.test.domain.posts.Posts;
import com.mina.test.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    //JUnit 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
    //배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용
    //여러 테스트가 동시에 수행되면 테스트용 데이터베이스인 H2에 데이터가 그대로 남아 있어 다음 테스트 실행 테스트 실패할 수 있음
    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder().title(title)
                                            .content(content)
                                            .author("mina930715@gmail.com")
                                            .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        // 테스트 검증 랑비르러리의 검증 메소드
        //검증하고 싶은 대상을 메소드 인자로 받음
        //메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용
        //isEqualTo : assertj 의 동등 비교 메소드,  에 있는 값과  비교해서 같을 때만 성공
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
