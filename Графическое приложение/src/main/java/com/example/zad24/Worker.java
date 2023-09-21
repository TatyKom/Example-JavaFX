package com.example.zad24;

import javafx.beans.property.*;

public class Worker {
    private StringProperty name;
    public StringProperty nameProperty(){
        if (name == null) {
            name = new SimpleStringProperty();
        }
        return name;
    }
    public String getName() {
        return nameProperty().get();
    }
    public void setName(String value) {
        nameProperty().set(value);
    }
    private IntegerProperty age;
    public IntegerProperty ageProperty(){
        if( age == null) {
            age = new SimpleIntegerProperty();
        }
        return age;
    }

    public int getAge() {
        return ageProperty().get();
    }

    public void setAge(int value) {
        ageProperty().set(value);
    }
    private StringProperty education;
    public StringProperty educationProperty(){
        if (education == null) {
            education = new SimpleStringProperty();
        }
        return education;
    }

    public String getEducation() {
        return educationProperty().get();
    }

    public void setEducation(String value) {
        educationProperty().set(value);
    }
    private StringProperty profession;
    public StringProperty professionProperty(){
        if (profession == null) {
            profession = new SimpleStringProperty();
        }
        return profession;
    }

    public String getProfession() {
        return professionProperty().get();
    }

    public void setProfession(String value) {
        professionProperty().set(value);
    }
    private DoubleProperty salary;
    public DoubleProperty salaryProperty(){
        if (salary == null) {
            salary = new SimpleDoubleProperty();
        }
        return salary;
    }

    public double getSalary() {
        return salaryProperty().get();
    }

    public void setSalary(double value) {
        salaryProperty().set(value);
    }
    public Worker (String name, int age, String education, String profession, double salary) {
        nameProperty().set(name);
        ageProperty().set(age);
        educationProperty().set(education);
        professionProperty().set(profession);
        salaryProperty().set(salary);
    }
}
