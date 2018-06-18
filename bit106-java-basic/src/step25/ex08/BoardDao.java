package step25.ex08;

import java.util.List;

public interface BoardDao {
    List<Board> selectList();
    int insert(Board board);
}









