package com.ll;

import com.ll.DB.DBConnection;
import com.ll.article.ArticleController;
import com.ll.system.Systemcontroller;

import java.util.List;
import java.util.Map;


public class App {
    ArticleController article_controller;
    Systemcontroller systemcontroller;

    App() {
        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";

        Container.getDBConnection().connect();


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
            } else if (command.equals("등록")) {
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