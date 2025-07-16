package com.ll;

import com.ll.article.ArticleController;
import com.ll.system.Systemcontroller;

public class App {
    ArticleController article_controller;
    Systemcontroller systemcontroller;

    App() {
        article_controller = new ArticleController();
        systemcontroller = new Systemcontroller();
    }


    public void run() {


        System.out.println("== 게시판 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = Container.getSc().nextLine().trim();

            Request request = new Request(command);

            if (command.equals("종료")) {
                systemcontroller.exit();
                break;
            } else if (command.equals("x")) {
                article_controller.write();
            } else if (command.equals("목록")) {
                article_controller.list();
            } else if (command.startsWith("삭제")) {
                article_controller.delete(request);
            } else if (command.startsWith("수정")) {
                article_controller.modify(request);
            }
        }
    }
}