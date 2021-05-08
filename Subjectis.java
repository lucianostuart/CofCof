class Subjectis {
    String subjectName;
    int semester;
    int workLoad;
    double grade;

    public Subjectis(String name, int workload, double grade, int semester) {
        this.grade = grade;
        this.subjectName = name;
        this.semester = semester;
        this.workLoad = workload;
    }

    public double calculateAvg() {
        return (this.grade/this.workLoad);
    }

    public String toString() {
        return this.subjectName + " " + (this.grade * this.workLoad)+ " ";
    }
}