print("Verifica se os lados informados correspondem a um triângulo")
lado1 = int(input("Digite a medida do primeiro lado: "))
lado2 = int(input("Digite a medida do segundo lado: "))
lado3 = int(input("Digite a medida do terceiro lado: "))

if lado1 < lado2 + lado3 and lado2 < lado1 + lado3 and lado3 < lado1 + lado2:
    print("As medidas formam um triângulo ", end='')

    if lado1 == lado2 == lado3:
        print("EQUILÁTERO")
    elif lado1 != lado2 != lado3 != lado1:
        print("ESCALENO")
    else:
        print("ISÓCELES")

else:
    print("As medidas não formam um trângulo")
    