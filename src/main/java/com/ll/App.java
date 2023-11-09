package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 앱 ==");

        int abc = 0;

        List<Bpp> bppList = new ArrayList<>();


        while (true) {
            System.out.print("명령) ");

            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if ("종료".equals(cmd)) {
                break;
            }

            else if ("등록".equals(cmd)) {

                System.out.print("명언 : ");
                String num1 = scanner.nextLine();

                System.out.print("작가 : ");
                String num2 = scanner.nextLine();

                abc++;
                Bpp bpp = new Bpp(abc, num1, num2);
                bppList.add(bpp);

                System.out.printf("%s 번 명언이 등록되었습니다. \n", abc);
                System.out.println("명언 : " + num1);
                System.out.println("작가 : " + num2);
            }
            else if ("목록".equals(cmd)){
                System.out.println("번호 / 작가 / 명언 ");
                System.out.println("-------------------------------------");
                for (int i = 0; i < bppList.size(); i++) {
                    System.out.printf("%d / %s / %s \n", bppList.get(i).번호, bppList.get(i).작가, bppList.get(i).명언);
                }

            }
            else if ("삭제".equals(cmd)){
                System.out.print("id : ");
                String a = scanner.nextLine();

                int id = Integer.parseInt(a) - 1;

                if (id >= 0 && id < bppList.size()){
                    Bpp bpp = bppList.get(id);
                    bppList.remove(bpp);
                    System.out.printf("%s번 명언이 삭제되었습니다. \n", a);
                }
                else {
                    System.out.printf("%s번 명언은 존재하지 않습니다. \n", a);
                }
            }
            else if ("수정".equals(cmd)){
                System.out.print("id : ");
                String a = scanner.nextLine();

                int id = Integer.parseInt(a) - 1;

                if (id >= 0 && id < bppList.size()){
                    Bpp selectedBpp = bppList.get(id);

                    System.out.println("명언(기존) : " + selectedBpp.명언);
                    System.out.print("명언 : ");
                    String update = scanner.nextLine();
                    selectedBpp.명언 = update;

                    System.out.println("작가(기존) : " + selectedBpp.작가);
                    System.out.print("작가 : ");
                    String update2 = scanner.nextLine();
                    selectedBpp.작가 = update2;

                    System.out.printf("%s번 명언이 수정되었습니다.\n", a);


                }

            }
        }
    }
}