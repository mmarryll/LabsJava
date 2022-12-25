import java.io.*;
import java.util.*;

public class Task {
    public static void main(String[] args) {
        RecordBook books = new RecordBook("C://Users//37529//Desktop//lab4//src//in.txt");
        books.Print();
        //books.WriteExcellent("src/out.txt");

    }
    public static class Student {

        private String surname;
        private String name;
        private String patronymic;
        private int course;
        private int group;
        private int numses;
        private String subject;
        private int score;

        public Student(String surname_, String name_, String patronymic_, int course_, int group_, int numses_, String subject_, int score_) {
            surname = surname_;
            name = name_;
            patronymic = patronymic_;
            course = course_;
            group = group_;
            numses = numses_;
            subject = subject_;
            score = score_;
        }

        boolean IsItExcellent() {
            if (score >= 9) {
                return true;
            }
            return false;
        }

        void PrintStudent(){
            System.out.println(surname + " " + name + " " + patronymic + " " + course + " "
                    + group + " " + numses + " " + subject + " " + score);
        }
    }

    public static class RecordBook implements Serializable {
        private ArrayList<Student> students;

        RecordBook(String filename) {
            students = new ArrayList<Student>();
            try {
                FileInputStream fis = new FileInputStream(filename);
                while (true) {
                    try {
                        ObjectInputStream oin = new ObjectInputStream(fis);
                        students.add((Student) oin.readObject());
                    } catch (ClassNotFoundException exc) {
                        System.out.println("ClassNotFound");
                        return;
                    } catch (EOFException e) {
                        System.out.println("Файл не найден");
                        break;
                    }
                }
                fis.close();
            } catch (IOException exc) {
                System.out.println("Что-то пошло не так");
                return;
            }
        }

        void Print(){
            for(Student st : students){
                st.PrintStudent();
            }
        }

        void WriteExcellent(String filename) {
            try {
                FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                for (Student st : students) {
                    if (st.IsItExcellent()) {
                        oos.writeObject(st);
                    }
                }

                oos.flush();
                oos.close();
                
            } catch (IOException exc) {
                System.out.println("Что-то пошло не так");
                return;
            }


        }
    }
}
