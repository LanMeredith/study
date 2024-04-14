package three.service;

import three.domain.*;

import java.util.ArrayList;

/**
 * employees用来保存公司所有员工对象
 * @author shkstart
 * @create 2021-08-12-21:20
 */
public class NameListService {
    Employee[] employees;

    public NameListService() {
        ArrayList<Employee> arrayList = new ArrayList();
        for (int i = 0; i < Data.EMPLOYEES.length; i++) {
            switch (Data.EMPLOYEES[i][0]) {
                case "10":
                    Employee emp = (Employee) isEMPLOYEES(i);
                    arrayList.add(emp);
                    break;
                case "11":
                    Programmer pro = (Programmer) isEMPLOYEES(i);
                    arrayList.add(pro);
                    break;
                case "12":
                    Designer des = (Designer) isEMPLOYEES(i);
                    arrayList.add(des);
                    break;
                case "13":
                    Architect arc = (Architect) isEMPLOYEES(i);
                    arrayList.add(arc);
                    break;
                default:
            }
        }
        /*
        * 直接写用arrayList.toArray(arrayList])会在运行时报ClassCastException错误
        * 因为java中允许向上和向下转型，但是这个转型是否成功是根据JAVA虚拟机中这个对象的类型来实现的
        * java虚拟机中保存了每个对象的类型，而数组也是一个对象，数组的类型是java.lang.Object
        * 无法将Object转为Employee，所以这个转型不成功
        * 使用toArray(T[] a)即可避免这样的问题
        * 在toArray()中new一个Employee数组，长度为arrayList的实际长度
        * */
        employees = arrayList.toArray(new Employee[arrayList.size()]);
    }

    /**
     * getAllEmployees()方法：获取当前所有员工。
     * @return 包含所有员工对象的数组
     */
    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * getEmployee(id : int)方法：获取指定ID的员工对象。
     * @param id
     * @return employee 指定员工对象
     * @throws TeamException 找不到指定的员工
     */
    public Employee getEmployee(int id) throws TeamException{
        for (Employee e :
                employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new TeamException("找不到指定的员工");
    }

    /**
     * 判断员工职位
     * 因为数组EMPLOYEES中储存的是String类型的数据，所以要借用parsexxx()将其转换为对应数据
     *
     * @param i
     * @return 员工对象
     */
    private Object isEMPLOYEES(int i) {
        switch (Data.EMPLOYEES[i][0]) {
            case "10":
                return new Employee(Integer.parseInt(Data.EMPLOYEES[i][1]), Data.EMPLOYEES[i][2], Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]));
            case "11":
                Equipment equipment = isEquipment(i);
                return new Programmer(Integer.parseInt(Data.EMPLOYEES[i][1]), Data.EMPLOYEES[i][2], Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]), equipment);
            case "12":
                Equipment equipment1 = isEquipment(i);
                return new Designer(Integer.parseInt(Data.EMPLOYEES[i][1]), Data.EMPLOYEES[i][2], Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]), equipment1, Double.parseDouble(Data.EMPLOYEES[1][5]));
            case "13":
                Equipment equipment2 = isEquipment(i);
                return new Architect(Integer.parseInt(Data.EMPLOYEES[i][1]), Data.EMPLOYEES[i][2], Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]), equipment2, Double.parseDouble(Data.EMPLOYEES[1][5]), Integer.parseInt(Data.EMPLOYEES[i][6]));
            default:
                return null;
        }
    }

    /**
     * 判断领用设备
     *
     * @param i
     * @return 设备对象
     */
    private Equipment isEquipment(int i) {
        switch (Data.EQUIPMENTS[i][0]) {
            case "21":
                return new PC(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
            case "22":
                return new NoteBook(Data.EQUIPMENTS[i][1], Double.parseDouble(Data.EQUIPMENTS[i][2]));
            case "23":
                return new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
            default:
                return null;
        }
    }
}
