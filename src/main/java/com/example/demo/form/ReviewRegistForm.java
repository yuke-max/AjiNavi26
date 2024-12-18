package com.example.demo.form;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class ReviewRegistForm {
	@NotNull(message = "入力してください。")
	@Min(value = 1,message = "正の整数を入力してください。")
	private Integer restaurantId;
	
	private String restaurantName;
	
	@Size(min = 4,max = 16,message = "4文字から16文字で指定してください。")
	private String userId;
	
	@Past(message = "今日以前の日付を入力してください。")
	private Date visitDate;
	
	@NotNull(message = "入力してください。")
	@Min(value = 1,message = "1-5で入力してください。")
	@Max(value = 5,message = "1-5で入力してください。")
	private Integer rating;
	
	@Size(min = 1,max = 128,message = "1文字から128文字で入力してください。")
	private String 	comment;

}
