package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);

    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartments() {
        LOGGER.info("START");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        List<Department> departments = context.getBean("departmentList", List.class);
        context.close();
        LOGGER.info("END");
        return departments;
    }
}
