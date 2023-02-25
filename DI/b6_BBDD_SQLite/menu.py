#Boletín 6. Bases de Datos SQLite
import sqlite3

__BBDD = "b6_BBDD_SQLite/menu.db"

#EJERCICIO1
def crear_bd():            
    try:
        conexion = sqlite3.connect(__BBDD)
        cursor = conexion.cursor()
        #cursor.execute("DROP TABLE IF EXISTS CATEGORIA")
        cursor.execute("CREATE TABLE CATEGORIA (" + 
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
            "nombre VARCHAR(50) NOT NULL UNIQUE" +
            ")")
        
        #cursor.execute("DROP TABLE IF EXISTS PLATO;")
        cursor.execute("CREATE TABLE PLATO ( " + 
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
            "nombre VARCHAR(50) NOT NULL UNIQUE, " + 
            "id_categoria INTEGER, " +
            "CONSTRAINT fk_CATEGORIA_id " + 
                "FOREIGN KEY (id) " +
                "REFERENCES CATEGORIA (id)" + 
                "ON DELETE RESTRICT " + 
                "ON UPDATE CASCADE" + 
            ")")

        conexion.commit()
        print("Tablas creadas correctamente")

    except sqlite3.OperationalError:
        print("Error: tablas ya existen")
        
    conexion.close()

#EJERCICIO2
def agregar_categoria():
    try:
        conexion = sqlite3.connect(__BBDD)
        cursor = conexion.cursor()
        nombre = input("Dime un nombre de categoria: ")
        cursor.execute("INSERT INTO CATEGORIA VALUES (null, '"+nombre+"')")
        conexion.commit()
        conexion.close()
        print("Categoria "+nombre+" añadida con exito")
    except sqlite3.IntegrityError:
        print("IntegrityError: ya existe la categoria.")
#agregar_categoria()   

def setInt(enter): #Metodo para aceptar solo enteros
    try:
        i = int(enter)
    except ValueError:
        print("Error: el input no es un numero entero")
        i = 0
    return i

#EJERCICIO4
def agregar_plato(): 
    conexion = sqlite3.connect(__BBDD)
    cursor = conexion.cursor()
    cursor.execute("SELECT * FROM CATEGORIA")
    categorias = cursor.fetchall()
    n = len(categorias)

    print("Categorias: ")
    for categoria in categorias:
        print(categoria)
    id = 0
    while(id <= 0 or id > n):
        id = setInt(input("Dime id de categoria: "))
        plato = input("Dime el nombre del plato: ")
        print(str(id) + "  plato: "+plato)
        if(id > 0 and id <= n):
            try:
                cursor.execute("INSERT INTO PLATO VALUES " + 
                "(null, '"+plato+"', '"+str(id)+"')")
                conexion.commit()
            except sqlite3.IntegrityError:
                print("IntegrityError: ya existe el plato")            

    conexion.close()

""" def eliminar_plato():
    conexion = sqlite3.connect(__BBDD)
    cursor = conexion.cursor()
    cursor.execute("DELETE FROM PLATO WHERE id=1")
    conexion.commit()
    conexion.close() """
        
#EJERCICIO5
def mostrar_menu():
    conexion = sqlite3.connect(__BBDD)
    cursor = conexion.cursor()
    cursor.execute("SELECT c.nombre, p.nombre  " + 
        "FROM PLATO p JOIN CATEGORIA c " + 
        "ON (p.id_categoria=c.id) "
        "ORDER BY (c.id AND p.nombre)")
    platos = cursor.fetchall()
    n = len(platos)

    print("Platos: ")
    print("CATEGORIA\tNOMBRE PLATO")
    for plato in platos:
        print(plato)
    conexion.close()
    

