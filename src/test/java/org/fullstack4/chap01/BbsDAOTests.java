package org.fullstack4.chap01;

import lombok.Cleanup;
import org.fullstack4.chap01.dao.BbsDAO;
import org.fullstack4.chap01.dao.ConnectionUtil;
import org.fullstack4.chap01.domain.BbsVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BbsDAOTests {
    private BbsDAO dao;

    @BeforeEach //// 반드시 선실행되어야할 떄 필요한 어노테이션
    public void ready(){
        dao = new BbsDAO();

    }

    @Test
    public void testGetTime() throws Exception{
        System.out.println("BbsDAO.getTime() : "+dao.getTime());
    }

    @Test
    public void testGetTime2() throws Exception{
        System.out.println("BbsDAO.getTime2() : "+dao.getTime2());
    }

    @Test
    public void testRegist() throws Exception{

        BbsVO vo = BbsVO.builder()
                .user_id("test")
                .title("게시글 제목 테스트")
                .content("게시글 내용 테스트")
                .display_date(LocalDate.now().toString())
                .readcnt(0)
        .build();
        dao.regist(vo);
    }

    @Test
    public void testList() throws Exception{
        List<BbsVO> list = dao.list();
        list.forEach(vo->System.out.println(vo));


    }

    @Test

    public void testView() throws Exception{
        BbsVO view = dao.view(1);

    }


    @Test
    public void testModify() throws Exception{
        BbsVO vo = BbsVO.builder()
                .idx(1)
                .user_id("test")
                .title("게시글 제목 테스트")
                .content("게시글 내용 테스트")
                .display_date(LocalDate.now().toString())
                .readcnt(0)
                .build();
        dao.modify(vo);
    }

    @Test
    public void testDelete() throws Exception{
        int idx = 1;
        dao.delete(idx);
    }
}
