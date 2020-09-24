def factorial(n):
	if (n == 0):
		return 1
	return n * factorial(n - 1)

print(factorial(3))

#fibonacci

#fibonacci = 1, 1, 2, 3, 5, 8 ... N + N-1

def fib(n):
	if(n == 1 or n == 2):
		return 1
	return fib(n - 1) + fib(n - 2)

print(fib(6))

'''
F(6) = f5 + f4
f6 = f5-1 + f5-2 + f4-1 + f4-2
f6 = f4 + f3 + f3 + f4-2
f6 = f4-1 + f4-2 + f3-1 + f3-2 + f3-1 + f3-2 + f2-1 + f2-2
f6 = f3 + f2 + f2 + f1 + f2 + f1 + f1 + f0
f6 = (f3-1 +f3-2) + (f2-1 + f2-2) + (f2-1 + f2-2) + (1) + (f2-1 + f2-2) + 1 + 1
f6 = f2 + f1 + f1 + f0 + f1 + f0 + 1 + f1 + f0 + 1 + 1
f6 = f2 + 1 + 1 + 1 + 1 + 1 + 1 + 1

f6 = f5 + f4
f6 = [f5-1 + f5-2] + (f4-1 + f4-2)
f6 = [f4 + f3] + (f3 + f2 = 1)
f6 = [f3 + 1] + [1 + 1] + (1 + 1 + 1)
f6 = [f3-1 + f3-2]

f4 = f3 + f2 = 1.
f4 = [f3 - 1 + f3 - 2] + 1
f4 = f2 = 1 + f1 = 1 + 1 = 3
'''

def pot(base, exp):

	if(exp == 0):
		return 1
	return base * pot(base, exp - 1)

print(pot(2, 3))

'''
2 * (2, 2)
2 * 2 (1)
2 * 2 * 2 * 1
'''