package com.ce.app.student.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
	private int no;
	private String name;
	private String tel;
	private LocalDateTime createdAt; // mybatis가 변환작업을 자동으로 잘해주기 때문에 java.sql.Date 대신 java.time.~ 이용!
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;
}
