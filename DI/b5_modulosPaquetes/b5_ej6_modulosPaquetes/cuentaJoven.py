from b5_ej6_modulosPaquetes.cuenta import *
from b5_ej6_modulosPaquetes.persona import * 

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

    def getTitular(self):
        return super().titular
        
    def esTitularValido(self):
        valido = False
        edadValidad = self.getTitular().edad
        if (edadValidad >= 18 and edadValidad < 25):
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
