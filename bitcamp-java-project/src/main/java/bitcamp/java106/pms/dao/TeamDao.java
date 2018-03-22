package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;

public class TeamDao {
    Team[] teams = new Team[1000];
    int teamIndex = 0;
    
    public void insert(Team team) {
        team.no = teamIndex;
        this.teams[this.teamIndex++] = team;
    }
    
    public Team[] list() {
        Team[] arr = new Team[teamIndex];
        for (int i = 0; i < teamIndex; i++) 
            arr[i] = teams[i];
        return arr;
    }
    
    public Team get(int i) {
        if (i < 0 || i >= teamIndex)
            return null;
        return teams[i];
    }
    
    public void update(Team team) {
        teams[team.no] = team;
    }
    
    public void delete(int i) {
        teams[i] = null;
    }
}






