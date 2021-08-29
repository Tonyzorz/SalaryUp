https://www.youtube.com/watch?v=D6Q_wHrzxDs&ab_channel=Geek%27sLesson

Guiding Principles # 1
- worst-case analysis : our running time bound holds for every input of length n;
- particulary appropriate for general-purpose routines

	as opposed to 
- average-case analysis
- bench marks : typical inputs 
	requires domain knowledge, what inputs require more time etc 
	
	bonus : worst case usually easier to analyze.
	
Guiding Principles # 2

won't pay much  attention to constant factors, lower-order terms. 

Justifications : can we get away with it? 
1. way easier, dont have to calculate very precisely, rough estimate will do 
2. constants depend on architecture/compiler/programmer anways
3. lose very little predictive power 
	

Guiding Principles # 3
Asymptotic analysis : focus on running time for large input sizes of n 

e.g. : 6n log base of 2 n + 6n is better than quadratic dependent number 

Justification : only big problems are interesting, 100 numbers is simply just too small to see 
subtle difference between algorithmic analysis


what is a "fast" algorithm? 

fast algorithm = worst-case running time grows slowly with input size

e.g. : divide and conquer algorithms

Holy grail : linear running time (or close to it) O(n)

Big-Oh: english definition 

let T(n) = function or n = 1,2,3...
Q: When is T(n) = O(f(n))?
A: if eventually (for all sufficiently large n), T(n) is bounded above 
by a constant multiple of f(n).

01:27:33 

















	