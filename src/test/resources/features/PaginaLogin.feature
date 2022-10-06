Feature:  Login con usuario y contraseña descripcion opcional de la funcion
  #@test
 #Scenario: Cliente se logea en la pagina principal ingresando su contraseña correcta
  #  Given El cliente se encuentra en la pantalla de logeo
   # Then  Cargo la información del DOM tienda_registro.json

  @skip
 # Scenario: Cliente se logea en la pagina principal ingresando su contraseña correcta
   # Given El ciente intresa al sitio http://automationpractice.com/index.php
    #When  selecciona contactar a la tienda y envia un mensaje a la tienda
    #Then  ve el mesaje de confirmacion

  Scenario: Registrarse
    Given El ciente intresa al sitio http://automationpractice.com/index.php
    When   el usuario registra su correo y ve el formulario de registro
    And    diligencia el formulario de registro


