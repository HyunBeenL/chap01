package org.fullstack4.chap01.dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.chap01.domain.BbsVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Log4j2
public class BbsDAO {

    public String getTime(){
        String now = null;
        try(
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement("select now()");
                ResultSet rs = preparedStatement.executeQuery();
                ){
            rs.next();
            now = rs.getString(1);
        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
        return now;

    }

    public String getTime2() throws Exception{
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = conn.prepareStatement("select now()");
        @Cleanup ResultSet rs = preparedStatement.executeQuery();

        rs.next();
        String now = rs.getString(1);
        return now;

    }

    public int regist(BbsVO vo) throws Exception{
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO tbl_bbs");
        sb.append(" (user_id, title, content, display_date, read_cnt, reg_date) ");
        sb.append(" VALUES( ?, ?, ?, ?, ?, now())");

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sb.toString());
        pstmt.setString(1, vo.getUser_id());
        pstmt.setString(2, vo.getTitle());
        pstmt.setString(3, vo.getContent());
        pstmt.setString(4, vo.getDisplay_date());
        pstmt.setInt(5, vo.getReadcnt());

        int result = pstmt.executeUpdate();
        return result;

    }

    public List<BbsVO> list() throws Exception{
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT idx, user_id, title, content, display_date, read_cnt,reg_date");
        sb.append(" FROM tbl_bbs ");
        sb.append(" ORDER BY idx DESC");

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sb.toString());
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<BbsVO> bbsList = new ArrayList<>();
        while(rs.next()){

            BbsVO vo = BbsVO.builder()
                    .idx(rs.getInt("idx"))
                    .user_id(rs.getString("user_id"))
                    .title(rs.getString("title"))
                    .content(rs.getString("content"))
                    .display_date(rs.getString("display_date"))
                    .readcnt(rs.getInt("read_cnt"))
                    .build();

            bbsList.add(vo);
        }

        return bbsList;
    }

    public BbsVO view(int idx) throws Exception{
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT idx, user_id, title, content, display_date, read_cnt,reg_date");
        sb.append(" FROM tbl_bbs ");
        sb.append(" WHERE idx = ? ");

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sb.toString());
        pstmt.setInt(1,idx);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();

        BbsVO vo = BbsVO.builder()
        .idx(rs.getInt("idx"))
                .user_id(rs.getString("user_id"))
                .title(rs.getString("title"))
                .content(rs.getString("content"))
                .display_date(rs.getString("display_date"))
                .readcnt(rs.getInt("read_cnt"))
                .reg_date(rs.getDate("reg_date").toLocalDate())
                .build();

        return vo;
    }

    public int modify(BbsVO vo) throws Exception{
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE tbl_bbs SET");
        sb.append(" user_id=? ");
        sb.append(" , title = ? ");
        sb.append(" , content = ? ");
        sb.append(" , display_date = ? ");
        sb.append(" , read_cnt = ? ");
        sb.append(" , modify_date = now() ");
        sb.append(" WHERE idx  = ? ");

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sb.toString());
        pstmt.setString(1, vo.getUser_id());
        pstmt.setString(2, vo.getTitle());
        pstmt.setString(3, vo.getContent());
        pstmt.setString(4, vo.getDisplay_date());
        pstmt.setInt(5, vo.getReadcnt());
        pstmt.setInt(6, vo.getIdx());
        int result = pstmt.executeUpdate();

        System.out.println("=================================");
        System.out.println("BbsDAO >> modify(");
        System.out.println("=================================");

        return result;
    }

    public int delete(int idx) throws Exception{
        String sql = "DELETE FROM tbl_bbs WHERE idx = ? ";


        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,idx);
        int result = pstmt.executeUpdate();

        log.info("=================================");
        log.info("BbsDAO >>  delete(");
        log.info("=================================");
        
        return result;

    }

}
