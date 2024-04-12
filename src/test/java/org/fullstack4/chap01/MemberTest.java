package org.fullstack4.chap01;


import org.fullstack4.chap01.dao.MemberDAO;
import org.fullstack4.chap01.domain.MemberVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberTest {
    private MemberDAO dao;

    @BeforeEach //// 반드시 선실행되어야할 떄 필요한 어노테이션
    public void ready(){
        dao = new MemberDAO();

    }
    @Test
    public void login() throws Exception {
        MemberVO vo = MemberVO.builder()
                        .user_id("leehv1234")
                        .pwd("1234")
                        .build();
        boolean login =dao.login(vo);
        System.out.println(login);
    }
}
