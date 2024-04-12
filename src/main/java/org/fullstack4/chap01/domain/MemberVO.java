package org.fullstack4.chap01.domain;


import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
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
