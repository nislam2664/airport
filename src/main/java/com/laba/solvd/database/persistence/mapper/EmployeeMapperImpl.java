package com.laba.solvd.database.persistence.mapper;

import com.laba.solvd.database.config.MyBatis;
import com.laba.solvd.database.domain.Airplane;
import com.laba.solvd.database.domain.Employee;
import com.laba.solvd.database.persistence.EmployeeRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeMapperImpl implements EmployeeRepository {
    private static final MyBatis MY_BATIS = MyBatis.getInstance();

    @Override
    public void create(Employee employee) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.insert("create", employee);
            session.commit();
        }
    }

    @Override
    public void update(Employee employee) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.update("update", employee);
            session.commit();
        }
    }

    @Override
    public void delete(Employee employee) {
        try (SqlSession session = MY_BATIS.getSession();){
            session.delete("delete", employee);
            session.commit();
        }
    }

    @Override
    public Employee read(int id) {
        try (SqlSession session = MY_BATIS.getSession();){
            return session.selectOne("read");
        }
    }

    @Override
    public List<Employee> getAll() {
        try (SqlSession session = MY_BATIS.getSession();) {
            return session.selectList("getAll");
        }
    }

    @Override
    public void setEmployee(Employee employee, Airplane airplane) {
        try (SqlSession session = MY_BATIS.getSession()) {
            EmployeeRepository employeeRepo = session.getMapper(EmployeeRepository.class);
            employeeRepo.setEmployee(employee, airplane);
            session.commit();
        }
    }
}
