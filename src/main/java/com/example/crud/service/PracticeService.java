package com.example.crud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.dto.Practice;
import com.example.crud.repository.PracticeRepository;

@Service
public class PracticeService {
	@Autowired
		private PracticeRepository practiceRepository;
	
	//추가
	public Practice insert(Practice practice) {
		return practiceRepository.save(practice);
	}
	
	//전체보기
	public List<Practice>list(){
		return practiceRepository.findAll();
	}
	
	//상세보기
	public Practice detail(Long id) {
		return practiceRepository.findById(id).get();
	}
	
	//삭제
	public void delete(Long id) {
		practiceRepository.deleteById(id);
	}
	
	//수정(1)
//	@Transactional
//	public Practice update(Long id, Practice practice) {
//		Practice practice1 = practiceRepository.findById(id).get();
//		
//		practice1.setId(practice.getId());
//		practice1.setTitle(practice.getTitle());
//		practice1.setSummary(practice.getSummary());
//		return practice1;
//	}
	@Transactional
	public void update(Practice practice) {
		Practice practice1 = practiceRepository.findById(practice.getId()).get();
		practice1.setTitle(practice.getTitle());
		practice1.setSummary(practice.getSummary());
		
	}
}
