import pytest

#Addition test
def test_addition():
    #Initialise two numbers
    num1 = 10
    num2 = 25

    #Add them
    sum = num1 + num2
    
    #Assertion
    assert sum == 35

#subtraction test
@pytest.mark.activity_22
def test_subtraction():
    #Initialize two numbers
    num1 = 50
    num2 = 30

    #Subtract them
    minus = num1 - num2

    #Assertion
    assert minus == 20

# Multiplication test
def test_multiplication():
  
	# Initialize two numbers
	num1 = 5
	num2 = 20
    
	# Multiply them
	prod = num1 * num2
 
	# Assertion
	assert prod == 100
 
# Division test
@pytest.mark.activity_22
def test_division():
  
	# Initialize two numbers
	num1 = 100
	num2 = 5
    
	# Divide them
	quot = num1 / num2
 
	# Assertion
	assert quot == 20
