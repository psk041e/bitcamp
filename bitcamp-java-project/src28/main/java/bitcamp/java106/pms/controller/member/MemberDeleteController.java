// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.member;

import java.io.PrintWriter;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;
import bitcamp.java106.pms.util.Console;

@Component("/member/delete")
public class MemberDeleteController implements Controller {
    MemberDao memberDao;
    
    public MemberDeleteController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        
        Member member = memberDao.get(id);
        
        if (member == null) {
            out.println("해당 아이디의 회원이 없습니다.");
        } else {
                memberDao.delete(id);
                out.println("삭제하였습니다.");
            }
        }
    }
    
