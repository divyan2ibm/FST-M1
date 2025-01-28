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


wait.until(EC.element_to_be_clickable((By.ID, "menu_pim_viewMyDetails"))).click()


wait.until(EC.element_to_be_clickable((By.XPATH, "//a[contains(text(),'Emergency Contacts')]"))).click()


rows = driver.find_elements(By.XPATH, "//table[@id='emgcontact_list']//tbody/tr")

print("Emergency Contacts Information:")
for row in rows:
    cells = row.find_elements(By.TAG_NAME, "td")
    print("\t".join([cell.text for cell in cells]))

driver.quit()
