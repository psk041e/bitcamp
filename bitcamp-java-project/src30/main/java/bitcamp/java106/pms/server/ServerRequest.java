// 역할: 서버쪽의 요청 정보를 다룬다.
package bitcamp.java106.pms.server;

import java.util.HashMap;
import java.util.Map;

public class ServerRequest {
    
    protected String path;
    protected HashMap<String,String> paramMap = new HashMap<>(); // 파라미터의 key값,value값 저장 
    
    public ServerRequest(String requestLine) {
        // requestLine의 예) /board/add?title=aaa&content=bbb
       
        String[] arr = requestLine.split("\\?"); 
        // ?, \?는 정규표현식에서 다른 의미가 있기 때문에 ?를 사용할 때는 \\?라고 표시해준다. 
        
        this.path = arr[0]; // 예) /board/add
        if (arr.length > 1) {
            toParamMap(arr[1]);
        }
    }
    
    private void toParamMap(String queryString) {
        // queryString 예) title=aaa&content=bbb
        // 데이터는 key 와 value로 분리하여 맵에 저장한다.
        String[] entryArr = queryString.split("&");

        for (String entry : entryArr) {
            String[] keyValue = entry.split("=");
            this.paramMap.put(keyValue[0], keyValue[1]);
        }
    }
    
    public String getServerPath() {
        return this.path;
    }
    
    public String getParameter(String name) {
        return paramMap.get(name);
    }
}




