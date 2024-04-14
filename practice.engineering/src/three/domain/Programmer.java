package three.domain;

import three.service.Status;

/**
 * 程序员
 * memberld  用来记录成员加入开发团队后在团队中的ID
 * equipment 表示该成员领用的设备
 * status是默认状态，用于标识当前员工处于空闲状态
 *
 * @author shkstart
 * @create 2021-08-12-19:52
 */
public class Programmer extends Employee {
    private int memberld;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer(int id, String name, int age, double salay, Equipment equipment) {
        super(id, name, age, salay);
        this.equipment = equipment;
    }

    public int getMemberld() {
        return memberld;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setMemberld(int memberld) {
        this.memberld = memberld;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "memberld=" + memberld +
                ", status=" + status +
                ", equipment=" + equipment +
                "} " + super.toString();
    }
}
