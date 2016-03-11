package model;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class YearClsDivStudMasterDao {
	HibernateTemplate template;  
    public void setTemplate(HibernateTemplate template) {  
        
    	
    	this.template = template;  
    }  


    @Transactional(readOnly=false)
    public void saveYearClsDivStudMaster(YearClsDivStudMaster i){  
        
    	  	template.save(i); 
        
    }  
    public YearClsDivStudMaster getById(String id){  
    	YearClsDivStudMaster i=(YearClsDivStudMaster)template.get(YearClsDivStudMaster.class,id);  
        return i;  
    }  
}
