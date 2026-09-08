package com.radsan.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radsan.entity.Company_info;

public interface Company_infoRepository extends JpaRepository<Company_info,Integer> {

	boolean existsByName(String name);
}
