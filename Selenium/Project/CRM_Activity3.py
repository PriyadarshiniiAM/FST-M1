# Get the copyright text
# Goal: Print the first copyright text in the footer to the console

# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:

# Navigate to the URL
    driver.get("http://alchemy.hguy.co/crm")
    driver.maximize_window()

# Get the first copyright text in the footer
    copyrightText = driver.find_element(By.ID, "admin_options").text
# Print the text to the console.
    print("The Copyright text in the Footer is : ", copyrightText)

#close the browser
    driver.quit()