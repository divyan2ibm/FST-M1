from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()

driver.get("http://alchemy.hguy.co/orangehrm")

driver.find_element(By.XPATH, "//*[@id='txtUsername']").send_keys("orange")

driver.find_element(By.XPATH, "//*[@id='txtPassword']").send_keys("orange123")

driver.find_element(By.XPATH, "//*[@id='btnLogin']").click()

welcome_text = driver.find_element(By.ID, "welcome").text
if "Welcome" in welcome_text:
    print("Login successful! Homepage loaded.")
else:
    print("Login failed! Homepage did not load.")

driver.quit()
