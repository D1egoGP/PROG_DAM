def obtener_saldo_inicial():
    while True:
        try:
            saldo = float(input("Ingrese el saldo inicial de la cuenta: "))
            if saldo >= 0:
                return saldo   # Devuelve el dinero inicial si es válido
            else:
                print("El saldo inicial no puede ser negativo. Intente nuevamente.")
        except ValueError:
            print("Entrada no válida. Ingrese un número decimal.")


def menu():    # Muestra el menú de opciones ypide al usuario una opción válida entre 1 y 4
    print("\n--- Menú ---")
    print("1 - Ingresar dinero")
    print("2 - Retirar dinero")
    print("3 - Mostrar saldo")
    print("4 - Salir")
    while True:
        try:
            opcion = int(input("Seleccione una opción: "))
            if 1 <= opcion <= 4:
                return opcion
            else:
                print("Opción no válida. Intente nuevamente.")
        except ValueError:
            print("Entrada no válida. Ingrese un número del 1 al 4.")


def obtener_cantidad_ingreso():     # Pide al usuario la cantidad a ingresar
    while True:
        try:
            cantidad = float(input("Ingrese la cantidad a depositar: "))
            if cantidad >= 0:
                return cantidad
            else:
                print("No puede ingresar una cantidad negativa. Intente nuevamente.")
        except ValueError:
            print("Entrada no válida. Ingrese un número decimal.")


def obtener_cantidad_retiro():    # Solicita al usuario la cantidad a retirar
    while True:
        try:
            cantidad = float(input("Ingrese la cantidad a retirar: "))
            if cantidad >= 0:
                return cantidad
            else:
                print("No puede retirar una cantidad negativa. Intente nuevamente.")
        except ValueError:
            print("Entrada no válida. Ingrese un número decimal.")


def ingresar_dinero(saldo):     # Para obtener la cantidad a depositar
    cantidad = obtener_cantidad_ingreso()
    return saldo + cantidad


def retirar_dinero(saldo):
    cantidad = obtener_cantidad_retiro()
    if cantidad > saldo:
        print("Fondos insuficientes. No puede quedarse en números rojos.")
        return saldo
    else:
        return saldo - cantidad


def cuenta_bancaria():
    saldo = obtener_saldo_inicial()
    while True:
        opcion = menu()
        if opcion == 1:
            saldo = ingresar_dinero(saldo)
            print(f"Dinero ingresado con éxito. Saldo actual: {saldo:.2f}")
        elif opcion == 2:
            saldo = retirar_dinero(saldo)
            print(f"Dinero retirado con éxito. Saldo actual: {saldo:.2f}")
        elif opcion == 3:
            print(f"Saldo actual: {saldo:.2f}")
        elif opcion == 4:
            print("Gracias por utilizar el sistema de banca.")
            break


cuenta_bancaria()
print("Diegogp")
