#EJERCICIO 1
def e1():
    asignaturas = getAsignaturas() #Generar asignaturas
    print("Lista de asignaturas: ")
    print(asignaturas) #Mostrar lista entera
    for i in range(len(asignaturas)):        
        print(asignaturas[i], end=", ")#Mostrar por elementos

def getAsignaturas():  #Metodo Generar asignaturas
    num = 0
    while num < 1:
        enter = input("Dame numero de asignaturas del curso: ")
        num = setInteger(enter) #Solo numeros enteros
    listaCurso = []
    for i in range(num):
        asignatura = input("Dime asignatura: ")
        listaCurso.insert(i, asignatura)
    return listaCurso

def setInteger(enter): #Metodo para aceptar solo enteros
    try:
        i = int(enter)
    except ValueError:
        print("Error: valor de entrada no es un numero entero")
        i = -1
    return i
#e1()


#EJERCICIO 2
def e2():
    modulos = ["AD","DI","EIE","PMDM","PSP", "SGE"]
    notas = listaNotas(modulos) #Generar la lista notas
    print("Lista de notas: ")
    print(notas)
    for i in range(len(notas)):
        print("En "+modulos[i]+" has sacado "+str(notas[i]))

#Metodo para crear lista asignaturas
def listaNotas(asignaturas): 
    n = len(asignaturas)    
    notas = []
    for i in range(n):  
        enter = input("Dime la nota de " 
        + asignaturas[i] +": ")
        nota = float(setFloat(enter))
        if nota >= 0.0 and nota <= 10.0:
            notas.append(round(nota, 2))
        else: 
            while nota < 0 or nota > 10:                
                enter = input("Dime la nota valida de " 
                + asignaturas[i] +" (0 al 10): ") 
                nota = float(setFloat(enter))
                if nota >= 0.0 and nota <= 10.0:
                    notas.append(round(nota, 2))
    return notas

def setFloat(enter): #Metodo para aceptar solo decimales
    try:                    
        f = float(enter)
    except ValueError:
        print("Error: valor de entrada no es un numero decimal")
        f = -1
    return f
#e2()

#EJERCICIO 3
def e3():
    print("Numeros ganadores de la loteria primitiva")    
    premiados = [] 
    n= 6
    number = 1
    for i in range(n):
        enter = input("Dime el numero de primitiva premiado: ")
        number = setInteger(enter)
        if number >= 1 and number <= 49:
            premiados.insert(i, number)
        else:
            while number < 1 or number > 49:
                enter = input("Dime el numero correcto (1 a 49) de primitiva premiado: ")
                number = setInteger(enter)
                if number >= 1 and number <= 49:
                    premiados.insert(i, number)    
    print("\nLista de numeros premiados ordenados de menor a mayor: ")
    premiados.sort()
    for i in range(n):
        print(str(premiados[i]), end=", ")
#e3()

#EJERCICIO 4
def e4():
    print("Lista de numeros del 1 al 10 en orden inverso")
    numeros = []
    enter = input("Dime cantidad de numeros a almacenar: ")
    n = setInteger(enter)
    for i in range(n):
        enter = input("Dime un numero del 1 al 10: ")
        number = setInteger(enter)
        if number >= 1 and number <= 10:
            numeros.insert(i, number)
        else:
            while number < 1 or number > 10:
                print("Numero introducido incorrecto")
                enter = input("Dime un numero del 1 al 10: ")
                number = setInteger(enter)
                if number >= 1 and number <= 10:
                    numeros.append(number)
    print("\nLista de numeros ordenados de mayor a menor: ")
    numeros.sort(reverse=True)
    for i in range(n):
        print(str(numeros[i]), end=", ")  
#e4()

#EJERCICIO 5
def e5():
    modulos = ["BD","CD","FOL","LM","PRO", "SI"]
    notas = listaNotas(modulos) #Generar la lista notas
    suspensos = []
    notasSuspensas = []
    for i in range(len(notas)):
        if notas[i] < 5:
            notasSuspensas.append(notas[i])
            suspensos.append(modulos[i])
    print("\nLista de asignaturas suspensa a recuperar: ")
    print(suspensos)
    for i in range(len(suspensos)):
        print("En "+str(suspensos[i])+" has suspendido con "
        +str(notasSuspensas[i]) + ", hay que recuperar.")
#e5()

"""def pruebazip():
    asignaturas=["DI","AD","PSP","PMDM"]
    notas=[9,5,8,6]
    mezcla = []
    for i in zip(asignaturas,notas):
        mezcla.append(i)
    for x,y in mezcla:
        if y >= 5:
            asignaturas.remove(x)
            notas.remove(y)
    print(asignaturas)
    print(notas)        
pruebazip()"""

"""def pruebazip():
    asignaturas=["DI","AD","PSP","PMDM"]
    notas=[5,4,3,7]
    for x,y in zip(asignaturas,notas):
        if y>=5:
            asignaturas.remove(y)
    print(asignaturas)
    print(notas)
pruebazip()"""

#EJERCICIO 6
def e6():
    abc = ["a","b","c","d","e","f","g","h","i","j","k","l",
    "m","n","ñ","o","p","q","r","s","t","u","v","w","z"]    
    for i in range(len(abc), 1, -1):
        if i % 3 == 0:
            abc.pop(i-1)
    print("Abecedario filtrado resultado: ")
    print(abc)
#e6()

#EJERCICIO 7
def e7():
    palabra = input("Introduce palabra: ")
    vocales = ['a', 'e', 'i', 'o', 'u']
    for vocal in vocales:
        n = 0
        for letra in palabra:
            if letra == vocal:
                n += 1
        print("Vocal "+vocal+" esta "
        +str(n)+" veces")
#e7()

#EJERCICIO 8
def e8():
    precios = [50, 75, 46, 22, 80, 65, 8]
    print("Numero mayor="+str(max(precios))+
    " y menor="+str(min(precios)))            
#e8()

#EJERCICIO 9
def e9():
    v1 = [1,2,3]
    v2 = [-1,0,2]
    escalar = 0
    for i in range(len(v1)):
        escalar += v1[i]*v2[i]
    print("Producto escalar de vectores" + str(v1) + 
    " y " + str(v2) + " es " + str(escalar)) 
#e9()

#EJERCICIO 10
def e10():
    tupla = tuple([1,2,3,4,5,6,7,8,9,10])
    i = showTupleValues(tupla) 
    while i < 0 or i >= 10:
        i = showTupleValues(tupla)   

def showTupleValues(tupla):
    enter = input("Dame indice numerico valido (0-9): ")
    i = setInteger(enter)
    if i >= 0 and i <10:
        print(tupla[i])
    return i
#e10()