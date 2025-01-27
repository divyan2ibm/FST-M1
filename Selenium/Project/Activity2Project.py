from selenium import webdriver

driver = webdriver.Firefox()

driver.get("http://alchemy.hguy.co/orangehrm")

header_image = driver.find_element("xpath", "//*[@id='divLogo']/img")
image_url = header_image.get_attribute("src")

print(f"Header image URL is: {image_url}")

driver.quit()
