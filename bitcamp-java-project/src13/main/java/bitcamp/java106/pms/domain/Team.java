package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Team {
    public String name;
    public String description;
    public int maxQty;
    public Date startDate;
    public Date endDate;
}

// ver13 - 등록일의 데이터 타입을 String 에서 Date로 변경