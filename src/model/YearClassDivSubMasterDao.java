package model;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class YearClassDivSubMasterDao {
	HibernateTemplate template;  
    public void setTemplate(HibernateTemplate template) {  
        
    	
    	this.template = template;  
    }  


    @Transactional(readOnly=false)
    public void saveYearClassDivSubMaster(YearClassDivSubMaster i){  
        
    	  	template.save(i); 
        
    }  
    public YearClassDivSubMaster getById(String id){  
    	YearClassDivSubMaster i=(YearClassDivSubMaster)template.get(YearClassDivSubMaster.class,id);  
        return i;  
    }  
}
