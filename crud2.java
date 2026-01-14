package proj;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class crud2 extends JFrame {

	public class Student {
	    private String name;
	    private String email;
	    private String lrn;
	    private String grade;

	    // Constructor
	    public Student(String name, String email, String lrn, String grade) {
	        this.name = name;
	        this.email = email;
	        this.lrn = lrn;
	        this.grade = grade;
	    }

	    // Getters and Setters
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getLrn() {
	        return lrn;
	    }
	    public void setLrn(String lrn) {
	        this.lrn = lrn;
	    }

	    public String getGrade() {
	        return grade;
	    }
	    public void setGrade(String grade) {
	        this.grade = grade;
	    }

	    // Optional: for debugging or displaying student info
	    @Override
	    public String toString() {
	        return "Student{" +
	                "name='" + name + '\'' +
	                ", email='" + email + '\'' +
	                ", lrn='" + lrn + '\'' +
	                ", grade='" + grade + '\'' +
	                '}';
	    }
	}

        }
