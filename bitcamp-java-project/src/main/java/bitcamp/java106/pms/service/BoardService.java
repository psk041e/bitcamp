package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Board;

public interface BoardService {
    List<Board> list(int pageNo, int pageSize);
    Board get(int no);
    int add(Board board);
    int update(Board board);
    int delete(int no);
}

