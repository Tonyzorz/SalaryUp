최소공배수 = lcd 
최대공약수 = gcd

formula = 

   a x b = LCM(a, b) * GCD (a, b)

   LCM(a, b) = (a x b) / GCD(a, b)
   
 	/*
	 * Let we have to find the LCM of 
		arr[] = {1, 2, 3, 4, 28}
		
		We initialize result = 1.
		
		2 is a common factor that appears in
		two or more elements. We divide all
		multiples by two and multiply result
		with 2.
		arr[] = {1, 1, 3, 2, 14}
		result = 2
		
		2 is again a common factor that appears 
		in two or more elements. We divide all
		multiples by two and multiply result
		with 2.
		arr[] = {1, 1, 3, 1, 7}
		result = 4
		
		Now there is no common factor that appears
		in two or more array elements. We multiply
		all modified array elements with result, we
		get.
		result = 4 * 1 * 1 * 3 * 1 * 7
		       = 84

	 */