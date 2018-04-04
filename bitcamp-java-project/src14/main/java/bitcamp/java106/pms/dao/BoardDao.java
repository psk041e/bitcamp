package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Board;

public class BoardDao {
    Board[] boards = new Board[1000];
    int boardIndex = 0;
    
    public void insert(Board board) {
        board.no = boardIndex; // board.no는 배열개수와 같다.
        this.boards[this.boardIndex++] = board;
    }
    
    public Board[] list() {
        Board[] arr = new Board[boardIndex];
        for (int i = 0; i < boardIndex; i++) 
            arr[i] = boards[i];
        return arr;
    }
    
    public Board get(int i) {
        if (i < 0 || i >= boardIndex)
            return null;
        return boards[i];
    }
    
    public void update(Board board) {
        boards[board.no] = board;
    }
    
    public void delete(int i) {
        // board는 인덱스 값으로 해당 배열의 값을 삭제하는데
        // 인덱스값은 존재여부를 확인하지 않아도 되므로 바로 null을 넣어준다.
        // -> 어차피 1000중 아무 수를 넣어도 원래 들어가 있는 값이
        //    null이기 때문에 괜찮다.
        boards[i] = null;
    }
}

// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.





