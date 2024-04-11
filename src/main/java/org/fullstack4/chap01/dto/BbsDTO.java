package org.fullstack4.chap01.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@ToString
@NoArgsConstructor //컬럼에 없는 매개변수가 없는 기본생성자
@AllArgsConstructor
public class BbsDTO {
    private int idx;
    private String user_id;
    private String title;
    private String content;
    private String display_date;
    private LocalDate reg_date;
    private LocalDate modify_date;
    private int readcnt;


}
