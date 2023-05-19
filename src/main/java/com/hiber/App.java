package com.hiber;

import java.util.ArrayList;
import java.util.List;

import com.hiber.Entity.Mobile;
import com.hiber.Entity.Person;
import com.hiber.Service.PersonDao;
import com.hiber.Service.PersonServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        PersonDao operations=new PersonServiceImpl();
        
        //save Person
        Person person1=new Person();
        person1.setName("Devendra");
        List<Mobile> mobiles=new ArrayList<Mobile>();
        
        Mobile moto=new Mobile();
        moto.setBrand("motorola");
        moto.setCost(10499.00);
        moto.setModel("G32");
        
        Mobile vivo=new Mobile();
        vivo.setBrand("vivo");
        vivo.setModel("T1x");
        vivo.setCost(1199.00);
        
        mobiles.add(vivo);
        mobiles.add(moto);
        
        
        person1.setMobile(mobiles);
        
        operations.savePerson(person1);
        
        
        
        //save Mobile
        Mobile redmi=new Mobile();
        redmi.setBrand("Redmi");
        redmi.setModel("10A");
        redmi.setCost(10420.01);
        operations.saveMobile(redmi);
        
        Person person2=new Person();
        person2.setName("Raju");
    
        Mobile realme=new Mobile();
        realme.setBrand("RealMe");
        realme.setModel("Nortz10");
        realme.setCost(9999.00);
        realme.setPerson(person2);
        operations.saveMobile(realme);
        
        
        //getMobile
        System.out.println(operations.getMobiles());
        
        //getPerson
        System.out.println(operations.getPerson());
        
        //Update Mobile
        redmi.setCost(10000.500);
        operations.updateMobile(redmi, 1L);
        
        
        //Update Person
        operations.updatePerson(person2, 2L);
        
        //Delete Person
        operations.deleteMobile(1L);
        
        //Delete Mobile
        operations.deletePerson(1L);
        
        //get Person By ID
        System.out.println("Person:---------------> "+ operations.getPersonById(3L));
        
        //Get Mobile By Id
        System.out.println("Mobile:--------------> "+operations.getMobileById(2L));
        
        //GetMobile By person Id
       System.out.println( "Mobiles:------------->"+operations.getMobileByPersonId(3L));
    }
}
