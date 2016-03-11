package cntrlr;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AcademicYear;
import model.AcademicYearDao;
import model.ClassStd;
import model.ClassStdDao;
import model.Division;
import model.DivisionDao;
import model.Subject;
import model.SubjectDao;
import model.YearClassDivSubMaster;
import model.YearClassDivSubMasterDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentRecordCntrlr {
	@RequestMapping("/jsp/studentregister")
	public ModelAndView register(HttpServletRequest request,
			HttpServletResponse res) {
		ApplicationContext r = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		
		
 YearClassDivSubMasterDao master= (YearClassDivSubMasterDao) r.getBean("YearClassDivSubMasterDao");
		AcademicYearDao academicYearDao = (AcademicYearDao) r.getBean("AcademicYearDao");
		ClassStdDao classStdDao = (ClassStdDao) r.getBean("ClassStdDao");
		DivisionDao divisionDao = (DivisionDao) r.getBean("DivisionDao");
		SubjectDao subjectDao = (SubjectDao) r.getBean("StudentDao");
		Enumeration<String> pnames=request.getParameterNames();
		String startYear= request.getParameter("year");
		
		String std= request.getParameter("std");
		String div= request.getParameter("div");
		String [] subj=request.getParameterValues("subject");
		String [] subjMrk=request.getParameterValues("scored");
		String message;
		try{
		String masterstr;
		List<Subject> subjects=new ArrayList<Subject>();
		
		//int max=dao.getMaxId();
		System.out.println("0asdadsadsadsadsa");
		int i=0;
		while(!subj[i].equals("") && !subjMrk[i].equals(""))
		//for(int i=0;i<subj.length; i++){
		{	int j=i+1;
			while(!subj[j].equals(""))
			{
				if(subj[i].equals(subj[j])){
					message="Subject No. "+(i+1)+" and Subject No. "+(j+1)+" is Same which is not allowed<br>";
					return new ModelAndView("subjectreg", "message", message);	
				}
				j++;
			}
			System.out.println("1asdadsadsadsadsa");
			
			masterstr=startYear+std+div+subj[i];
			//YearClassDivSubMaster tempMaster=new YearClassDivSubMaster();
			//tempMaster.setYearClassDiv(masterstr);
			System.out.println(masterstr);
			YearClassDivSubMaster yearClassDivSubMastertemp=master.getById(masterstr);
				if(yearClassDivSubMastertemp!=null)
		
				{message="Subject No. "+(i+1)+" is already there in record<br>";
				return new ModelAndView("subjectreg", "message", message);}
				System.out.println("1.1asdadsadsadsadsa");
				Subject temp1=new Subject();
			temp1.setName(subj[i]);
			temp1.setSubjMark(Integer.parseInt(subjMrk[i]));
			//subjectDao.saveSubject(temp);
			
			System.out.println("1.2asdadsadsadsadsa");
				
			
			subjects.add(temp1)	;i++;
			System.out.println("1.3asdadsadsadsadsa");
		}
		System.out.println("");
		Iterator<Subject> it=subjects.listIterator();
		while(it.hasNext()){
			System.out.println(it.next().getName());
		}
		//List<Division> divlst= new ArrayList<Division>();
		Map<Integer,Division> divPerClass= new HashMap<Integer,Division>();
		
		Division dv =new  Division();
		dv.setDivId(div);
		dv.setSubjects(subjects);
		divPerClass.put(Integer.parseInt(startYear)+(1000+Integer.parseInt(std)), dv);
		//divisionDao.saveDivision(dv);////idher dekh
		//divlst.add(dv);
		//List<ClassStd> clslst= new ArrayList<ClassStd>();
		
		
		Map<Integer,ClassStd> clasEveryYear= new HashMap<Integer,ClassStd>();
		
		ClassStd classStd= new ClassStd();
		classStd.setClassStdId(Integer.parseInt(std));
		classStd.setDivPerClass((divPerClass));
		//classStdDao.saveClassStd(classStd);
		//clslst.add(classStd);
		clasEveryYear.put(Integer.parseInt(startYear)+(1000+Integer.parseInt(std)), classStd);
		AcademicYear ay= new AcademicYear();
		ay.setStartYear(Integer.parseInt(startYear));
		ay.setEndYear(Integer.parseInt(startYear)+1);
		ay.setClasEveryYear(clasEveryYear);
		System.out.println("asdadsadsadsadsa");
		
		academicYearDao.saveAcademicYear(ay);
		
		//temp2.setAcademicYear(year);
		///temp2.setStandardId(Integer.parseInt(std));
		//List <Integer> subId=new ArrayList<Integer>();
		//int limit=max+subject.length;
		//while(max<limit){
		//subId.add(++max);
				
		//}
		//temp2.setSubjectid(subId);
		//subjectsdao.saveSubjects(temp2);
		i=0;
		while(!subj[i].equals("") && !subjMrk[i].equals("")){
			masterstr=startYear+std+div+subj[i];
			YearClassDivSubMaster tempMaster=new YearClassDivSubMaster();
			tempMaster.setYearClassDivSub(masterstr);i++;
			master.saveYearClassDivSubMaster(tempMaster);
		}
		
	
		}catch (Exception e) {
			// TODO: handle exception
			message= "Error\n"+e;
			return new ModelAndView("errorpage", "message", message);
		}
		message= "Saved Successfully";
		return new ModelAndView("saved", "message", message);
	}
}
