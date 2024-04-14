package queryResults;

/**
 * @author shkstart
 * @date: 2022.10.01
 */
public class ExamStudent {
    private int flowID,type,grade;
    private String IDCard,examCard,studentName,location;

    public int getFlowID() {
        return flowID;
    }

    public int getType() {
        return type;
    }

    public int getGrade() {
        return grade;
    }

    public String getIDCard() {
        return IDCard;
    }

    public String getExamCard() {
        return examCard;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getLocation() {
        return location;
    }

    public void setFlowID(int flowID) {
        this.flowID = flowID;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public void setExamCard(String examCard) {
        this.examCard = examCard;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ExamStudent(int flowID, int type, int grade, String IDCard, String examCard, String studentName, String location) {
        this.flowID = flowID;
        this.type = type;
        this.grade = grade;
        this.IDCard = IDCard;
        this.examCard = examCard;
        this.studentName = studentName;
        this.location = location;
    }

    public ExamStudent() {
    }
}
