fruits = {
    "apple" : 80,
    "papaya": 30,
    "pineapple": 40,
    "guava": 20
}

search_term = input("What fruit would you like? ")

if(search_term in fruits):
    print(search_term + " costs " + str(fruits[search_term]) + " rupees")
else:
    print("Fruit out of stock")