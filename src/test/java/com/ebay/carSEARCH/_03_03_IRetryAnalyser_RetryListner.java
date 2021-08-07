package com.ebay.carSEARCH;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class _03_03_IRetryAnalyser_RetryListner implements IAnnotationTransformer {

	public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2, Method arg3) {
		// TODO Auto-generated method stub
		
		//arg0.getRetryAnalyzerClass();
		
		arg0.setRetryAnalyzer(_03_04_IRetryAnalyser_Retry.class);
		
		/*Class<? extends IRetryAnalyzer> analyzer = arg0.getRetryAnalyzerClass();
		if (analyzer == null) {
			arg0.setRetryAnalyzer(Retry.class);
		}*/

	}

}
