# Traversing tables
# Goal: Open the leads page and print the usernames and full names from the table


# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

# Start the Driver
with webdriver.Chrome() as driver:
  
#  Navigate to ‘http://alchemy.hguy.co/crm’
    driver.get("https://alchemy.hguy.co/crm/")

# Find the username field
    username = driver.find_element(By.ID, "user_name")
# Find the password field
    password = driver.find_element(By.ID, "username_password")

# Enter the given credentials
# Enter username
    username.send_keys("admin")
# Enter password
    password.send_keys("pa$$w0rd")

#Find the submit button and click it
    submit = driver.find_element(By.XPATH, "//input[@type='submit']")
    submit.click()

# Print the login message
    homePageHeader = driver.find_element(By.ID,"tab0").text
# print(homePageHeader)
    if(homePageHeader=="SUITECRM DASHBOARD"):
        print("Home Page Opened Successfully !")
    else:
        print("Login Failed !")

# Navigate to the Sales -> Leads page
    driver.fullscreen_window()
    driver.find_element(By.ID,"grouptab_0").click()
    driver.find_element(By.ID,"moduleTab_9_Leads").click()
    time.sleep(2)
# Find the table on the page and print the names of the first 5 odd-numbered rows of the table to the console
    print("The first ten Leads names and users are : ")
    leadsNames = driver.find_elements(By.XPATH,"//table[@class='list view table-responsive']/tbody/tr/td[3]")
    leadsUsers = driver.find_elements(By.XPATH,"//table[@class='list view table-responsive']/tbody/tr/td[8]")
    for x in range(0, 10, 1):
        print(x+1,leadsNames[x].text,":",leadsUsers[x].text)
    
#Close the browser
    driver.quit()