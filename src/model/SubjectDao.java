package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class SubjectDao {
	 HibernateTemplate template;  
	    public void setTemplate(HibernateTemplate template) {  
	        
	    	
	    	this.template = template;  
	    }  
	

	    @Transactional(readOnly=false)
	    public void saveSubject(Subject i){  
	        
	    	  	template.save(i); 
	        
	    }  
	 
	    public void updateSubjects(Subject i){  
	        template.update(i);  
	    }  
	
	    public void deleteSubjects(Subject i){  
	        template.delete(i);  
	    }  
	    
	    public Subject getById(int id){  
	    	Subject i=(Subject)template.get(Subject.class,id);  
	        return i;  
	    }  
	    
	    public int getMaxId(){  
	    	int id=template.getMaxResults();
	        return id;  
	    }  
	    
		public List<Subject> getSubjects(){  
	        List<Subject> list=new ArrayList<Subject>();  
	        list=template.loadAll(Subject.class);  
	        return list;  
	        
	    } 
		public List<Subject> getSubjectsbyid(int uid){  
	       
	        List<Subject> subjectlist = (List<Subject>)template.findByNamedParam("from Income where uid=:uid order by incmid desc", new String[]{"uid"}, new Object[]{uid}); 

	      
	 
	        return subjectlist;  
	        
	    } 
}
