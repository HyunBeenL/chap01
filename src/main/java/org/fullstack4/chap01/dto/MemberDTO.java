package org.fullstack4.chap01.dto;


import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor //컬럼에 없는 매개변수가 없는 기본생성자
@AllArgsConstructor
public class MemberDTO {
    private String user_name;
    private String user_id;
    private String pwd;
    private String addr1;
    private String addr2;
    private String birthday;
    private String job_code;
    private String mileage;
    private String user_state;
    private String regdate;
    private String leave_date;
    private String pwd_change_date;
}
