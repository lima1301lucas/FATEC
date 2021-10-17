print("Verifica se o número é par ou ímpar")
num = int(input("Digite o número: "))

#Solução 1:resto da divisão por 2
if num % 2 == 0:
    print("O número" , num, "é par")
else:
    print("O número" , num, "é ímpar")

#Solução 2: aplica um AND com 0x0001 e verifica se resulta 0
if num & 0x0001 > 0:
    print("O número", num, "é ímpar")
else:
    print("O número", num, "é par")

#Solução 3: aplica um if : se num > 0 é ímpar se = a 0 é par
if num & 0x0001:
    print("O número", num, "é ímpar")
else:
    print("O número", num, "é par")

#Solução 4: deslocando um bit à esquerda
bit = num >> 1;
bit = bit << 1;

if bit == num:
    print("O número", num, "é par")
else:
    print("O número", num, "é ímpar")
