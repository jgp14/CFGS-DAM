class Cuenta:

    def __init__(self, titular="",cantidad=0):
        self.__titular = titular
        self.__cantidad = cantidad

    #getters y setters
    @property
    def titular(self):
        return self.__titular
    
    @property
    def cantidad(self):
        return self.__cantidad

    @titular.setter
    def titular(self, titular):
        self.__titular=titular

    @cantidad.setter
    def cantidad(self, cantidad):
        self.__cantidad=cantidad
    
    def printDataCuenta(self):
        print("Titular: "+self.titular)
        print("Cantidad: "+str(self.cantidad))