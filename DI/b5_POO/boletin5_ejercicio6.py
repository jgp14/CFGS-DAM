#Boletin 5. Programacion Orientada a Objetos

#EJERCICIO 6

class Persona():

    def __init__(self, nombre, edad, dni):
        self.__nombre = nombre
        self.__edad = setInt(edad)
        self.__dni = dni

    #Getters y Setters
    @property
    def nombre(self):
        return self.__nombre
    
    @property
    def edad(self):
        return self.__edad

    @property
    def dni(self):
        return self.__dni

    @nombre.setter
    def nombre(self, nombre):
        self.__nombre = nombre

    @edad.setter
    def edad(self, edad):
        self.__edad = setInt(edad)

    @dni.setter
    def dni(self, dni):
        self.__dni = dni

    def mostrar(self):        
        print("Nombre: "+self.__nombre)
        print("Edad: "+str(self.__edad))
        print("DNI: "+self.__dni)
    
    def esMayorDeEdad(self):
        mayor = False
        if self.__edad >= 18:
            mayor = True
        return mayor

def setInt(enter): #Metodo para aceptar solo enteros
    try:
        i = int(enter)
    except ValueError:
        print("Error: valor de entrada no es un numero entero")
        i = 0
    return i

def edadValida():
    edad = 0
    while edad < 1 or edad > 110:
        edadS = input("Dime la edad: ")
        edad = setInt(edadS)
    return edad

class Cuenta():
    
    def __init__(self, titular, cantidad=0):
        self.__titular=titular
        self.__cantidad = setFloat(cantidad)

    #Getters y Setters
    @property
    def titular(self):
        return self.__titular

    @titular.setter
    def titular(self, titular):
        self.__titular = titular

    @property
    def cantidad(self):
        return self.__cantidad

    @cantidad.setter
    def cantidad(self, cantidad):
        self.__cantidad = setFloat(cantidad)

    def mostrar(self):
        self.__titular.mostrar() #Titular
        print("Cantidad: "+str(self.__cantidad))

    def ingresar(self):
        enter = input("Dime una cantidad a ingresar: ")
        cantidad = setFloat(enter)
        if cantidad > 0:
            self.__cantidad = self.__cantidad + cantidad

    def retirar(self):   
        enter = input("Dime una cantidad a retirar: ")
        cantidad = setFloat(enter)
        self.__cantidad = self.__cantidad - cantidad    

def setFloat(enter): #Metodo para aceptar solo decimales
    try:                    
        f = float(enter)
    except ValueError:
        print("Error: valor de entrada no es un numero decimal")
        f = 0.0
    return f

class CuentaJoven(Cuenta):
    def __init__(self, titular, cantidad=0, bonificacion=0):
        super().__init__(titular, cantidad)
        self.__bonificacion = setInt(bonificacion)

    @property
    def bonificacion(self):
        return self.__bonificacion

    @bonificacion.setter
    def bonificacion(self, bonificacion): 
        self.__bonificacion = setInt(bonificacion)

    def esTitularValido(self):
        valido = False
        edad = self.titular.edad
        if (edad >= 18 and edad < 25):
            valido = True
        return valido

    def retirar(self):
        if self.esTitularValido() is True:
            super().retirar()
        else:
            print("Titular de cuenta joven invalida")

    def mostrar(self):
        print("\nCuenta Joven")
        super().mostrar()
        print("Bonificacion: "+str(self.__bonificacion))

def e6():
    nombre = input("Dime el nombre: ")
    edad = edadValida()
    dni = input("Dime el DNI: ")

    persona1 = Persona(nombre, edad, dni)
    print("\nPersona")
    persona1.mostrar()

    print("\nCuenta Basica")
    cantidad = setFloat(input("Dime el saldo de cuenta: "))
    cuenta = Cuenta(persona1, cantidad)    
    cuenta.ingresar()
    cuenta.retirar()    
    cuenta.mostrar()

    print("\nCuenta Joven")
    bonus = setInt(input("Dime '%' de bonoificacion: "))
    cuentaJoven = CuentaJoven(persona1, cantidad, bonus)
    cuentaJoven.retirar()
    cuentaJoven.mostrar()
e6()