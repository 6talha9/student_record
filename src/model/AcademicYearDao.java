package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class AcademicYearDao {
	 HibernateTemplate template;  
	    public void setTemplate(HibernateTemplate template) {  
	        
	    	
	    	this.template = template;  
	    }  
	

	    @Transactional(readOnly=false)
	    public void saveAcademicYear(AcademicYear i){  
	        
	    	  	template.save(i); 
	        
	    }  
	 
	    public void updateAcademicYear(AcademicYear i){  
	        template.update(i);  
	    }  
	
	    public void deleteAcademicYears(AcademicYear i){  
	        template.delete(i);  
	    }  
	    
	    public AcademicYear getById(int id){  
	    	AcademicYear i=(AcademicYear)template.get(AcademicYear.class,id);  
	        return i;  
	    }  
	    
	    public int getMaxId(){  
	    	int id=template.getMaxResults();
	        return id;  
	    }  
	    
		public List<AcademicYear> getAcademicYears(){  
	        List<AcademicYear> list=new ArrayList<AcademicYear>();  
	        list=template.loadAll(AcademicYear.class);  
	        return list;  
	        
	    } 
		public List<AcademicYear> getAcademicYearsbyid(int uid){  
	       
	        List<AcademicYear> AcademicYearlist = (List<AcademicYear>)template.findByNamedParam("from Income where uid=:uid order by incmid desc", new String[]{"uid"}, new Object[]{uid}); 

	      
	 
	        return AcademicYearlist;  
	        
	    } 
}
