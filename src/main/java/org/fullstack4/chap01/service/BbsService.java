package org.fullstack4.chap01.service;

import org.fullstack4.chap01.dao.BbsDAO;
import org.fullstack4.chap01.domain.BbsVO;
import org.fullstack4.chap01.dto.BbsDTO;
import org.fullstack4.chap01.util.MapperUtil;
import org.modelmapper.ModelMapper;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum BbsService {

    INSTANCE;

    private BbsDAO dao;
    private ModelMapper modelMapper;

    BbsService(){
        dao = new BbsDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();
    }
    public List<BbsDTO> bbsList() throws Exception {
//        List<BbsDTO> bbsDTOS = IntStream.range(0,10).mapToObj(i->{
//            BbsDTO dto = new BbsDTO();
//            dto.setIdx(i);
//            dto.setUser_id("Web User..." +i);
//            dto.setTitle("Bbs Title... "+ i);
//            dto.setContent("Bbs Content..." + i);
//            dto.setDisplay_date(LocalDate.now().toString());
//            dto.setReadcnt(0);
//
//            return dto;
//        }).collect(Collectors.toList());

        List<BbsVO> bbsVoList = dao.list();

        List<BbsDTO> bbsDTOList = bbsVoList.stream()
                .map(vo->modelMapper.map(vo, BbsDTO.class))
                .collect(Collectors.toList());

        return bbsDTOList;
    }

    public BbsDTO view(int idx) throws Exception {
        BbsDTO dto = new BbsDTO();
//        dto.setIdx(idx);
//        dto.setUser_id("Web User");
//        dto.setTitle("Bbs Title... ");
//        dto.setContent("Bbs Content...");
//        dto.setDisplay_date(LocalDate.now().toString());
//        dto.setReadcnt(0);

        BbsVO bbsVo = dao.view(idx);
        BbsDTO bbsDTO = modelMapper.map(bbsVo, BbsDTO.class);
        return bbsDTO;


    }

    public int testRegist(BbsVO vo) throws Exception{

        BbsDAO dao = new BbsDAO();
        vo = BbsVO.builder()
                .user_id("test")
                .title("게시글 제목 테스트")
                .content("게시글 내용 테스트")
                .display_date(LocalDate.now().toString())
                .readcnt(0)
                .build();
        int result = dao.regist(vo);
        return result;
    }

    public int regist(BbsDTO bbsDTO) throws Exception{
//        BbsDAO dao = new BbsDAO();

        BbsVO bbsVO = modelMapper.map(bbsDTO, BbsVO.class);

        int result = dao.regist(bbsVO);
        return result;
    }

    public int modify(BbsDTO bbsDTO) throws Exception{
//        BbsDAO dao = new BbsDAO();

        BbsVO bbsVO = modelMapper.map(bbsDTO, BbsVO.class);

        int result = dao.modify(bbsVO);
        return result;
    }
}
