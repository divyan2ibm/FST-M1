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

wait.until(EC.element_to_be_clickable((By.ID, "menu_leave_viewLeaveModule"))).click()
wait.until(EC.element_to_be_clickable((By.ID, "menu_leave_applyLeave"))).click()

leave_type_dropdown = driver.find_element(By.ID, "applyleave_txtLeaveType")
leave_type_dropdown.find_element(By.XPATH, "//option[contains(text(),'Annual Leave')]").click()

from_date = driver.find_element(By.ID, "applyleave_txtFromDate")
from_date.clear()
from_date.send_keys("2025-01-30")

to_date = driver.find_element(By.ID, "applyleave_txtToDate")
to_date.clear()
to_date.send_keys("2025-02-02")

comments = driver.find_element(By.ID, "applyleave_txtComment")
comments.send_keys("Taking annual leave for personal reasons.")

driver.find_element(By.ID, "applyBtn").click()


wait.until(EC.element_to_be_clickable((By.ID, "menu_leave_viewMyLeaveList"))).click()


status = driver.find_element(By.XPATH, "//table[@id='resultTable']//tr[1]/td[6]").text
print("Leave Status:", status)

driver.quit()
