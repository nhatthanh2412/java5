package com.example.demoJ5springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demoJ5springboot.entity.Records;



public interface RecordsRepository extends JpaRepository<Records, Integer>{
	 @Query("SELECT r.staffid.name, SUM(case when r.type=1 then 1 else 0 end), SUM(case when r.type=0 then 1 else 0 end) FROM Records r  GROUP BY r.staffid.name")
	 List<Object> find_record_staff();
	 
	 @Query("SELECT r.staffid.departs.id, SUM(case when r.type=1 then 1 else 0 end), SUM(case when r.type=0 then 1 else 0 end) FROM Records r  GROUP BY r.staffid.departs.id")
	 List<Object> find_record_depart();
	 
}
