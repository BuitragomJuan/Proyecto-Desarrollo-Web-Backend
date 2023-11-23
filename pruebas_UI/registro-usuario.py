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

time.sleep(5)

wait = WebDriverWait(driver, 10)
votante_btn = wait.until(EC.element_to_be_clickable((By.ID, "votanteBtn")))
votante_btn.click()

time.sleep(5)

register = wait.until(EC.element_to_be_clickable((By.ID, "registro")))
register.click()

time.sleep(5)

text_field_id = WebDriverWait(driver, 10).until(
    EC.presence_of_element_located((By.ID, "id"))
)
text_field_id.send_keys("00011")

time.sleep(2)

text_field_nombre = WebDriverWait(driver, 10).until(
    EC.presence_of_element_located((By.ID, "nombre"))
)
text_field_nombre.send_keys("Dummie")

time.sleep(2)

text_field_correo = WebDriverWait(driver, 10).until(
    EC.presence_of_element_located((By.ID, "correo"))
)
text_field_correo.send_keys("dummie@mail.com")

time.sleep(2)

text_field_password = WebDriverWait(driver, 10).until(
    EC.presence_of_element_located((By.ID, "password"))
)
text_field_password.send_keys("DUMMIE123")

registrar = wait.until(EC.element_to_be_clickable((By.ID, "crearBtn")))
registrar.click()

time.sleep(10)

driver.quit()
