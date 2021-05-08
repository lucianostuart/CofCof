public class Subject {
    String subjectName;
    int semester;
    int workLoad;
    double grade;

    public Subject(String name, int workload, double grade, int semester) {
        this.grade = grade;
        this.subjectName = name;
        this.semester = semester;
        this.workLoad = workload;
    }
}