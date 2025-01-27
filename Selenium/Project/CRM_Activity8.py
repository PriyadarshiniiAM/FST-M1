# Traversing tables
# Goal: Open the accounts page and print the contents of the table.

# Import 
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver import ActionChains

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

    #Navigate to sales
    wait = WebDriverWait(driver,10)
    wait.until(EC.visibility_of_element_located((By.ID,"grouptab_0")))
    sales = driver.find_element(By.XPATH,"*//a[@id='grouptab_0']")
    actions = ActionChains(driver)
    actions.move_to_element(sales).click().perform()

    #Select accounts option
    driver.find_element(By.XPATH,"*//a[@id='grouptab_0']/following-sibling::ul/li[2]").click()
    wait.until(EC.visibility_of_element_located((By.XPATH,"*//table[contains(@class,'table-responsive')]")))

    #Printing odd rows names from table
    for i in range(1, 11):
        if i % 2 == 1: 
            name_text = driver.find_element(By.XPATH, f"//table[contains(@class,'table-responsive')]/tbody/tr[{i}]/td[3]").text
            print(name_text)

driver.quit()