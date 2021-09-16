package com.example.commons.dto;


import com.example.employee.enums.SearchOperation;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchCriteria {

	private String key;
	private Object value;
	private SearchOperation operation;

}