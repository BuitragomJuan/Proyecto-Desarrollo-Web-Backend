import time

from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import Select, WebDriverWait

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
admon_btn = wait.until(EC.element_to_be_clickable((By.ID, "admonBtn")))
admon_btn.click()

text_field_email = wait.until(
    EC.presence_of_element_located((By.ID, "email"))
)
text_field_email.send_keys("dummie1@mail.com")

text_field_password = wait.until(
    EC.presence_of_element_located((By.ID, "password"))
)
text_field_password.send_keys("DUMMIE123")

registrar = wait.until(EC.element_to_be_clickable((By.ID, "enviarlo")))
registrar.click()

time.sleep(3)

buscar_cancion = wait.until(EC.element_to_be_clickable((By.ID,"gestCan")))
buscar_cancion.click()

time.sleep(3)

text_field_nombre = wait.until(
    EC.presence_of_element_located((By.ID, "nombre"))
)
text_field_nombre.send_keys("Eventually")

text_field_genero = wait.until(
    EC.presence_of_element_located((By.ID, "genero"))
)
text_field_genero.send_keys("Pop")

text_field_rating = wait.until(
    EC.presence_of_element_located((By.ID, "rating"))
)
text_field_rating.send_keys("4")

text_field_artista = wait.until(
    EC.presence_of_element_located((By.ID, "artista"))
)
text_field_artista.send_keys("Tame")

text_field_album = wait.until(
    EC.presence_of_element_located((By.ID, "album"))
)
text_field_album.send_keys("Currents")

select_element = driver.find_element(By.ID, "listaId")
select = Select(select_element)
select.select_by_visible_text("1 - pop")

time.sleep(3)

crear = wait.until(EC.element_to_be_clickable((By.ID,"crear")))
crear.click()

time.sleep(7)
driver.quit()
