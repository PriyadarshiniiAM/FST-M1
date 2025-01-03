name = input("Enter your name: ")
age = int(input("Enter your age: "))
result = name + ", you will turn 100 in {}".format((2025 - age) + 100)
print(result)