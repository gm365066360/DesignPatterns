package com.gm.designpatterns.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/17 15:02
 * Description: ClassA
 * Company : 北京四维图新科技股份有限公司
 */
public class ClassA {

    private Student[] students;

    public Student[] getStudents() {
        return students;
    }

    public ClassA() {
        students =new Student [4];
        students[0]=new Student("gaom1", 11, 160, 113);
        students[1]=new Student("gaom2", 14, 165, 112);
        students[2]=new Student("gaom3", 12, 167, 114);
        students[3]=new Student("gaom4", 10, 166, 111);
    }

    public static class Student {
        public String name;
        public int age;
        public int height;
        public int weight;


        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", height=" + height +
                    ", weight=" + weight +
                    '}';
        }

        public Student(String name, int age, int height, int weight) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }
    }


    public interface IComparator<T> {
        int compare(T o1, T o2);
    }

    public static class AgeComparator implements IComparator<Student> {

        @Override
        public int compare(Student p1, Student p2) {
            //年龄从大到小
            return p1.age > p2.age ? 1 : -1;
        }
    }

    public static class HeightComparator implements IComparator<Student> {

        @Override
        public int compare(Student p1, Student p2) {
            //身高从大到小
            return p1.height > p2.height ? 1 : -1;
        }
    }


    public void sort(Student[] arr, IComparator<Student> comparator) {
        for (int i = arr.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) < 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static <T> void swap(T[] x, int a, int b) {
        T t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
