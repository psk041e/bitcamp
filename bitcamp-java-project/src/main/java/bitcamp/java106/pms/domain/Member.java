package bitcamp.java106.pms.domain;

public class Member {
    private String id;
    private String email;
    private String password;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "Member [id=" + id + ", email=" + email + ", password=" + password + "]";
    }
    
    
}

//ver 17 - toString() 재정의.
//ver 16 - 캡슐화 적용. 겟터, 셋터 추가.