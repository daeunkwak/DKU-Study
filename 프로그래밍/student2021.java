//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class student2021 {
    static int STUDENT_NUMBER = 10;
    static int ITEM_NUMBER = 10;
    int[][] records;
    String[] students;
    String[] items;
    int noStudents;
    int noItems;
    String name;
    String item;
    String DATA_PATH;
    String DATA_FILE_NAME;

    // 생성자 -> this로 값 초기화
    public student2021() {
        this.records = new int[STUDENT_NUMBER][ITEM_NUMBER];
        this.students = new String[STUDENT_NUMBER];
        this.items = new String[ITEM_NUMBER];
        this.noStudents = 0;
        this.noItems = 0;
        this.name = null;
        this.item = null;
        this.DATA_PATH = null;
        this.DATA_FILE_NAME = null;
    }

    public static void main(String[] args) throws IOException {
        student2021 stu = new student2021();   //student2021 클래스 객체 생성
        Scanner sc = new Scanner(System.in);   //Scanner 객체 생성
        stu.LoadSettings("./settings.ini");
        stu.LoadData(stu.DATA_PATH + stu.DATA_FILE_NAME);

        for(int choice = selectChoice(sc); choice != 0; choice = selectChoice(sc)) {
            switch(choice) {
                case 1:
                    printData(stu.students, stu.items, stu.records, stu.noStudents, stu.noItems);
                    break;
                case 2:
                    System.out.println("추가할 학생 이름 : ");
                    stu.name = sc.next();
                    addStudent(stu.name, stu.students, stu.items, stu.records, stu.noStudents, stu.noItems, sc);
                    ++stu.noStudents;
                    break;
                case 3:
                    System.out.println("추가할 평가 항목 이름 : ");
                    stu.item = sc.next();
                    addItem(stu.item, stu.students, stu.items, stu.records, stu.noStudents, stu.noItems, sc);
                    ++stu.noItems;
                    break;
                case 4:
                    System.out.println("검색할 학생 이름 : ");
                    stu.name = sc.next();
                    System.out.println("검색할 항목 이름 : ");
                    stu.item = sc.next();
                    search(stu.name, stu.item, stu.students, stu.items, stu.records, sc);
                    break;
                case 5:
                    System.out.println("성적을 수정할 학생의 이름 : ");
                    stu.name = sc.next();
                    System.out.println("수정할 평가 항목 이름 : ");
                    stu.item = sc.next();
                    edit(stu.name, stu.item, stu.students, stu.items, stu.records, sc);
                    break;
                case 6:
                    stu.SaveSettings("./settings.ini");
                    stu.SaveData(stu.DATA_PATH + stu.DATA_FILE_NAME);
                    break;
                case 7:
                    stu.settings(sc);
            }
        }

        sc.close();
    }

    public static int selectChoice(Scanner sc) {
        System.out.println("\n성적 관리 프로그램입니다.");
        System.out.println("1 : 전체 학생의 성적을 화면에 출력하기");
        System.out.println("2 : 학생 추가하기");
        System.out.println("3 : 평가 항목 추가하기");
        System.out.println("4 : 학생 성적 조회하기");
        System.out.println("5 : 학생 성적 수정하기");
        System.out.println("6 : 저장하기");
        System.out.println("7 : 환경설정");
        System.out.println("0 : 종료하기");
        System.out.println("번호를 입력하세요 >> ");
        int n = Integer.parseInt(sc.next());
        System.out.println();
        return n;
    }

    public static int selectSettingsChoice(Scanner sc) {
        System.out.println("\n환경설정 메뉴");
        System.out.println("1 : 데이터 파일 저장 위치 변경");
        System.out.println("2 : 데이터 파일 이름 변경.");
        System.out.println("0 : 돌아가기");
        System.out.println("번호를 입력하세요>> ");
        int n = Integer.parseInt(sc.next());
        System.out.println();
        return n;
    }

    public static void printData(String[] s, String[] it, int[][] r, int nSt, int nIt) {
        System.out.println("\n수강 과목 성적은 다음과 같습니다.");
        System.out.println("    ");

        int i;
        for(i = 0; i < nIt; ++i) {
            System.out.printf("%7s", it[i]);
        }

        System.out.println();

        for(i = 0; i < nSt; ++i) {
            System.out.printf("%s", s[i]);

            for(int j = 0; j < nIt; ++j) {
                System.out.printf("%7d", r[i][j]);
                System.out.println();
            }
        }

    }

    public static void addStudent(String sname, String[] st, String[] it, int[][] r, int nSt, int nIt, Scanner sc) {
        System.out.println("각 평가항목에 대한 점수를 입력하세요.");
        st[nSt] = sname;

        for(int j = 0; j < nIt; ++j) {
            System.out.print(it[j] + " : ");
            r[nSt][j] = Integer.parseInt(sc.next());
        }

    }

    public static void addItem(String iname, String[] st, String[] it, int[][] r, int nSt, int nIt, Scanner sc) {
        System.out.println("각 학생에 대한 점수를 입력하세요.");
        it[nIt] = iname;

        for(int i = 0; i < nSt; ++i) {
            System.out.print(st[i] + " : ");
            r[i][nIt] = Integer.parseInt(sc.next());
        }

    }

    public static void search(String sname, String iname, String[] st, String[] it, int[][] r, Scanner sc) {
        int col = SearchStringArray(st, sname);
        int row = SearchStringArray(it, iname);
        if (col != -1 && row != -1) {
            System.out.println(st[col] + "학생의" + it[row] + "은" + r[col][row] + "이다.");
        } else {
            System.out.println("잘못된 입력입니다.");
        }

    }

    public static int SearchStringArray(String[] arr, String str) {
        return IntStream.range(0, arr.length).filter((i) -> {
            return str.equals(arr[i]);
        }).findFirst().orElse(-1);
    }

    // **************
    public static void edit(String sname, String iname, String[] st, String[] it, int[][] r, Scanner sc) {
        int col = SearchStringArray(st, sname);
        if (col != -1) {
            int row = SearchStringArray(it, iname);
            if (row != -1) {
                System.out.println("점수를 입력하세요 : ");
                r[col][row] = Integer.parseInt(sc.next());
            } else {
                System.out.println("입력한 평가 항목을 찾을 수 없습니다.");
            }
        } else {
            System.out.println("입력한 학생 이름을 찾을 수 없습니다.");
        }

    }

    public void settings(Scanner sc) {
        for(int choice = selectSettingsChoice(sc); choice != 0; choice = selectSettingsChoice(sc)) {
            switch(choice) {
                case 1:
                    System.out.println("데이터 파일 경로 : ");
                    this.DATA_PATH = sc.next();
                    break;
                case 2:
                    System.out.println("데이터 파일 이름 : ");
                    this.DATA_FILE_NAME = sc.next();
            }
        }

    }

    public void SaveSettings(String file_path) throws IOException {
        PrintWriter pw = new PrintWriter(file_path);
        pw.println(this.noStudents + "\r\n" + this.noItems + "\r\n" + this.DATA_PATH + "\r\n" + this.DATA_FILE_NAME);
        pw.close();
    }

    public void SaveData(String file_path) throws IOException {
        PrintWriter pw = new PrintWriter(file_path);
        StringBuilder data = new StringBuilder();

        int i;
        for(i = 0; i < this.noStudents; ++i) {
            data.append(this.students[i]).append("  ");
        }

        pw.println(data);
        data = new StringBuilder();

        for(i = 0; i < this.noItems; ++i) {
            data.append(this.items[i]).append(" ");
        }

        pw.println(data);
        data = new StringBuilder();

        for(i = 0; i < this.noStudents; ++i) {
            for(int j = 0; j < this.noItems; ++j) {
                data.append(this.records[i][j]).append("  ");
            }
        }

        pw.println(data);
        pw.close();
    }

    public void LoadSettings(String file_path) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            this.noStudents = Integer.parseInt(br.readLine());
            this.noItems = Integer.parseInt(br.readLine());
            this.DATA_PATH = br.readLine();
            this.DATA_FILE_NAME = br.readLine();
            br.close();
        } catch (FileNotFoundException var3) {
            System.out.println("설정 파일을 발견할 수 없습니다.\n");
            System.out.println("설정 파일이 없는 경우 계속 진행하십시오. \n");
            System.out.println("설정 파일은 프로그램과 동일한 위치에 있어야 합니다.");
        }

    }

    public void LoadData(String file_path) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            String name = br.readLine();
            String item = br.readLine();
            String strRec = br.readLine();
            Scanner inputSt = new Scanner(name);
            Scanner inputIt = new Scanner(item);
            Scanner inputRec = new Scanner(strRec);

            int i;
            for(i = 0; i < this.noStudents; ++i) {
                this.students[i] = inputSt.next();

                for(int j = 0; j < this.noItems; ++j) {
                    this.records[i][j] = inputRec.nextInt();
                }
            }

            for(i = 0; i < this.noItems; ++i) {
                this.items[i] = inputIt.next();
            }

            inputSt.close();
            inputIt.close();
            inputRec.close();
            br.close();
        } catch (FileNotFoundException var11) {
            System.out.print("데이터 파일을 발견할 수 없습니다.\n");
            System.out.print("데이터 파일을 찾을 수 없는 경우 설정 파일을 삭제하고 실행하십시오.");
        }

    }
}
