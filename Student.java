//@author Shreyan Wankavala
//112634232

public class Student implements Cloneable{
    private String name;
    private double money;

    /** Constructor method for the Student object
     *
     * @param name1 = name of the student
     * @param money1 = the amount of money the student has
     */
    public Student(String name1, double money1){
        name = name1;
        money = money1;
    }

    /** Method for changing the name of a student
     *
     * @param name1 = the name of the student
     */
    public void setName(String name1){
        name = name1;
    }

    /** Method for changing the amount of money a student has
     *
     * @param money1 = the amount of money a student has
     */
    public void setMoney(double money1){
        money = money1;
    }

    /** Method to return the name of the student
     *
     * @return the student's name
     */
    public String getName(){
        return name;
    }

    /** Method to return the amount of money a student has
     *
     * @return the student's money
     */
    public double getMoney(){
        return money;
    }

    /** Method to convert the name and money of a student into a string
     *
     * @return the name and money of a student
     */
    public String toString(){
        return name + "     " + "$" + money + "\n";
    }

    /** Method to clone a student
     *
     * @return
     */
    public Student clone(){
        Student copy = new Student(this.getName(), this.getMoney());

        return copy;
    }

    /** Method to check if the lunch line in each reality is equal
     *
     * @param obj = object parameter casted to Student
     * @return = boolean value for if the money is the same
     */
    public boolean equals(Object obj){
        Student checkStudent = (Student)obj;

        if(!this.getName().equals(checkStudent.getName())){
            return false;
        }
        return this.getMoney() == checkStudent.getMoney();
    }
}
