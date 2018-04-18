package bitcamp.java106.pms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Task;

@Component
public class BoardDao extends AbstractDao<Board> {
    
    public BoardDao() throws Exception {
        load();
    }
    
    public void load() throws Exception {
        try ( 
            ObjectInputStream in = new ObjectInputStream(
                                   new BufferedInputStream(
                                   new FileInputStream("data/board.data")));
            ) {
                
                while (true) {
                    try {
                        // 게시물 데이터를 읽을 때 작업 번호가 가장 큰 것으로
                        // 기본 값을 설정한다.
                        Board board = (Board) in.readObject();
                        if (board.getNo() >= Board.count)
                            Board.count = board.getNo() + 1;
                        // 다음에 새로 추가할 게시물의 번호는 현재 읽은 게시물 번호 보다
                        // 1 큰 값이 되게 한다.
                        this.insert(board);
                    } catch (Exception e) {
                        break; // 데이터를 읽을 수 없으면 예외를 던진다.
                    }
                }
            //in.close(); 자동으로 하기 때문에 필요 없다.
            } 
    }
    
    public void save() throws Exception {
        try (
                ObjectOutputStream out = new ObjectOutputStream(
                                new BufferedOutputStream(
                                new FileOutputStream("data/board.data")));
                 ) {
            
            Iterator<Board> boards = this.list();
            
            while (boards.hasNext()) {
                out.writeObject(boards.next());
            }
        }
    }
    
    public int indexOf(Object key) {
        int no = (Integer) key; // Integer ==> int : auto-unboxing
        for (int i = 0; i < collection.size(); i++) {
            Board originBoard = collection.get(i);
            if (originBoard.getNo() == no) {
                return i;
            }
        }
        return -1;
    }
}

//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 이용하여 인스턴스(의 주소) 목록을 다룬다. 
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.





