package com.management.tool.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
public class MapValidationErrorUtility {

	public ResponseEntity<?> mapValidationService(BindingResult result)
	{
         Map<String,String> errorMap = new HashMap<String,String>();
		 
		 for(FieldError error: result.getFieldErrors())
		 {
			 errorMap.put(error.getField(),error.getDefaultMessage());
		 }
		 
		 return new ResponseEntity<Map>(errorMap,HttpStatus.BAD_REQUEST);
		
	}
}
