print("Verifica as 4 medidas informadas e diz se é um quadrado, retângulo ou nenhuma outra")
md1 = int(input("Digite a primeira medida: "))
md2 = int(input("Digite a segunda medida: "))
md3 = int(input("Digite a terceira medida: "))
md4 = int(input("Digite a quarta medida: "))

if md1 == md2 and md1 == md3 and md1 == md4:
    print("As medidas formam um quadrado")
elif md1 == md2 and md3 == md4 or md1 == md3 and md2 == md4 or md1 == md4 and md2 == md3:
    print("As medidas formam um retângulo")
else:
    print("As medidas não formam nem um quadrado nem um retângulo")
