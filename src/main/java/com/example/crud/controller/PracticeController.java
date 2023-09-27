package com.example.crud.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.dto.Practice;
import com.example.crud.service.PracticeService;

@RestController
public class PracticeController {
	@Autowired
	private PracticeService practiceService;
	
	//추가
	@PostMapping("/insert")
	public Practice insert(@RequestBody Practice practice) {
		return practiceService.insert(practice);
	}
	
	//전체보기
	@GetMapping("/list")
	public List<Practice>list(){
		return practiceService.list();
	}
	
	//상세보기
	@GetMapping("/detail/{id}")
	public Practice detail(@PathVariable Long id) {
		Practice practice = practiceService.detail(id);
		return practice;
	}
	
	//삭제
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		practiceService.delete(id);
	}
	
	//수정(1)
//	@PutMapping("/update/{id}")
//	public Practice update(@PathVariable Long id, @RequestBody Practice practice) {
//		return practiceService.update(id, practice);
//	}
	
	//수정
	@PutMapping("/update/{id}")
	public String update(@PathVariable Long id, @RequestBody Practice practice) {
		 practiceService.update(practice);
		 return "success";
		 
	}
}
