package three.service;

import three.domain.Architect;
import three.domain.Designer;
import three.domain.Employee;
import three.domain.Programmer;

/**
 * counter为静态变量，用来为开发团队新增成员自动生成团队中的唯一ID，即memberId。（提示：应使用增1的方式）
 * MAX_MEMBER：表示开发团队最大成员数
 * team数组：用来保存当前团队中的各成员对象，也就是一个团队
 * total：记录团队成员的实际人数
 *
 * @author shkstart
 * @create 2021-08-12-22:04
 */
public class TeamService {
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    /**
     * 获取当前所有员工
     *
     * @return team
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < total; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * 向团队中添加一个新的成员
     * 考虑所有可能出错的地方
     *
     * @param e
     * @throws TeamException
     */
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            System.out.print("添加失败，原因：");
            throw new TeamException("成员已满无法添加");
        }

        if (!(e instanceof Programmer)) {
            System.out.print("添加失败，原因：");
            throw new TeamException("该成员不是开发人员");
        }

        Programmer p = (Programmer) e;

        for (int i = 0; i < total; i++) {
            if (team[i].getId() == p.getId()) {
                System.out.print("添加失败，原因：");
                throw new TeamException("该成员已在本团队中");
            }
        }

        switch (p.getStatus()) {
            case BUSY:
                System.out.print("添加失败，原因：");
                throw new TeamException("该员工已是某团队成员");
            case VOCATION:
                System.out.print("添加失败，原因：");
                throw new TeamException("该员工正在休假，无法添加");
            default:
        }

        int numPro = 0, numDes = 0, numArc = 0;
        for (int i = 0; i < counter; i++) {
            if (team[i] instanceof Programmer) {
                numPro++;
            } else if (team[i] instanceof Designer) {
                numDes++;
            } else if (team[i] instanceof Architect) {
                numArc++;
            }
        }
        if (p instanceof Architect) {
            if (numArc >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numDes >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (p instanceof Programmer) {
            if (numPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        p.setStatus(Status.BUSY);
        p.setMemberld(counter++);
        team[total++] = p;
        System.out.println("添加成功");
    }

    /**
     * 从团队中删除成员
     *
     * @param Id
     */
    public void removeMember(int Id) throws TeamException {
        boolean isnot = true;
        for (int i = 0; i < total; i++) {
            if (team[i].getMemberld() == Id) {
                team[i].setStatus(Status.FREE);
                for (int j = i; j < total; j++) {
                    team[j] = team[j + 1];
                }
                team[--total] = null;
                isnot = false;
                break;
            }
        }
        if (isnot) {
            throw new TeamException("找不到指定Id的员工，删除失败");
        }
    }

    public TeamService() {
    }
}
