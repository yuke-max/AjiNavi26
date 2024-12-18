package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditServiceImpl implements EditService {
	
	private final ReviewRepository repository;

	@Override
	public void edit(Review review) {
		// TODO 自動生成されたメソッド・スタブ
		repository.update(review);
	}

}
