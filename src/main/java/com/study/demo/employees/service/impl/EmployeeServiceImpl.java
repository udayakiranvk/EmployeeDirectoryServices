package com.study.demo.employees.service.impl;

import com.study.demo.employees.dao.EmployeeRepository;
import com.study.demo.employees.entity.Employee;
import com.study.demo.employees.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    /**
     * @return
     */

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Employee findByEmployeeId(int id) {

        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if(result.isPresent()) {
            employee = result.get();
        }
        else {
            throw new RuntimeException("Did not find Employee id :"+id);
        }
        return employee;

    }

    /**
     * @param employee
     * @return
     */
    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * @param id
     */
    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
