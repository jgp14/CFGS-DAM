#Boletin 5. Modulos y Paquetes
from b5_ej5_modulosPaquetes import Cuenta as c, CajaAhorro as ca, PlazoFijo as pf
from b5_ej6_modulosPaquetes import persona as p, cuenta as cu, cuentaJoven as cj

def e5():
    cuenta = c.Cuenta("ClienteCuenta", 1000)
    cuenta.printDataCuenta()

    cajaAhorro = ca.CajaAhorro("ClienteAhorro", 1200)
    cajaAhorro.printDataCajaAhorro()

    plazoFijo = pf.PlazoFijo("ClientePlazo", 2000, 120, 2)   
    plazoFijo.printDataPlazoFijo()

def e6():
    nombre = input("Dime el nombre: ")
    edad = p.edadValida()
    dni = input("Dime el DNI: ")

    persona1 = p.Persona(nombre, edad, dni)
    print("\nPersona")
    persona1.mostrar()

    print("\nCuenta Basica")
    cantidad = cu.setFloat(input("Dime el saldo de cuenta: "))
    cuenta = cu.Cuenta(persona1, cantidad)    
    cuenta.ingresar()
    cuenta.retirar()    
    cuenta.mostrar()

    print("\nCuenta Joven")
    bonus = p.setInt(input("Dime '%' de bonoificacion: "))
    cuentaJoven = cj.CuentaJoven(persona1, cantidad, bonus)
    cuentaJoven.retirar()
    cuentaJoven.mostrar()

#EJECUCION
#e5()
e6()