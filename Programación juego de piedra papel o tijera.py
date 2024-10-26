import random


def obtener_eleccion_usuario():  # El usuario debe elegir una opción
    while True:
        print("Elija una opción:")
        print("1 - Piedra")
        print("2 - Papel")
        print("3 - Tijera")
       
        eleccion = input("Ingrese su opción (1, 2 o 3): ")    #  
       
        if eleccion in ['1', '2', '3']:
            return int(eleccion)
        else:
            print("Opción no válida. Por favor, intente de nuevo.")


def determinar_resultado(usuario, maquina):
    if usuario == maquina:
        print("Empate")                 # Se dicta un empate
        return 0
    elif (usuario == 1 and maquina == 3) or (usuario == 2 and maquina == 1) or (usuario == 3 and maquina == 2):
        print("Ganaste")                   # Se dicta una victoria
        return 1
    else:
        print("Perdiste")                  # Se dicta una derrota
        return -1


victorias_usuario = 0
victorias_maquina = 0
                                                                            #
while victorias_usuario < 2 and victorias_maquina < 2:
    eleccion_usuario = obtener_eleccion_usuario()
    eleccion_maquina = random.randint(1, 3)


    opciones = {1: "Piedra", 2: "Papel", 3: "Tijera"}
    print(f"Tu elección: {opciones[eleccion_usuario]}")
    print(f"Elección de la máquina: {opciones[eleccion_maquina]}")


    puntos = determinar_resultado(eleccion_usuario, eleccion_maquina)
                                                                            # Suma o resta de puntos dependiendo de si se gana o se pierde
    if puntos == 1:
        victorias_usuario += 1
    elif puntos == -1:
        victorias_maquina += 1


    print(f"Marcador: Tú {victorias_usuario} - {victorias_maquina} Máquina")


if victorias_usuario == 2:                              # Número de victorias para ganar
    print("Enhorabuena, has ganado el juego.")
else:
    print("Eres un manco. Intenta de nuevo.")
print("Diego")
