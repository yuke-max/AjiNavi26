package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Review;
import com.example.demo.form.ReviewRemoveForm;
import com.example.demo.service.RemoveService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RemoveController {	
	
	private final RemoveService service;
			
	@PostMapping("/remove-review")
	public String removeReview(@Validated @ModelAttribute ReviewRemoveForm form
								,BindingResult result) {
		if(result.hasErrors()) {
			throw new IllegalArgumentException("removeReview()");
		}
		return "confirm-remove-review";
	}
	
	@PostMapping("confirm-remove-review")
	public String confirmRemoveReview(@Validated @ModelAttribute ReviewRemoveForm form
									,BindingResult result
									,RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			throw new IllegalArgumentException("confirmRemoveReview()");
		}
		
		Review r = new Review();
		r.setReviewId(form.getReviewId());
		r.setUserId(form.getUserId());
		r.setVisitDate(form.getVisitDate());
		r.setRating(form.getRating());
		r.setComment(form.getComment());
		
		service.remove(r);
		
		redirectAttributes.addFlashAttribute("msg", "(レビュー削除)");
		return "redirect:/complete";
	}
}
