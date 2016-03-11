package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class DivisionDao {
	 HibernateTemplate template;  
	    public void setTemplate(HibernateTemplate template) {  
	        
	    	
	    	this.template = template;  
	    }  
	

	    @Transactional(readOnly=false)
	    public void saveDivision(Division i){  
	        
	    	  	template.save(i); 
	        
	    }  
	 
	    public void updateDivision(Division i){  
	        template.update(i);  
	    }  
	
	    public void deleteDivision(Division i){  
	        template.delete(i);  
	    }  
	    
	    public Division getById(int id){  
	    	Division i=(Division)template.get(Division.class,id);  
	        return i;  
	    }  
	    
	    public int getMaxId(){  
	    	int id=template.getMaxResults();
	        return id;  
	    }  
	    
		public List<Division> getDivision(){  
	        List<Division> list=new ArrayList<Division>();  
	        list=template.loadAll(Division.class);  
	        return list;  
	        
	    } 
		public List<Division> getDivisionbyid(int uid){  
	       
	        List<Division> divisionlist = (List<Division>)template.findByNamedParam("from Income where uid=:uid order by incmid desc", new String[]{"uid"}, new Object[]{uid}); 

	      
	 
	        return divisionlist;  
	        
	    } 
}
