// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.member;

import java.io.PrintWriter;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/member/add")
public class MemberAddController implements Controller {
    MemberDao memberDao;
    
    public MemberAddController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void service(ServerRequest request, ServerResponse response) {
        Member member = new Member();
        member.setId(request.getParameter("id"));
        member.setEmail(request.getParameter("email"));
        member.setPassword(request.getParameter("password"));
        
        memberDao.insert(member);
        
        PrintWriter out = response.getWriter();
        out.println("등록 성공!");
    }
}

