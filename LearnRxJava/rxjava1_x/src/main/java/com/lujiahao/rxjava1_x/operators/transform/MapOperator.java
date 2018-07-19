package com.lujiahao.rxjava1_x.operators.transform;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lujiahao
 * @date 2018-07-10 下午3:07
 */
public class MapOperator {
    public static void main(String[] args) {
        first();
        System.out.println("===========================================");
        two();
    }

    public static void first() {
        Observable.just("Hello RxJava")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s.substring(0, 8);
                    }
                })
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s.substring(0, 5);
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }

    public static void two() {
        List<Student> students = getData();
        Action1<List<Course>> action1 = new Action1<List<Course>>() {
            @Override
            public void call(List<Course> courses) {
                //遍历courses，输出cuouses的name
                for (int i = 0; i < courses.size(); i++){
                    System.out.println(courses.get(i).getName());
                }
            }
        };
        Observable.from(students)
                .map(new Func1<Student, List<Course>>() {
                    @Override
                    public List<Course> call(Student student) {
                        //返回coursesList
                        return student.getCoursesList();
                    }
                })
                .subscribe(action1);
    }













    public static List<Student> getData() {
        Course course1 = new Course();
        course1.setId("1");
        course1.setName("英语");
        Course course2 = new Course();
        course2.setId("1");
        course2.setName("语文");
        Course course3 = new Course();
        course3.setId("1");
        course3.setName("计算机");

        List<Course> courseList1 = new ArrayList<>();
        courseList1.add(course1);
        courseList1.add(course2);
        List<Course> courseList2 = new ArrayList<>();
        courseList2.add(course3);

        Student student1 = new Student();
        student1.setName("lujiahao1");
        student1.setCoursesList(courseList1);
        Student student2 = new Student();
        student2.setName("lujiahao2");
        student2.setCoursesList(courseList2);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        return students;
    }

    /**
     * 学生类
     */
    static class Student {
        public String name;//姓名
        public List<Course> coursesList;//所修的课程

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Course> getCoursesList() {
            return coursesList;
        }

        public void setCoursesList(List<Course> coursesList) {
            this.coursesList = coursesList;
        }
    }
    /**
     * 课程类
     */
    static class  Course {
        public String name;//课程名
        public String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
