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
public class FlatMapOperator {
    public static void main(String[] args) {
        List<Student> students = getData();
        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from(student.getCoursesList());
                    }
                })
                .subscribe(new Action1<Course>() {
                    @Override
                    public void call(Course course) {
                        System.out.println(course.getName());
                    }
                });
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
