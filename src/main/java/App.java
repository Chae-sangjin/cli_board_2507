import article.Article;
import article.article_controller;
import system.systemcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;
    article_controller article_controller;
    systemcontroller systemcontroller;

    App(Scanner sc) {
        this.sc = sc;
        article_controller = new article_controller(sc);
        systemcontroller = new systemcontroller();
    }


    public void run() {


        System.out.println("== 게시판 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();

            if (command.equals("종료")) {
                systemcontroller.exit();
                break;
            } else if (command.equals("등록")) {
                article_controller.write();
            } else if (command.equals("목록")) {
                article_controller.list();
            } else if (command.startsWith("삭제")) {
                article_controller.delete(command);
            } else if (command.startsWith("수정")) {
                article_controller.modify(command);
            }
        }
    }
}