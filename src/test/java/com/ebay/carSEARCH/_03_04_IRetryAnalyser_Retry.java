package com.ebay.carSEARCH;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class _03_04_IRetryAnalyser_Retry implements IRetryAnalyzer {

	int retrycount = 0;
	int max_retry_count = 2;

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (retrycount < max_retry_count) {
			System.out.println("Retrying test " + result.getName() + " with status "
					+ getResultStatusName(result.getStatus()) + " for the " + (retrycount + 1) + " time(s).");
			System.out.println(result.getStatus());
			retrycount++;
			return true;
		}

		return false;
	}

	public String getResultStatusName(int status) {
		String resultName = null;
		if (status == 1)
			resultName = "SUCCESS";
		if (status == 2)
			resultName = "FAILURE";
		if (status == 3)
			resultName = "SKIP";
		return resultName;
	}
}
