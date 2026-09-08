package com.radsan.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radsan.entity.Faq;



public interface FaqRepository extends JpaRepository<Faq,Integer> {

	boolean existsByQuestion(String question);
}
