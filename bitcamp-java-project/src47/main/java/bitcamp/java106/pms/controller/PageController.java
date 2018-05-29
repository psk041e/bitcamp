package bitcamp.java106.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PageController {
    String service( // viewUrl을 리턴하도록 String으로 바꿈
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception;
}
