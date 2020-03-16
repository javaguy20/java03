package com.copy;

import lombok.Data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
*  Employee object will not be immutable until its clone() will be  override and implementation will not be provided of its mutable objects.
*  if Employee acts as mutable, then by changing or modifying it by emp instance would cause change in e2 too.
*  if clone() will be overridden of Employee, then it becomes immutable and after that, if any changes done on it by emp, it will create another object of Employee for emp,
 *  while the old instance will be assigned to e2 as it.
* */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("welcome");
        Employee emp=new Employee();
        emp.setId("12");
        emp.setName("sandy");
        Map<String,String> props=new HashMap<>();
        props.put("city","Pune");
        props.put("salary","175000");
        emp.setProps(props);
        Employee e2=(Employee) emp.clone();

        System.out.println(emp==e2);// false means deep copy i.e. different objects
        System.out.println(emp.getProps()==e2.getProps());
        props.put("salary","200000");
        emp.setProps(props);
        emp.setId("33");
        System.out.println(" emp.getProps() " + emp.getProps() + " emp " + emp);
        System.out.println(" e2.getProps() "+e2.getProps()+" e2 "+e2);
      /*  int i=10;
        int y=i;
        System.out.println("i "+i+" y "+y);
        y=9;
        System.out.println("i "+i+" y "+y);

        Employee s=new Employee();
        s.setName("s"); s.setId("1");
        Employee b=s;
        System.out.println("s "+s+" b "+b);
        b.setName("t"); b.setId("2");
        System.out.println("s "+s+" b "+b);*/
    }
}
@Data
class Employee implements Cloneable{
    private String id;
    private String name;
    private Map<String,String> props;
    @Override
    public  Object clone() throws CloneNotSupportedException{
        Employee emp=(Employee) super.clone();
     //   emp.setProps(null);
        // to make Employee immutable, one of its mutable property props should convert into immutable(as hashmap is mutable)
        Map<String,String> hm=new HashMap<>();
        String key;
        Iterator<Map.Entry<String,String>> it=this.props.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,String> entry=it.next();
            hm.put(entry.getKey(), props.get(entry.getKey()));
            System.out.println("entry : " + entry.getKey() + " value " + props.get(entry.getKey()));
        }
        emp.setProps(hm);
        return emp;
      ////  return super.clone();
    }


}