package jdbc;
import java.util.Scanner;

public class StudentManager {

    public static void main(String[] args) {
        while (true) {
            Scanner my = new Scanner(System.in);
            System.out.println("========================================学籍管理系统========================================");
            System.out.println("请输入你的操作：1，增加学生信息。2，删除学生信息。3，修改学生信息。4，分页查询所有学生信息。5，分页班级信息查询。6.退出系统。7.");
            System.out.println("ps:更新学生信息会同步更新班级信息");
            int choice = my.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("请输入学生信息[id(8位)   姓名   性别(男/女)   年级]");
                    Scanner my2 = new Scanner(System.in);
                    String information1 = my2.nextLine();
                    System.out.println(Function.Insert(information1));
                    break;
                }
                case 2: {
                    System.out.println("请输入要删除的学生id(8位)：");
                    Scanner my3 = new Scanner(System.in);
                    String information2 = my3.nextLine();
                    System.out.println(Function.Delete(information2));
                    break;
                }
                case 3:{
                    System.out.println("请输入要修改的学生id(8位)：");
                    Scanner my4 = new Scanner(System.in);
                    String information3 = my4.nextLine();
                    System.out.println("请输入修改后的学生信息：姓名  性别(男/女)  年级");
                    String information4 = my4.nextLine();
                    System.out.println(Function.Update(information3,information4));
                    break;
                }
                case 4:{
                    Scanner my5 = new Scanner(System.in);
                    System.out.println("请输入查询的页数：");
                    int start = my5.nextInt();
                    System.out.println("请输入本页数据个数：");
                    int count = my5.nextInt();
                    System.out.println("   id     name  sex grade");
                    Function.Select(start,count);
                    break;
                }
                case 5:{
                    Scanner my6 = new Scanner(System.in);
                    System.out.println("请输入查询的页数：");
                    int start = my6.nextInt();
                    System.out.println("请输入本页数据个数：");
                    int count = my6.nextInt();
                    System.out.println("classid classname studentid studentname studentsex studentintertime");
                    Function.Select2(start,count);
                    break;
                }
                case 6:System.exit(0);break;
            }
        }
    }
}

