#Projeto IAL - Professor Arnaldo
#Nome: Lucas Lima Oliveira
#Número da matrícula: 21106558

import struct 
i = 1
arquivo = open('arq_func.dat','wb')
codigo = dia = mes = ano = 0
nome = " "
salario = 0.0
dd =  [0,31,28,31,30,31,30,31,31,30,31,30,31]
ind_erro = 0

while True:
    digCod = "s"
    digNome = "s"
    digData = "s"
    digSalario = "s"
    print ('\n%do. funcionario: \n' % i)

    while digCod == "s":
      ind_erro = 0
      codigo = input('Código........: ')

      if any(chr.isdigit() for chr in codigo):
          codigo = int(codigo)
          if codigo <= 0:
              ind_erro = 1
              print("Código precisa ser maior que zero")
          else:
              codigo = codigo
      else:
          ind_erro = 1
          print('código precisa ser inteiro e maior que 0 (zero)')

      digCod = "?"
      if ind_erro == 1:
          while digCod != "s" and digCod != "n":
              digCod = input("Código inválido! Deseja corrigir? (s/n): ")
              if digCod == "n":
                  print("Digitação abandonada!")

    if codigo == 9999: break
    if digCod == "n": break

    while digNome == "s":
      ind_erro = 0
      nome = input('Nome........: ')

      if nome.isdigit():
          ind_erro = 1
          print("Errado: nome é digito")
      else:
          if len(nome) > 30:
              ind_erro = 1
              print("Errado: nome tem mais de 30 caracteres")
          else:
              if nome[0].islower():
                  ind_erro = 1
                  print("Errado: nome não inicia com letra maiúscula")
              else:
                  if "A" > nome[0] > "Z":
                      ind_erro = 1
                      print("Errado: nome não inicia com letras entre A - Z")

      digNome = "?"
      if ind_erro == 1:
          while digNome != "s" and digNome != "n":
              digNome = input("Nome inválido! Deseja corrigir? (s/n): ")
              if digNome == "n":
                  print(" Digitação abandonada!")

    if digNome == "n": break

    while digData == "s":
      ind_erro = 0
      dia = input("Digite o dia: ")
      mes = input("Digite o mes: ")
      ano = input("Digite o ano: ")

      if dia.isdigit():
          dia = int(dia)
      else:
          dia = 0

      if mes.isdigit():
          mes = int(mes)
      else:
          mes = 0

      if ano.isdigit():
          ano = int(ano)
      else:
          ano = 0

      if ano % 4 == 0 and ano % 100 != 0 or ano % 400 == 0:
          dd[2] = 29
      else:
          dd[2] = 28

      if mes < 1 or mes > 12:
          ind_erro = 1
      else:
          if dia < 1 or dia > dd[mes]:
              ind_erro = 1

      if ano < 1:
          ind_erro = 1

      digData = "?"
      if ind_erro == 1:
          while digData != "s" and digData != "n":
              digData = input("Data inválida! Deseja corrigir? (s/n): ")
              if digData == "n":
                  print("Digitação abandonada!")

    if digData == "n": break

    while digSalario == "s":
      ind_erro = 0
      salario = float(input('Salário.....: '))

      if isinstance(salario, float):
          if 1200.00 <= salario <= 110000.00:
              salario = salario
          else:
              ind_erro = 1
              print("Salário errado")
      else:
          ind_erro = 1

      digSalario = "?"
      if ind_erro == 1:
          while digSalario != "s" and digSalario != "n":
              digSalario = input("Salário inválido! Deseja corrigir? (s/n): ")
              if digSalario == "n":
                  print("Digitação abandonada!")
      else:
          print("Registros incluidos")

    if digSalario == "n": break

    registro = struct.pack('i30siiif',codigo,nome.encode('ascii'),dia,mes,ano,salario)
    arquivo.write(registro)
    i = i + 1

arquivo.close()

##le arquivo (arq_func.dat) e mostra dados na tela
import struct
print (" ")
print ("Listagem dos funcionários incluídos")
tamanho = len(struct.pack('i30siiif',0,' '.encode('ascii'),0,0,0,0.0)) # do registro
arquivo = open('arq_func.dat','rb')
while True:
     registro = arquivo.read(tamanho)
     if registro == b"" : break
     (codigo,nome,dia,mes,ano,salario) = struct.unpack('i30siiif',registro) 
     print ('%04d %-30s %02d/%02d/%04d %8.2f' % (codigo, str(nome,'ascii').strip('\x00'), dia, mes, ano, salario))

arquivo.close()