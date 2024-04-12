package org.fullstack4.chap01.service;

import org.fullstack4.chap01.dao.MemberDAO;
import org.fullstack4.chap01.domain.MemberVO;
import org.fullstack4.chap01.dto.MemberDTO;
import org.fullstack4.chap01.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum MemberService {

    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService(){
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();
    }

    public boolean login(MemberVO vo){
        boolean login = false;
        try {
            login = dao.login(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }
}
