package prob2A;

public class Student {
    public String name;
    public GradeReport gradeReport;

    Student(String name) {
        this.name = name;
        gradeReport = new GradeReport(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GradeReport getGradeReport() {
        return gradeReport;
    }

    public void setGradeReport(GradeReport gradeReport) {
        this.gradeReport = gradeReport;
    }
}
