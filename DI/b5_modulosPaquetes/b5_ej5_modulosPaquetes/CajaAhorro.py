from b5_ej5_modulosPaquetes.Cuenta import *

class CajaAhorro(Cuenta):
    
    def __init__(self, titular="", cantidad=0):
        super().__init__(titular, cantidad)

    def printDataCajaAhorro(self):
        super().printDataCuenta()