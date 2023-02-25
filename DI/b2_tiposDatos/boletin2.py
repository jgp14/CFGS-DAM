def ex1():
    edad = int(input("Dame tu edad: "))
    if edad >= 18 and edad < 120:
        etapa = "Mayor"
    elif edad > 0 and edad < 18: 
        etapa = "Menor"
    else:
        etapa = "Error"
    print(" de edad")
ex1()

def ex2():
    storedPassword = "contraseña"
    password = input("Dame contraseña: 1")
    if storedPassword == password:
        print("Contraseña coincide")
    else:
        print("Contraseña no coincide")
ex2()

def ex3():
    nombre = input("Dime tu nombre: ")
    sexo = input("Dime tu sexo bioligico (H/M): ")
    if sexo == "M": # Anterior a m
        if nombre.lower() < "m":
            grupo = "A"
        else:
            grupo = "B"
    else:
        if nombre.lower() > "n": # Posterior a n
            grupo = "A"
        else:
            grupo = "B"
    print("Perteneces al grupo " + grupo)
ex3()

def ex4():
    bonus = 2400
    inaceptable = 0
    aceptable = 0.4
    puntuacion = float(input("Dame la puntuacion: "))
    # Categorias de niveles
    if puntuacion == inaceptable:
        nivel = "Inaceptable"
    elif puntuacion == aceptable:
        nivel = "Aceptable"
    elif puntuacion >= 0.6:
        nivel = "Meritorio"
    else:
        nivel = ""
    # Nivel de rendimiento mostrado
    if nivel == "":
        print("Puntuación invalida")
    else:
        print("Nivel de rendimiento es %s" % nivel)
        print("Corresponde cobrar %.2f€" % (puntuacion * bonus))
ex4() 

def ex5():
    print("Carta de pizzeroa Bella Napoli."+
    "\nTipos de pizza\n\t1 - Vegetariana\n\t2 - No vegetariana\n")
    tipo = input("Selecciona el codigo de pizza:")
    if tipo == "1":
        print("Ingredientes para pizza vegetariana\n\t1 - Pimiento\n\t2 - Tofu\n")
        ingrediente = input("Selecciona el codigo del ingrediente: ")
        print("Pizza vegetariana con mozzarella, tomate y ", end="")
        if ingrediente == "1":
            print("pimiento")
        elif ingrediente == "2":
            print("tofu")
        else: 
            print("")
    else:
        print("Ingredientes para pizzas no vegetarianas"
        +"\n\t1- Peperoni\n\t2- Jamón\n\t3- Salmón\n")
        ingrediente = input("Selecciona el codigo del ingrediente: ")
        print("Pizza no vegetarina con mozarrella, tomate y ", end="")
        if ingrediente == "1":
            print("peperoni")
        elif ingrediente == "2":
            print("jamón")
        elif ingrediente == "3":
            print("salmón")
        else: 
            print("")
ex5()

def ex6():
    palabra = input("Dame una palabra: ")
    for i in range(10):
        print(palabra, end=" ")
ex6()

def ex7():
    n = int(input("Dame un numero entero positivo: "))
    for i in range(1, n+1, 2):
        print(i, end=", ")
ex7() 

def ex8():
    altura = int(input("Dame la altura del triángulo: "))
    for i in range(1, altura+1, 2):
        for j in range(i, 0, -2):
            print(j, end=" ")
        print("") 
ex8()
def ex9():
    frase = input("Escribe una frase: ")
    letra = input("Pon una letra: ")
    n = 0
    for i in frase:
        if i == letra:
            n += 1
    print("La letra "+str(letra)+" aparece ",
    str(n)+" veces en la frase "+frase+".")
ex9() 

def ex10():    
    while True:
        eco = input("Escribe una frase: ")
        if eco == "salir":
            break
        print(eco)
ex10()