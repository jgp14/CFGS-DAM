#Boletin 5. Programacion Orientada a Objetos

#EJERCICIO 5
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
    
class CajaAhorro(Cuenta):
    def __init__(self, titular="", cantidad=0):
        super().__init__(titular, cantidad)

    def printDataCajaAhorro(self):
        super().printDataCuenta()

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
       

def e5():
    cuenta = Cuenta("ClienteCuenta", 1000)
    cuenta.printDataCuenta()

    cajaAhorro = CajaAhorro("ClienteAhorro", 1200)
    cajaAhorro.printDataCajaAhorro()

    plazoFijo = PlazoFijo("ClientePlazo", 2000, 120, 2)   
    plazoFijo.printDataPlazoFijo()
e5()