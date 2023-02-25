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
