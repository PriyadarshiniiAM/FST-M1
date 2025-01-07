#import pandas
import pandas as pd

#create a dictionary to hold our data
data = {
    "Usernames": ["admin", "charles", "deku"],
    "Passwords" : ["password", "Charl23", "AlMighty"],
}

#convert dictionary of lists to dataFrame
dataFrame = pd.DataFrame(data)

#Write dataFrame to CSV file
dataFrame.to_csv("activities/outputs/sample.csv", index=False)
	
# Read the CSV file and store it into a DataFrame
creds = pd.read_csv("activities/outputs/sample.csv")
	
# Print the full data
print("Full Data: ")
print(dataFrame)
	
# Print the values in the Usernames column only
print("===============")
print("Usernames:")
print(dataFrame["Usernames"])

	
# Print the username and password of the second row
print("===============")
print("Username: ", dataFrame["Usernames"][1], " | ", "Password: ", dataFrame["Passwords"][1])
 
#Sort the Usernames column in ascending order
print("====================================")
print("Data sorted in ascending Usernames:")
print(dataFrame.sort_values('Usernames'))
 
#Sort the Passwords column in descending order
print("====================================")
print("Data sorted in descending Passwords:")
print(dataFrame.sort_values('Passwords', ascending=False))