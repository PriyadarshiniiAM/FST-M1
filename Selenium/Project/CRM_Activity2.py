# Get the url of the header image
# Goal: Print the url of the header image to the console

# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

    # Start the Driver
with webdriver.Firefox() as driver:

    # Navigate to the URL
    driver.get("http://alchemy.hguy.co/crm")
    driver.maximize_window()

    #  Get the url of the header image.
    #  Print the url to the console.
    headerImage = driver.find_element(By.XPATH, "//img[@alt='SuiteCRM']")
    actualimageURL = headerImage.get_dom_attribute("src")
    print("The URL of the image is :" +actualimageURL)

    #close the browser
    driver.quit()