# Reading additional information
# Goal: Reading a popup that contains additional information about the account/lead.

# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
import time

# Start the Driver
with webdriver.Firefox() as driver:
# Navigate to the URL
    driver.get("http://alchemy.hguy.co/crm")

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

# Navigate to Sales -> Leads
    driver.fullscreen_window()
    driver.find_element(By.ID,"grouptab_0").click()
    driver.find_element(By.ID,"moduleTab_9_Leads").click()
    time.sleep(2)
    # In the table, find the Additional information icon at the end of the row of the lead
    # information. Click it.
    driver.find_element(By.XPATH,"//span[@title='Additional Details']").click()
    time.sleep(2)
    # Read the popup and print the phone number displayed in it.
    additionalDetailsMobile = driver.find_element(By.XPATH,"//span[@class='phone']").text
    print("The mobile number is :" , additionalDetailsMobile)


    #close the browser
    driver.quit()