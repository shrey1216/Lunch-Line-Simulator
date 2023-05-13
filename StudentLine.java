//@author Shreyan Wankavala

public class StudentLine implements Cloneable{

    final int CAPACITY = 20;

    private Student[] students;
    private int studentCount;

    /** A constructor method for StudentLine
     * initializes students
     * sets studentCount to 0
     */
    public StudentLine(){
        students = new Student[CAPACITY];
        studentCount = 0;
    }

    /** Method to return the number of students on line
     *
     * @return the number of students on line
     */
    public int numStudents(){
        return studentCount;
    }

    /** Method to return a student given an index
     *
     * @param index
     * @return the student at that index
     */
    public Student getStudent(int index){
        return students[index];
    }

    /** Method removes a student from the line given an index
     *
     * @param index = index for where the student is located
     * @return the removed student
     */
    public Student removeStudent(int index){

        Student temp = students[index];
        studentCount--;
        for(int i = index; i < studentCount; i++) {
            students[i] = students[i + 1];
        }
        return temp;
    }

    /** Method to add a student given an index onto the line
     *
     * @param index = index for where the student is located
     * @param student = the student object, with a name and money
     * @throws DeanException when the line is full
     */
    public void addStudent(int index, Student student) throws DeanException {
        if(index != CAPACITY) {
            students[index] = student;
            studentCount++;
        }else{
            throw new DeanException("The line is full");
        }
    }

    /** Method to add a student to the line when the line is already full
     *
     * @param index = index of the student
     * @param student = the student object, with a name and money
     */
    public void addStudentFull(int index, Student student){

            students[index] = student;
            studentCount++;
    }

    /** Method to allow someone to cut their friend on line
     *
     * @param index for where the student will cut
     * @param student = the student object, with a name and money
     */
    public void cutFriend(int index, Student student){

        if(index == studentCount-1){
            students[index] = student;
        }else{
            Student temp = students[studentCount - 1];

            for (int i = studentCount; i > index; i--) {
                if (i == CAPACITY) {
                    continue;
                } else {
                    students[i] = students[i - 1];
                }
            }
            students[index] = student;
            studentCount++;


            students[studentCount - 1] = temp;
        }
    }

    /** The method allows to swap the positions of two students on line
     *
     * @param index1 = the index of the first student
     * @param index2 = the index of the second student
     */
    public void swapStudents(int index1, int index2){


        Student temp = students[index1];
        students[index1] = students[index2];
        students[index2] = temp;

    }


    /** A Method to clone the student line
     *
     * @return gives the clone of the student line
     */
    public StudentLine clone(){
        StudentLine copy = new StudentLine();
        try {
            for (int i = 0; i < studentCount; i++) {
                copy.addStudent(i, this.getStudent(i).clone());
            }
        }catch(DeanException full){
            System.out.println("The line is full");
        }
        return copy;
    }


    /** A method to check whether the lengths and contents of both lines are equal.
     *
     * @param obj = object parameter caster to StudentLine
     * @return true or false for whether they're equal
     */
    public boolean equals(Object obj){
        StudentLine checkLine = (StudentLine)obj;

        if(this.numStudents() != checkLine.numStudents()){
            return false;
        }
        for(int i = 0; i < studentCount; i++){
            if(!this.getStudent(i).equals(checkLine.getStudent(i))){
                return false;
            }
        }
        return true;
    }

    /** Method to convert the name and money of the students into a string
     *
     * @return the list of the name and money of each student
     */
    public String toString(){
        String list = "";
        for(int i = 0; i < studentCount; i++){
            list += (i + 1) + "." + students[i].toString();
        }
        return list;
    }


}
