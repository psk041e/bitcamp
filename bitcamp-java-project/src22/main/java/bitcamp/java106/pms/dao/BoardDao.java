package bitcamp.java106.pms.dao;

import java.util.LinkedList;

import bitcamp.java106.pms.domain.Board;

public class BoardDao extends AbstractDao<Board> {
    
    // 찾는법은 전부 다르기 때문에 직접 구현해주어야 한다.
    public int indexOf(Object key) { // 숫자로 넘어올 때는 Integer객체로 auto-boxing되어 넘어온다.
        int no = (Integer) key; // Integer ==> int : auto-unboxing
              // ((Integer) key).intValue();
              // 왼쪽의 no 변수가 int(primitive type)변수이기 때문에 자동으로 처리해주므로 주석처럼 하지 않아도 된다.
        for (int i = 0; i < collection.size(); i++) {
            Board originBoard = (Board) collection.get(i);
            if (originBoard.getNo() == no) {
                return i;
            }
        }
        return -1;
    }
}

// ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
// ver 19 - 우리가 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다.
// ver 18 - ArrayList를 이용하여 인스턴스(의 주소) 목록을 다룬다.
// ver 16 - Board 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.





