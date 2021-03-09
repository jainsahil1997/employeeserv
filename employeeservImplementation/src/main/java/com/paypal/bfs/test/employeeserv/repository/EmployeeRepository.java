package com.paypal.bfs.test.employeeserv.repository;

import com.paypal.bfs.test.employeeserv.model.EmployeeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeTable,Integer> {

}