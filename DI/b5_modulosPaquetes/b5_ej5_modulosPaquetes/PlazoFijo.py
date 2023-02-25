from b5_ej5_modulosPaquetes.Cuenta  import *

class PlazoFijo(Cuenta):
    
    def __init__(self, titular, cantidad, plazo, interes):
        super().__init__(titular, cantidad)
        self.__plazo = plazo
        self.__interes = interes

    @property
    def plazo(self):
        return self.__plazo
    
    @property
    def interes(self):
        return self.__interes

    @plazo.setter
    def plazo(self, plazo):
        self.__plazo = plazo

    @interes.setter
    def interes(self, interes):
        self.__interes = interes

    def calcImporte(self):      
        cantidad = self.cantidad      
        interes = self.interes
        importe = ((cantidad * interes)/100)
        return importe

    def printDataPlazoFijo(self):        
        super().printDataCuenta()
        print("Plazo: "+str(self.plazo))
        print("Interes:"+str(self.__interes))
        print("Importe: "+str(self.calcImporte()))