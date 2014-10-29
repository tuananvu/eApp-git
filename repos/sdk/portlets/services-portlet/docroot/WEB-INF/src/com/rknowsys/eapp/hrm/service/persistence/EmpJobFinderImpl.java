package com.rknowsys.eapp.hrm.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.rknowsys.eapp.hrm.model.EmpJob;
import com.rknowsys.eapp.hrm.model.impl.EmpJobImpl;

public class EmpJobFinderImpl extends BasePersistenceImpl<EmpJob> implements EmpJobFinder {
	
	/** 
	 * This method gets the single EmpJob Record based on the given EmployeeId
	 * @param EmployeeId
	 * @return the emp job
	 * @throws SystemException if a system exception occurred
	 * @author Laxminarayana 27 october 2014 7:39:55 PM
	 */
	@SuppressWarnings("unchecked")
	public EmpJob getEmpJobByEmployeeId(long empid){
		System.out.println("inside getEmpJobByEmployeeId");
		
		Session session = null;
		try{
			session = openSession();
			System.out.println("empid in empjobfinderimpl = "+empid);
			String sql = "SELECT * FROM emp_job WHERE employeeId="+empid;
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("EmpJob", EmpJobImpl.class);
			System.out.println("before list...");
			System.out.println("dialect == " +getDialect());
			List<EmpJob> empjoblist = (List<EmpJob>) QueryUtil.list(q, getDialect(), -1, -1);
			System.out.println("list === "+empjoblist);
		    EmpJob empJob = empjoblist.get(0);
		    System.out.println("empjob == " +empJob);
			return empJob;
		}
		catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

}
