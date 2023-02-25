def ex1():
    print("¡hola, estoy estudiando desarrollo ",
    "de aplicacionesmultiplataforma!")
ex1()

def ex2():
    cadena = "¡Soy alumno de DAM2!"
    print(cadena)
ex2()

def ex3():
    nombre = input("Ex3. Dame nombre de usuario: ")
    print(nombre)
ex3()

def ex4():
    name = input("Ex4. Dame nombre de usuario: ")
    numero = int(input("Dame numero repeticiones: "))
    print(name)
    x = 0
    while x < numero:
        x+=1
        print(name)
ex4()
    
def ex5():
    nombre = input("Ex5. Dame nombre de usuario: ")
    print(nombre.upper() , " tiene " , 
    str(len(nombre)) , " letras")
ex5()

def ex6():
    resultado = ((3 + 2)/2.5)**2
    print(str(resultado))
ex6()

def ex7():
    horas = input("Ex7. Dame numero de horas trabajadas: ")
    coste = input("Dame coste por hora: ")
    resultado = float(horas) * float(coste)
    print("Paga correspondente: "+str(resultado))
ex7()

def ex8():
    peso = input("Ex8. Dame peso de usuario en kilos: ")
    estatura = input("Dame estatura de usuario en metros: ")
    imc = float(peso)/(float(estatura))**2
    print("IMC de usuario: "+str(round(imc, 2)))
ex8()

def ex9():
    precio = input("Ex9. Dame precio producto con dos decimales: ")
    print(precio[:precio.find('.')], 'euros y', 
    precio[precio.find('.')+1:], 'céntimos.')
ex9()

def ex10():
    frescas = input("Dame numero de barras pan frescas: ")
    resesas = input("Dame numero de barras pan resesas: ")
    total = float(frescas) * 3.49 
    + float(resesas) * (3.49 * 0.4)
    precio = total /(int(frescas)+int(resesas))
    print(str(round(precio, 2)))
ex10()