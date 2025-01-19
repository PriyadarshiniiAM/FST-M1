# Logging into the site
# Goal: Open the site and login with the credentials provided

# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:
# Navigate to the URL
    driver.get("http://alchemy.hguy.co/crm")
    driver.maximize_window()

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

    #close the browser
driver.quit()
