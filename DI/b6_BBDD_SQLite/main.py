#Boletín 6. Bases de Datos SQLite
import menu as m

#EJERCICIO3
def menu():
    print("\nBIENVENIDO AL RESTAURANTE")
    print("Elige el numero de opcion:")
    print("\t1.-Agregar categoria")
    print("\t2.-Agregar plato")
    print("\t3.-Mostrar menus")
    print("\t4.-Salir")    
    opcion = input("Dime un opcion: ")
    return opcion

def mostrar_opciones():    
    opcion = 0
    while(opcion != 4):
        opcion = m.setInt(menu())
        if(opcion == 1):
            m.agregar_categoria()
        elif (opcion == 2):
            m.agregar_plato()
        elif (opcion == 3):
            m.mostrar_menu()
        elif (opcion == 4):
            print("FIN del menu")
            quit()
        else:
            print("Elige una opcion valida.")


#MAIN EJECUCION
m.crear_bd()        
mostrar_opciones()
