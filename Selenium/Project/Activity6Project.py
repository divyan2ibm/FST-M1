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


directoryMenuItem = driver.find_element(By.XPATH, "//b[contains(text(),'Directory')]")


wait.until(EC.visibility_of(directoryMenuItem))
wait.until(EC.element_to_be_clickable(directoryMenuItem))


if directoryMenuItem.is_displayed() and directoryMenuItem.is_enabled():
    directoryMenuItem.click()


heading = driver.find_element(By.TAG_NAME, "h1")
if heading.text == "Search Directory":
    print("Heading verified:", heading.text)
else:
    print("Heading mismatch:", heading.text)

driver.quit()
