package org.fullstack4.chap01.dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.chap01.domain.MemberVO;
import org.fullstack4.chap01.dto.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Log4j2
public class MemberDAO {

    public boolean login(MemberVO vo) throws Exception {
        boolean login = false;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT user_id, pwd FROM tbl_member WHERE user_id=?");

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sb.toString());
        pstmt.setString(1,vo.getUser_id());
        ResultSet rs = pstmt.executeQuery();

        rs.next();
        if(rs.getString("pwd").equals(vo.getPwd())){
            return true;
        }
        else{
            return false;
        }


    }
}
