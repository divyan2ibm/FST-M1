from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()

wait = WebDriverWait(driver, 20)

driver.get("http://alchemy.hguy.co/orangehrm")

driver.find_element(By.ID, "txtUsername").send_keys("orange")
driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
driver.find_element(By.ID, "btnLogin").click()

wait.until(EC.element_to_be_clickable((By.XPATH, "//b[text()='My Info']"))).click()

wait.until(EC.element_to_be_clickable((By.XPATH, "//a[text()='Qualifications']"))).click()

wait.until(EC.element_to_be_clickable((By.ID, "addWorkExperience"))).click()

driver.find_element(By.ID, "experience_employer").send_keys("OpenAI Inc.")
driver.find_element(By.ID, "experience_jobtitle").send_keys("AI Specialist")
driver.find_element(By.ID, "experience_from_date").clear()
driver.find_element(By.ID, "experience_from_date").send_keys("2020-01-01")
driver.find_element(By.ID, "experience_to_date").clear()
driver.find_element(By.ID, "experience_to_date").send_keys("2023-01-01")
driver.find_element(By.ID, "experience_comments").send_keys("Worked on developing advanced AI systems.")

driver.find_element(By.ID, "btnWorkExpSave").click()

driver.quit()
