package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.TeamMember;

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
        int i = this.getTeamIndex(team.name);
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
            if (name.equals(this.teams[i].name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    public void memberinsert(String name, String id) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                if (name.equals(arr[i][0].toLowerCase())) {
                    System.out.println("이미 등록된 회원입니다.");
                   
                } else if(arr[i][j] == null)
                       arr[i][j] = id;
                       
                }
            }
        }
    
    public void teaminsert(String name) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == null)
                arr[i][0] = name;
        }
    }
    
}






