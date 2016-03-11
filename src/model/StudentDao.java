package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudentDao {
	 HibernateTemplate template;  
	    public void setTemplate(HibernateTemplate template) {  
	        
	    	
	    	this.template = template;  
	    }  
	

	    @Transactional(readOnly=false)
	    public void saveStudents(Student i){  
	        
	    	  	template.save(i); 
	        
	    }  
	 
	    public void updateStudents(Student i){  
	        template.update(i);  
	    }  
	
	    public void deleteStudents(Student i){  
	        template.delete(i);  
	    }  
	    
	    public Student getById(int id){  
	    	Student i=(Student)template.get(Student.class,id);  
	        return i;  
	    }  
		public List<Student> getStudents(){  
	        List<Student> list=new ArrayList<Student>();  
	        list=template.loadAll(Student.class);  
	        return list;  
	        
	    } 
		public List<Student> getStudentsbyid(int uid){  
	       //Income list;  
	        List<Student> Studentlist = (List<Student>)template.findByNamedParam("from Income where uid=:uid order by incmid desc", new String[]{"uid"}, new Object[]{uid}); 
//	        if(!incomelist.isEmpty())
//	        {   }
//	   else
//	        { incomelist=null;}
	      
	 
	        return Studentlist;  
	        
	    } 
}
