# Goal: Read the title of the website and verify the text

# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

    # Start the Driver
with webdriver.Firefox() as driver:

    # Navigate to the URL
    driver.get("http://alchemy.hguy.co/crm")
    driver.maximize_window()

    # Get  the title of the page and verify it
    if(driver.title=="SuiteCRM"):
        print ("The Page title is : ",driver.title)
    else:
         print ("Wrong Website ")

    #close the browser
    driver.quit()