package Java_0703;

import java.util.*;

public class grrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int falg = sc.nextInt();
            List<Student> students = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                students.add(new Student(sc.next(),sc.nextInt()));
            }
            if(falg == 0) {
                Collections.sort(students,(o1,o2) -> o2.score - o1.score);
            }else {
                Collections.sort(students,(o1,o2) -> o1.score - o2.score);
            }
            for(int i = 0; i < n; i++) {
                System.out.println(students.get(i).name+" "+students.get(i).score);
            }
        }
    }
    static class Student {
        public String name;
        public int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
