class Car:
    'This class is for activity 16'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color
    def accelerate(self):
        print(self.manufacturer + self.model + " has started moving")
    
    def stop(self):
        print(self.manufacturer + self.model + " has stopped moving")

car1 = Car("Toyota", "Glanza", "2014", "Manual", "Red")
car2 = Car("Maruti", "Espresso", "2015", "Automatic", "Grey")
car3 = Car("Nissan", "Magnite", "2023", "Automatic", "Brown")

car2.accelerate()
car1.stop()