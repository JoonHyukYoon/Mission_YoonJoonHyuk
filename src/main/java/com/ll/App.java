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

                int id = Integer.parseInt(a) -1;    // Integer에는 마이너스 정수는 들어갈수가 없다 그럼에도 -1을 넣는 이유는 예를 들어보자 내가 3번을 뽑고싶은데 ( 1 2 3 (3번을 뽑을려함)) -1을 안넣은상태에서 본다면 1 2 3 컴퓨터는 3번을 3번으로 안보고 2번으로 보기 때문에 -1을 넣어줘야 한다
                if (id >= 0 && id < bppList.size()){      // 그래서 Integer는 무조건 ID보다 같거나 작아야해서 -1을 넣어서 0을 맞추고 id < bppList.size 배열을 생각하면 내가 입력한 값이 리스트보다 크면 안되기때문에 size를 넣어서 id보다 크게 만들어야 한다 (예시 : 계란판(30알) 31번째 알 가져와 => 없음[에러])
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
                    String update = scanner.nextLine();     // scanner.nextLine(); 는 사용자 입력을 기다리고있다
                    selectedBpp.명언 = update;              // String update는 사용자가 입력하면 update라는 변수에 selectedBpp.명언 = update; update가 덮어씌우게 된다

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


