import time

from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait

chrome_driver_path = "C:/chromedriver-win64/chromedriver.exe"

chrome_options = webdriver.ChromeOptions()
chrome_options.binary_location = "C:/Program Files/Google/Chrome/Application/chrome.exe"

chrome_options.add_argument(f"chromedriver_path={chrome_driver_path}")

driver = webdriver.Chrome(options=chrome_options)

driver.get("http://localhost:4200")

element = driver.find_element(By.ID, "IniciaSesionBtn")
actions = ActionChains(driver)
element.click()

wait = WebDriverWait(driver, 10)
votante_btn = wait.until(EC.element_to_be_clickable((By.ID, "votanteBtn")))
votante_btn.click()

text_field_email = wait.until(
    EC.presence_of_element_located((By.ID, "email"))
)
text_field_email.send_keys("dummie@mail.com")

text_field_password = wait.until(
    EC.presence_of_element_located((By.ID, "password"))
)
text_field_password.send_keys("DUMMIE123")

registrar = wait.until(EC.element_to_be_clickable((By.ID, "enviarlo")))
registrar.click()

time.sleep(5)

votar_cancion = wait.until(EC.element_to_be_clickable((By.ID,"votarCnBtn")))
votar_cancion.click()

wait.until(EC.presence_of_all_elements_located((By.CSS_SELECTOR, '.canciones-container .votos-container')))

votar_button = driver.find_element(By.XPATH, "//div[@class='cancion-item'][p='Canción 1']//button[text()='Votar']")
votar_button.click()

time.sleep(5)

driver.quit()