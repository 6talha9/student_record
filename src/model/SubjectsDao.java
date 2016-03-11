package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class SubjectsDao {
	 HibernateTemplate template;  
	    public void setTemplate(HibernateTemplate template) {  
	        
	    	
	    	this.template = template;  
	    }  
	

	    @Transactional(readOnly=false)
	    public void saveSubjects(Subjects i){  
	        
	    	  	template.save(i); 
	        
	    }  
	 
	    public void updateSubjects(Subjects i){  
	        template.update(i);  
	    }  
	
	    public void deleteSubjects(Subjects i){  
	        template.delete(i);  
	    }  
	    
	    public Subjects getById(int id){  
	    	Subjects i=(Subjects)template.get(Subjects.class,id);  
	        return i;  
	    }  
		public List<Subjects> getSubjects(){  
	        List<Subjects> list=new ArrayList<Subjects>();  
	        list=template.loadAll(Subjects.class);  
	        return list;  
	        
	    } 
		public List<Subjects> getSubjectsbyid(int uid){  
	       //Income list;  
	        List<Subjects> Subjectslist = (List<Subjects>)template.findByNamedParam("from Income where uid=:uid order by incmid desc", new String[]{"uid"}, new Object[]{uid}); 
//	        if(!incomelist.isEmpty())
//	        {   }
//	   else
//	        { incomelist=null;}
	      
	 
	        return Subjectslist;  
	        
	    } 
}
