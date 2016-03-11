package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class ClassStdDao {
	 HibernateTemplate template;  
	    public void setTemplate(HibernateTemplate template) {  
	        
	    	
	    	this.template = template;  
	    }  
	

	    @Transactional(readOnly=false)
	    public void saveClassStd(ClassStd i){  
	        
	    	  	template.save(i); 
	        
	    }  
	 
	    public void updateClassStd(ClassStd i){  
	        template.update(i);  
	    }  
	
	    public void deleteClassStd(ClassStd i){  
	        template.delete(i);  
	    }  
	    
	    public ClassStd getById(int id){  
	    	ClassStd i=(ClassStd)template.get(ClassStd.class,id);  
	        return i;  
	    }  
	    
	    public int getMaxId(){  
	    	int id=template.getMaxResults();
	        return id;  
	    }  
	    
		public List<ClassStd> getClassStd(){  
	        List<ClassStd> list=new ArrayList<ClassStd>();  
	        list=template.loadAll(ClassStd.class);  
	        return list;  
	        
	    } 
		public List<ClassStd> getClassStdbyid(int uid){  
	       
	        List<ClassStd> classStdlist = (List<ClassStd>)template.findByNamedParam("from Income where uid=:uid order by incmid desc", new String[]{"uid"}, new Object[]{uid}); 

	      
	 
	        return classStdlist;  
	        
	    } 
}
