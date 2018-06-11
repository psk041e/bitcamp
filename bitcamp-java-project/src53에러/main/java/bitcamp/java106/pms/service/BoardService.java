// 서비스 컴포넌트 - 게시물 관련 업무를 처리할 객체
package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Board;

public interface BoardService {
    // 서비스 컴포넌트에서 메서드명을 지을 때는
    // 업무 용어를 사용하라! (selectList같은것 쓰지 말아라!)
    /*public abstract => 필수이지만 생략 가능*/
    List<Board> list(int pageNo, int pageSize);
    // 나중에 구현체를 쉽게 바꾸기 위해서, 
    // 고객마다 처리하는 방법이 다를수 있기 때문에 인터페이스를 만든다.
    Board get(int no); // 상세정보를 가져온다. => getDetail
    int add(Board board);
    int update(Board board);
    int delete(int no);
}
