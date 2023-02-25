#Boletin 4. Python: Funciones y Diccionarios

import statistics;

#EJERCICIO 1
def e1():
    costo = setFloat(input("Dame el costo sin iva: "))
    iva =  setFloat(input("Dame el porcentaje sin iva: "))
    total = calcularTotal(costo)
    print("El precio total con iva del "+str(iva)+
    " es de "+str(total))

def setFloat(enter): #Metodo para aceptar solo decimales
    try:                    
        f = float(enter)
    except ValueError:
        print("Error: valor de entrada no es un numero decimal")
        f = -1
    return f

def calcularTotal(costo, iva=21):
    total = costo
    if iva == None or iva == 21:
        total = total * ((100+21)/100)
    else :
        total = total * ((100+iva)/100)
    return round(total, 2)
#e1()

#EJERCICIO 2
def e2():
    numeros = [1,2,3,4,5,6,7,8,9,10,11,12]
    print("La media de la lista de numeros ")
    media = calcularMedia(numeros)    
    print(numeros)
    print("Seria de sobre: ", media)

def calcularMedia(numeros):
    media = 0
    try:
        media = statistics.mean(numeros)
    except ValueError or ArithmeticError:
        print("Error al calcular media.")
        media = 0
    return media
#e2()

#EJERCICIO 3
def e3():
    n = 0
    while n < 1:
        n = setInteger(input("Dime un numero natural: "))
    dic = {}

    for i in range(1, n+1):
        dic[i] = i**2
    for i, valor in dic.items():
        print("Numero: %d -> Valor: %d" % (i,valor))

def setInteger(enter): #Metodo para aceptar solo enteros
    try:
        i = int(enter)
    except ValueError:
        print("Error: valor de entrada no es un numero entero")
        i = -1
    return i
#e3()

#EJERCICIO 4
def e4():
    divisas = {'Euro':'€', 'Dollar':'$', 'Yen':'¥'}    
    divisa = input("Dime el nombre de una divisa: ")
    if divisa in divisas:
        print(divisas[divisa])
    else:
        print("Divisa introducida no esta.")
#e4()

#EJERCICIO 5
def e5():
    frutas = {"Manzana":1.8, "Fresa":2.2, "Melon":0.9, 
    "Limon":1.5, "Naranja":1.9, "Platano":1.6}
    fruta = input("Dime un nombre de una fruta: ")
    masa = setFloat(input("Dime la cantidad fruta en kilos: "))
    if fruta in frutas:
        print("La futa ",fruta,
        " tiene un coste total de ",frutas[fruta]*masa," euros")
    else:
        print("La fruta ",fruta," no existe o no esta disponible")
#e5()

#EJERCICIO 6
def e6():
    nombre = input("Dime tu nombre: ")
    edad = setInteger(input("Dime tu edad: "))
    direccion = input("Dame tu direccion: ")
    telefono = setInteger(input("Dame tu telefono: "))
    usuario = {"nombre":nombre,"edad":edad,"direccion":direccion,"telefono":telefono}
    print(usuario['nombre']," tiene ",usuario['edad'],
    " años, vive en ",usuario['direccion'],
    " y su numero de telefono es ",usuario['telefono'])
#e6()

#EJERCICIO 7
def e7():
    persona = {}
    seguir = True
    while seguir == True:
        dato  = input("Dame el nombre del dato de la persona: ") 
        valor = input("Dame el valor del "+str(dato)+": ")
        persona[dato] = valor
        print(persona)
        seguir = input("Deseas continuar? (Si/No): ") == "Si"
#e7()

#EJERCICIO 8
def e8():
    translate = {}
    palabras = input("Dime la lista de palabras y "+
    "traducciones en formato palabra:traducción separadas por comas: ")
    for i in palabras.split(','):
        clave, valor = i.split(':')
        translate[clave] = valor
    frase = input('Introduce una frase en español: ')
    for i in frase.split():
        if i in translate:
            print(translate[i], end=' ')
        else:
            print(i, end=' ')
#e8()

#EJERCICIO 9
def e9():
    clientes = {}
    op = ''
    while op != '6':
        if op == '1':
            print("Introduce datos del cliente a añadir")
            nif = input('Dame NIF: ')
            nombre = input('Dime el nombre: ')
            direccion = input('Dime direccion: ')
            telefono = input('Dime  telefono: ')
            email = input('Dime el correo electronico: ')
            preferente = input('Indica si el cliente es preferente (S/N)? ')
            cliente = {'nombre':nombre, 'dirección':direccion,
            'teléfono':telefono, 'email':email, 
            'preferente':preferente=='S'}
            clientes[nif] = cliente
        if op == '2':
            nif = input('Introduce NIF del cliente a borrar: ')
            if nif in clientes:
                del clientes[nif]
            else:
                print('No existe el cliente con el nif: ', nif)
        if op == '3':
            nif = input('Introduce NIF del cliente a mostrar: ')
            if nif in clientes:
                print('NIF:', nif)
                for key, value in clientes[nif].items():
                    print(key.title() + ':', value)
            else:
                print('No existe el cliente con el nif: ', nif)
        if op == '4':
            print('Lista de clientes')
            for key, value in clientes.items():
                print(key, value['nombre'])
        if op == '5':
            print('Lista de clientes preferentes')
            for key, value in clientes.items():
                if value['preferente']:
                    print(key, value['nombre'])
        op = input('Menú de opciones\n'+
        '(1) Añadir cliente\n(2) Eliminar cliente\n'+
        '(3) Mostrar cliente\n(4) Listar clientes\n'+
        '(5) Listar clientes preferentes\n(6) Terminar\n'+
        'Elige una opción: ')
e9()

#EJERCICIO 10
def e10():
    alumno = {
        "Aceso Datos":5,
        "Diseño Interfaces":8,
        "Sistemas Gestion Empresarial":8,
        "Programacion Dispositivos Moviles y Multimedia":10,
        "Empresa e Iniciativa Emprendedora":8
    }
    result = capitalizar_dic(alumno)
    print(result)

def capitalizar_dic(dic):
    result = {}
    for key, value in dic.items():
        upper_key = key.upper()
        value_string = cualificar(value)
        result[upper_key] = result.get(upper_key, value_string)
    return result

def cualificar(nota):
    c = "" #CUALIFICAION
    if nota < 5:
        c = "SUSPENSO"
    elif nota >= 5 and nota < 6:
        c = "SUFICIENTE"
    elif nota >= 6 and nota < 8:
        c = "BIEN"
    elif nota >= 8 and nota < 9:
        c = "NOTABLE"
    elif nota >= 9 and nota <= 10:
        c = "SOBRESALIENTE"
    else:
        c = "NOTA INVALIDA"
    return c
#e10()