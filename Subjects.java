/*Código phoda*/ 
class Subjects {
    String subjectName;
    int semester;
    int workLoad;
    double grade;

    public Subjects(String name, int semester, int workload, double grade) {
        this.grade = grade;
        this.subjectName = name;
        this.semester = semester;
        this.workLoad = workload;
    }

    public double calculateAvg() {
        return (this.grade*this.workLoad);
    }

    public String toString() {
        return this.subjectName + " " + (this.grade * this.workLoad)+ " ";
    }
}
