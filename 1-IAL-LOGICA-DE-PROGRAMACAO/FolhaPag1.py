print("Calculadora de pagamentos")

sal_hora = float(input("Digite o salário por hora: "))
qtde_horas = int(input("Digite a quantidade de horas: "))
sal_bruto = sal_hora * qtde_horas
inss = sal_bruto * 0.11
irrf = (sal_bruto - inss) * 0.27
sind = sal_bruto * 0.05
sal_liq = sal_bruto - inss - irrf - sind

print ("+Salário Bruto    R$ {:4.2f}".format (sal_bruto))
print ("-INSS (11%)       R$ {:4.2f}".format (inss))
print ("-IRRF (27%)       R$ {:4.2f}".format (irrf))
print ("-Sindicato (5%)   R$ {:4.2f}".format (sind))
print ("=Salário Líquido  R$ {:4.2f}".format (sal_liq))