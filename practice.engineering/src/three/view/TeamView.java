package three.view;

import three.domain.*;
import three.service.NameListService;
import three.service.Status;
import three.service.TeamException;
import three.service.TeamService;


/**
 * @author shkstart
 * @create 2021-08-13-20:24
 */
public class TeamView {
    /**
     * 公司所有员工对象listSvc
     * 团队所有成员对象teamSvc
     */
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
//        将公司员工ID为5的员工的状态设置为BUSY即已加入开发团队进行测试
        try {
            Programmer pro1 = (Programmer) teamView.listSvc.getEmployee(5);
            pro1.setStatus(Status.BUSY);
        } catch (TeamException e) {
            e.printStackTrace();
        }
        teamView.enterMainMenu();
    }

    /**
     * 主界面显示及控制方法
     */
    public void enterMainMenu() {
        boolean isCycle = true;
        while (isCycle) {
            according();

            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)： _");
            char c = TSUtility.readMenuSelection();

            switch (c) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    try {
                        addMember();
                    } catch (TeamException e) {
                        e.printStackTrace();
                    }
                    break;
                case '3':
                    try {
                        deleteMember();
                    } catch (TeamException e) {
                        e.printStackTrace();
                    }
                    break;
                case '4':
                    isCycle = false;
                    break;
                default:
            }
            TSUtility.readReturn();
        }
    }

    /**
     * 显示团队成员列表操作
     */
    private void getTeam() {
        Programmer[] team = teamSvc.getTeam();
        System.out.println("ID\t姓名\t  年龄\t  工资\t  职位\t  状态\t  奖金\t  股票\t  领用设备");
        for (Employee p :
                team) {
            if (p instanceof Architect) {
                Architect a = (Architect) p;
                System.out.println(a.getId() + "\t" + a.getName() + "\t" + a.getAge() + "\t" + a.getSalay() + "\t" + "设计师" + "\t" + a.getStatus() + "\t" + a.getBonus() + "\t" + a.getStock() + "\t" + a.getEquipment().getDescription());
            } else if (p instanceof Designer) {
                Designer d = (Designer) p;
                System.out.println(d.getId() + "\t" + d.getName() + "\t" + d.getAge() + "\t" + d.getSalay() + "\t" + "设计师" + "\t" + d.getStatus() + "\t" + d.getBonus() + "\t" + d.getEquipment().getDescription());
            } else if (p instanceof Programmer) {
                Programmer pro = (Programmer) p;
                System.out.println(pro.getId() + "\t" + pro.getName() + "\t" + pro.getAge() + "\t" + pro.getSalay() + "\t" + "程序员" + "\t" + pro.getStatus() + "\t\t" + pro.getEquipment().getDescription());
            } else {
                System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getAge() + "\t" + p.getSalay());
            }
        }
    }

    /**
     * 实现添加成员操作
     */
    private void addMember() throws TeamException {
        System.out.println("-----------添加成员-----------");
        System.out.print("请输入要添加的员工ID：");
        int ID = TSUtility.readInt();
        Employee employee = null;
        try {
            employee = listSvc.getEmployee(ID);
        } catch (TeamException e) {
            e.printStackTrace();
        }
        if (employee != null) {
            teamSvc.addMember(employee);
        }
    }

    /**
     * 实现删除成员操作
     */
    private void deleteMember() throws TeamException {
        System.out.println("-----------删除成员-----------");
        System.out.print("请输入要删除的员工的TID：");
        int TID = TSUtility.readInt();
        System.out.println("确认是否删除(Y/N)：");
        char c = TSUtility.readConfirmSelection();
        switch (c) {
            case 'y':
            case 'Y':
                teamSvc.removeMember(TID);
                System.out.println("删除成功");
                break;
            case 'n':
            case 'N':
                break;
            default:
        }
    }

    /**
     * 主页面显示，只显示五个人
     */
    private void according() {
        System.out.println("-----------开发团队调度软件-----------");
        System.out.println("ID\t姓名\t  年龄\t  工资\t  职位\t  状态\t  奖金\t  股票\t  领用设备");
        Employee[] employees = listSvc.getAllEmployees();
        for (int i = 0; i < 5; i++) {
            if (employees[i] instanceof Architect) {
                Architect arc = (Architect) employees[i];
                System.out.println(arc.getId() + "\t" + arc.getName() + "\t" + arc.getAge() + "\t" + arc.getSalay() + "\t" + "设计师" + "\t" + arc.getStatus() + "\t" + arc.getBonus() + "\t" + arc.getStock() + "\t" + arc.getEquipment().getDescription());
            } else if (employees[i] instanceof Designer) {
                Designer des = (Designer) employees[i];
                System.out.println(des.getId() + "\t" + des.getName() + "\t" + des.getAge() + "\t" + des.getSalay() + "\t" + "设计师" + "\t" + des.getStatus() + "\t" + des.getBonus() + "\t" + des.getEquipment().getDescription());
            } else if (employees[i] instanceof Programmer) {
                Programmer pro = (Programmer) employees[i];
                System.out.println(pro.getId() + "\t" + pro.getName() + "\t" + pro.getAge() + "\t" + pro.getSalay() + "\t" + "程序员" + "\t" + pro.getStatus() + "\t\t" + pro.getEquipment().getDescription());
            } else if (employees[i] instanceof Employee) {
                Employee emp = (Employee) employees[i];
                System.out.println(emp.getId() + "\t" + emp.getName() + "\t" + emp.getAge() + "\t" + emp.getSalay());
            }
        }
        System.out.println("……");
        System.out.println("-----------------------------");
    }

    /**
     * 以表格形式列出公司所有成员
     */
    private void listAllEmployees() {
        System.out.println("ID\t姓名\t  年龄\t  工资\t  职位\t  状态\t  奖金\t  股票\t  领用设备");
        Employee[] employees = listSvc.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            /*
            注意：此处得从Architect类开始，因为
            Employee employee = new Architect();
            employee既是Architect的实例，也是Employee的实例
            */
            if (employees[i] instanceof Architect) {
                Architect arc = (Architect) employees[i];
                System.out.println(arc.getId() + "\t" + arc.getName() + "\t" + arc.getAge() + "\t" + arc.getSalay() + "\t" + "设计师" + "\t" + arc.getStatus() + "\t" + arc.getBonus() + "\t" + arc.getStock() + "\t" + arc.getEquipment().getDescription());

            } else if (employees[i] instanceof Designer) {
                Designer des = (Designer) employees[i];
                System.out.println(des.getId() + "\t" + des.getName() + "\t" + des.getAge() + "\t" + des.getSalay() + "\t" + "设计师" + "\t" + des.getStatus() + "\t" + des.getBonus() + "\t" + des.getEquipment().getDescription());
            } else if (employees[i] instanceof Programmer) {
                Programmer pro = (Programmer) employees[i];
                System.out.println(pro.getId() + "\t" + pro.getName() + "\t" + pro.getAge() + "\t" + pro.getSalay() + "\t" + "程序员" + "\t" + pro.getStatus() + "\t\t" + pro.getEquipment().getDescription());
            } else if (employees[i] instanceof Employee) {
                Employee emp = (Employee) employees[i];
                System.out.println(emp.getId() + "\t" + emp.getName() + "\t" + emp.getAge() + "\t" + emp.getSalay());
            }
        }
    }

    public TeamView() {
    }
}
