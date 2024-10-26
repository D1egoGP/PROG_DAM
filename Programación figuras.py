while True:
    print("Seleccione una figura para mostrar:")    # Se le asigna un valor numérico a cada opción dada
    print("1 - Cuadrado")
    print("2 - Rectángulo")
    print("3 - Salir")
   
   
    opcion = input("Ingrese su opción (1, 2 o 3): ")
   
    if opcion == '1':
        lado = float(input("Ingrese el lado del cuadrado: "))
       
        for i in range(int(lado)):      # La variable utilizada nombrada "i" sirve como un contador que se usa para saber cuantas veces se ejecuta el código dentro del bucle asignado
            print('*' * int(lado))     # Imprime el número que se le a transmitido
       
        area = lado ** 2   # Se calcula el área del cuadrado con el número proporcionado
        perimetro = lado * 4     # Fórmula para calcular el área del cuadrado
        print(f"Área: {area}, Perímetro: {perimetro}")
       
       
    elif opcion == '2':
        base = float(input("Ingrese la base del rectángulo: "))
        altura = float(input("Ingrese la altura del rectángulo: "))
       
        for i in range(int(altura)):  # La variable utilizada nombrada "i" sirve como un contador que se usa para saber cuantas veces se ejecuta el código dentro del bucle asignado
            print('*' * int(base))        # Imprime los números que se le han transmitido
       
        area = base * altura   # Se calcula el área del rectángulo con los números proporcionados por el jugador
        perimetro = 2 * (base + altura)     # Fórmula para calcular el área del rectángulo
        print(f"Área: {area}, Perímetro: {perimetro}")
       
       
    elif opcion == '3':
        print("Salir")
        break
   
    else:
        print("Opción no válida. Por favor, intente de nuevo.")  
   
print("Diego")
