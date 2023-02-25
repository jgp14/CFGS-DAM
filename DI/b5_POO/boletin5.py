#Boletin 5. Programacion Orientada a Objetos
import sys

#EJERCICIO 1
class Alumno(): #Clase alumno
    def __init__(self,nombre="",nota=0):  #Constructor
      self.__nombre=nombre
      self.__nota=nota

    @property
    def nombre(self): #getter Nombre
        return self.__nombre

    @property
    def nota(self):  #getter Nota
        return self.__nota

    @nombre.setter
    def nombre(self, nombre): #setter Nombre
        self.__nombre = nombre

    @nota.setter
    def nota(self, nota): #setter Nota
        self.__nota=nota

    def isApproved(self): #Si aprobado true o false
        if self.nota >= 5:
            passed = True
        return passed
        
    def showApproved(self): #Mostrar si aprobado
        aprobado = self.isApproved()
        print(self.nombre, end=" ")
        if aprobado == True:
            print(f'aprobo su nota es {self.nota}')
        else:
            print(f'no aprobo su nota es {self.nota}')

def setFloat(enter): #Metodo para aceptar solo decimales
    try:                    
        f = float(enter)
    except ValueError:
        print("Error: valor de entrada no es un numero decimal")
        f = 0
    return f

#metodo para saber si el alumno aprobo o no
def e1():
    nombre = input("Dime nombre del alumno: ") 
    nota = 0
    while nota <= 1 or nota > 10:
        notaString = input("Dame nota del alumno "
        +nombre+" (1-10): ")
        nota = setFloat(notaString)
    alumno1 = Alumno(nombre, nota)
    alumno1.showApproved()
#e1()

#EJERCICIO 2
class Persona(): #Clase Persona
    def __init__(self, nombre, edad): #Constructor
        self.__nombre = nombre
        self.__edad = edad

    @property
    def getNombre(self): #getter Nombre
        return self.__nombre

    @property
    def getEdad(self):  #getter edad
        return self.__edad

    def setNombre(self, nombre): #setter Nombre
        self.__nombre=nombre

    def setEdad(self, edad): #setter Edad
        self.__edad=edad

    def isMayor(self):
        mayor = False
        if(self.__edad >= 18):
            mayor = True
        return mayor
        
    def showMayorEdad(self):
        adulto = self.isMayor()
        print(self.__nombre+" es", end=" ")
        if adulto == True:
            print(f'mayor de edad y con {self.__edad} años')
        else:
            print(f'menor de edad y con {self.__edad} años')

def setInt(enter): #Metodo para aceptar solo enteros
    try:
        i = int(enter)
    except ValueError:
        print("Error: valor de entrada no es un numero entero")
        i = -sys.maxsize
    return i

def e2():
    nombre = input("Dime nombre de la persona: ") 
    edad = 0
    while edad < 1 or edad > 110:
        edadS = input("Dime edad de "+nombre+": ")
        edad = setInt(edadS)
    persona = Persona(nombre, edad)
    persona.showMayorEdad()
#e2()

#EJERCICIO 3
class Triangulo():

    def __init__(self, ladoA, ladoB, ladoC, tipo="escaleno"):
        self.__ladoA = ladoA
        self.__ladoB = ladoB
        self.__ladoC = ladoC
        self.__tipo = tipo
    
    #getters atributos lados
    @property
    def ladoA(self):
        return self.__ladoA

    @property
    def ladoB(self):
        return self.__ladoB
    
    @property
    def ladoC(self):
        return self.__ladoC

    @property
    def tipo(self):
        return self.__tipo

    #setters atributos lados
    @ladoA.setter
    def ladoA(self, ladoA):
        self.__ladoA = ladoA

    @ladoB.setter
    def ladoB(self, ladoB):
        self.__ladoB = ladoB
    
    @ladoC.setter
    def ladoC(self, ladoC):
        self.__ladoC = ladoC

    def tipoTriangulo(self):
        tipo = ""
        if (self.ladoA == self.ladoB 
        and self.ladoB == self.ladoC):
            tipo = "equilatero"
        elif (self.ladoA == self.ladoB 
        or self.ladoB == self.ladoC
        or self.ladoA == self.ladoC ):
            tipo = "isosceles"
        else:
            tipo = "escaleno"
        return tipo  

def e3():
    print("Datos de un triangulo")
    ladoA = 0; ladoB = 0; ladoC = 0
    while ladoA <= 0 or ladoB <= 0 or ladoC <= 0:
        ladoA = setFloat(input("Dime lado A del triangulo: "))
        ladoB = setFloat(input("Dime lado B del triangulo: "))
        ladoC = setFloat(input("Dime lado C del triangulo: "))
    triangulo = Triangulo(ladoA, ladoB, ladoC)
    print("El triangulo es de tipo",triangulo.tipoTriangulo())
#e3()

#EJERCICIO 4
class Calculo():

    def __init__(self):
        self.__n1 = self.setNumero()
        self.__n2 = self.setNumero()
        
    def setNumero(self): #Metodo para introducir entero
        n = 0
        while n == 0:
            n = setInt(input("Dime un numero entero: "))
        return n
    
    #Getters
    @property
    def n1(self):
        return self.__n1

    @property
    def n2(self):
        return self.__n2

    #Setters
    @n1.setter
    def n1(self, n1):
        self.__n1 = n1

    @n2.setter
    def n2(self, n2):
        self.__n2 = n2

    def sumar(self):
        return self.n1 + self.n2
    
    def restar(self):
        return self.n1 - self.n2

    def multiplicar(self):
        return self.n1 * self.n2

    def dividir(self):
        return self.n1 / self.n2

def e4():
    print("Calculos de operaciones con dos numeros: ")
    calculo = Calculo()
    print("Sumar: "+str(calculo.sumar())+
    "\nRestar: "+str(calculo.restar())+
    "\nMultiplicar: "+str(calculo.multiplicar())+
    "\nDividir: "+str(calculo.dividir()))
#e4()

