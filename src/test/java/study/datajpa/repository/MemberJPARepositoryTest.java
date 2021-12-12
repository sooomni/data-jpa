package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
//@Rollback(value = false)
class MemberJPARepositoryTest {
    @Autowired
    MemberJPARepository memberJPARepository;

    @Test
    public void testMember() {
        Member member = new Member("memberA");
        Member savedMember = memberJPARepository.save(member);
        Member findMember = memberJPARepository.find(savedMember.getId());

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUserName()).isEqualTo(member.getUserName());
    }
}