// 팀 관련 기능을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.util.Console;

public class BoardController {
    public static Scanner keyScan; // 외부에서 접근 해야 하는것만 공개한다.

    static Board[] boards = new Board[1000]; 
    static int boardIndex = 0;

    // * Low Couple
    public static void service(String menu, String index) {
        if (menu.equals("board/add")) {
            onBoardAdd();
        } else if (menu.equals("board/list")) {
            onBoardList();
        } else if (menu.equals("board/view")) {
            onBoardView(index);
        } else if (menu.equals("board/update")) {
            onBoardUpdate(index);
        } else if (menu.equals("board/delete")) {
            onBoardDelete(index);
        } else {    // team/remove 처럼 잘못된 명령어를 쓸수도 있다.
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    static int getBoardIndex(int index) { 
            if (index <= boardIndex - 1 ) {
                return index;
        }
        return -1; 
    }

    static void onBoardAdd() { 
        System.out.println("[게시글 등록]");
        Board board = new Board();
        
        System.out.print("제목? ");
        board.title = keyScan.nextLine();
    
        System.out.print("내용? ");
        board.content = keyScan.nextLine();
    
        System.out.print("등록일? ");
        board.registration = keyScan.nextLine();
    
        boards[boardIndex++] = board;
    }
    
    static void onBoardList() {
        System.out.println("[게시글 목록]");
        for (int i = 0; i < boardIndex; i++) {
            if (boards[i] == null) continue; 
            System.out.printf("%d, %s, %s\n", 
            i, boards[i].title, boards[i].registration );
        }
    }

    static void onBoardView(String index) {
        System.out.println("[게시글 조회]");
        if (index == null) {
            System.out.println("인덱스 값을 입력하시기 바랍니다.");
            return; 
        }
        int i = getBoardIndex(Integer.parseInt(index));

        if (i == -1) {
            System.out.println("해당 인덱스 값의 게시글이 없습니다.");
        } else {
            Board board = boards[i];
            System.out.printf("제목 : %s\n", board.title);
            System.out.printf("내용 : %s\n", board.content);
            System.out.printf("등록일 : %s\n", board.registration);
        }
    }

    static void onBoardUpdate(String index) {
        System.out.println("[게시글 변경]");
        if (index == null) {
            System.out.println("인덱스 값을 입력하시기 바랍니다.");
            return; 
        }

        int i = getBoardIndex(Integer.parseInt(index));

        if (i == -1) {
            System.out.println("해당 인덱스 값의 게시글이 없습니다.");
        } else {
            Board board = boards[i];
            Board updateBoard = new Board(); 
            System.out.printf("제목(%s)? ", board.title);
            updateBoard.title = keyScan.nextLine();
            System.out.printf("내용(%s)? ", board.content);
            updateBoard.content = keyScan.nextLine();
            boards[i] = updateBoard;

        }
    }

    static void onBoardDelete(String index) {
        System.out.println("[게시글 삭제]");
        if (index == null) {
            System.out.println("인덱스 값을 입력하시기 바랍니다.");
            return; 
        }
       int i = getBoardIndex(Integer.parseInt(index));

        if (i == -1) {
            System.out.println("해당 인덱스 값의 게시글이 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                boards[i] = null;
                System.out.println("삭제하였습니다.");
            }
        }
    }
}