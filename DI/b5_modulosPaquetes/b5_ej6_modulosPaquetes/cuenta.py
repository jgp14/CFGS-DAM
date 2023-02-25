from b5_ej6_modulosPaquetes.persona import *

class Cuenta():
    
    def __init__(self, titular, cantidad=0):
        self.__titular = titular
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
