package com.mvc.pattern;

public class MVCPatternExample {
    public static void main(String[] args) {
        // Fetch student record from the database
        Student model = retrieveStudentFromDatabase();

        // Create a view to display student details
        StudentView view = new StudentView();

        // Create a controller
        StudentController controller = new StudentController(model, view);

        // Display initial student details
        controller.updateView();

        // Update the model data
        controller.setStudentName("John Doe");
        controller.setStudentGrade("A");

        // Display updated student details
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Jane Smith");
        student.setId("001");
        student.setGrade("B");
        return student;
    }
}
