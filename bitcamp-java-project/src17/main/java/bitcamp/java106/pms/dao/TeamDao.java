package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;

public class TeamDao {
    Team[] teams = new Team[1000];
    int teamIndex = 0;
    String[][] arr = new String[1000][1000];
    int arrIndex = 0;
    
    public void insert(Team team) {
        // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
        this.teams[this.teamIndex++] = team;
    }
    
    public Team[] list() {
        // team배열의 길이만큼 새로운 배열 arr에 집어넣어서 리턴시킨다.
        Team[] arr = new Team[this.teamIndex];
        for (int i = 0; i < this.teamIndex; i++) 
            arr[i] = this.teams[i];
        return arr;
    }
    
    public Team get(String name) {
        int i = this.getTeamIndex(name);
        if (i == -1) 
            return null;
        return teams[i];
    }
    
    public void update(Team team) {
        int i = this.getTeamIndex(team.getName());
        if (i != -1) 
            teams[i] = team;
    }
    
    public void delete(String name) {
        int i = this.getTeamIndex(name);
        if (i != -1)
            teams[i] = null;
    }
    
    private int getTeamIndex(String name) {
        for (int i = 0; i < this.teamIndex; i++) {
            if (this.teams[i] == null) continue;
            if (name.equals(this.teams[i].getName().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
}

//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - TeamController로부터 데이터 관리 기능을 분리하여 TeamDao 생성.
