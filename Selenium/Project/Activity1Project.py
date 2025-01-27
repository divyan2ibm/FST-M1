from selenium import webdriver

driver = webdriver.Firefox()

driver.get("http://alchemy.hguy.co/orangehrm")

page_title = driver.title

print(f"Page title is: {page_title}")

assert page_title == "OrangeHRM", "Title does not match. Test Failed."

driver.quit()
