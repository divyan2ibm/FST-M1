from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time


driver = webdriver.Firefox()


wait = WebDriverWait(driver, 20)


driver.get("http://alchemy.hguy.co/orangehrm")


driver.find_element(By.ID, "txtUsername").send_keys("orange")
driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
driver.find_element(By.ID, "btnLogin").click()


wait.until(EC.element_to_be_clickable((By.XPATH, "/html/body/div[1]/div[2]/ul/li[6]/a/b"))).click()


wait.until(EC.element_to_be_clickable((By.XPATH, "/html/body/div[1]/div[3]/div/div[2]/div[2]/form/fieldset/p/input"))).click()


wait.until(EC.element_to_be_clickable((By.ID, "btnSave"))).click()


firstName = driver.find_element(By.ID, "personal_txtEmpFirstName")
lastName = driver.find_element(By.ID, "personal_txtEmpLastName")
gender = driver.find_element(By.ID, "personal_optGender_1")  
nationality = driver.find_element(By.ID, "personal_cmbNation")
dob = driver.find_element(By.ID, "personal_DOB")


firstName.clear()
firstName.send_keys("Divya")
lastName.clear()
lastName.send_keys("N")


if not gender.is_selected():
    gender.click()


nationalityOption = nationality.find_element(By.XPATH, "//option[contains(text(),'Indian')]")
nationalityOption.click()


dob.clear()
dob.send_keys("1990-01-01")


driver.find_element(By.ID, "btnSave").click()


driver.quit()
