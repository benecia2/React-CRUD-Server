package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.dto.Practice;

public interface PracticeRepository  extends JpaRepository<Practice, Long>{

}
