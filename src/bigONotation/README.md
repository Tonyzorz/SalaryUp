https://www.youtube.com/watch?v=Mo4vesaut8g&ab_channel=freeCodeCamp.org

8/13/2021 = 38:45 


what is big o notation 
- used to measure efficence while it reaches infinity

ex. # of patients * 30 
	which means linear 
	which is Big O(n) 
	n means = # of patients 
	
when considering efficency of a function, a constant time is ignored 

So then what is considered to be constant? 
	- constant is any function that does not scale with given input 
	ex. var result = 100 * 1000     == will always result 100,000
	
	Constants are Big O(1)
	

Orders to Growth 

O(1)		Constant			goood
O(log n)	Logarithmic
O(n)		Linear
O(n log n)	Linearithmic
O(n^2)		Quadratic
O(n^3)		Cubic
O(2^n)		Exponential
O(n!)		Factorial 			bad

O(1) constant time , O(n) linear time 
=========================================

	function linearFunc(arr) {
		
		for (int i = 0; i < arr.length; i++) {      // O(n)
			console.log(100 * 1000);				// O(1)
			let something = (200000000000) / 2;		// O(1)
			console.log(something);					// O(1)
		}
	}
	
	O(n) + O(1) + O(1) + O(1) = O(3n) but only worst cases are considered so
							  = O(n) 
							  
						
					
O(n^2)	Quadratic
===========================================

	function square(n) {
		for (let i = 0; i < n; i++) {
			for (let j = 0; j < n; j++) {
				console.log(i, j);
			}
		}
	}
					
O(n^3) cubic(cubed) 
======================================					

	function cube(n) {
		for (let i = 0; i < n; i++) {
			for (let j = 0; j < n; j++) {
				for (let k = 0; k < n; k++) {
					console.log(i, j);
				}
			}
		}
	}					
					
					
O(log n) logarithms					
======================================					
		
		number ^ number = some number
		2	^ number = 8;
		
		Log2 8 = ? 
		Log base 2 of 8 is 3;

	function logFunc(n) {
	
		if (n == 0) return "done";
		n = Math.floor(n / 2);
		return logFunc(n);
		
	}
					
	or 
	
	function logn(n) {
	
		while (n > 1) {
			n = Math.floor(n/2);
		}
	}				
	
	iteration 1 : n = 8/2 = 4
	iteration 2 : n = 4/2 = 2
	iteration 3 : n = 2/2 = 1
	
	O(log8) = O(log base 2 of 8)				
					

Binary Search & O(log n)
===================================
					
	1. must be ordered array 
					
		Since it divides by half continuously, it is log n 
		
					
					
					
					
					
					
					
						  