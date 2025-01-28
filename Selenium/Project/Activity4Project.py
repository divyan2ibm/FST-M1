from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

driver = webdriver.Firefox()


driver.get("http://alchemy.hguy.co/orangehrm")


driver.find_element(By.XPATH, "//*[@id='txtUsername']").send_keys("orange")
driver.find_element(By.XPATH, "//*[@id='txtPassword']").send_keys("orangepassword123")
driver.find_element(By.XPATH, "//*[@id='btnLogin']").click()


time.sleep(2)  
driver.find_element(By.XPATH, "//*[@id='menu_pim_viewPimModule']/b").click()


time.sleep(2)  
driver.find_element(By.XPATH, "//*[@id='btnAdd']").click()


driver.find_element(By.XPATH, "//*[@id='firstName']").send_keys("Divya")
driver.find_element(By.XPATH, "//*[@id='lastName']").send_keys("N")


driver.find_element(By.XPATH, "//*[@id='btnSave']").click()


time.sleep(2)  
driver.find_element(By.XPATH, "//*[@id='menu_pim_viewPimModule']/b").click()
driver.find_element(By.XPATH, "//*[@id='menu_pim_viewEmployeeList']").click()


search_box = driver.find_element(By.XPATH, "//*[@id='empsearch_employee_name_empName']")
search_box.send_keys("Divya N")
search_box.send_keys(Keys.RETURN)


driver.find_element(By.XPATH, "//*[@id='searchBtn']").click()


print("Employee 'Divya N' added successfully.")


time.sleep(2) 
driver.quit()
