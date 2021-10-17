print("Calculadora de pagamentos")

sal_hora = float(input("Digite o salário por hora: "))
qtde_horas = int(input("Digite a quantidade de horas: "))
sal_bruto = sal_hora * qtde_horas

if sal_bruto <= 1045.00:
        inss = sal_bruto * 0.075
if (sal_bruto >= 1045.01) and (sal_bruto <= 2089.60):
          inss = sal_bruto * 0.09
if (sal_bruto >= 2089.61) and (sal_bruto <= 3134.40):
          inss = sal_bruto * 0.12
if (sal_bruto >= 3134.41) and (sal_bruto <= 6101.06):
          inss = sal_bruto * 0.14
if sal_bruto > 6101.06 :
          inss = 6101.06 * 0.14

base_irrf = sal_bruto - inss

if base_irrf < 1903.99:
    irrf = 0.0
if (base_irrf >= 1903.99) and (base_irrf <= 2826.66):
    irrf = base_irrf * 0.075 - 142.80
if (base_irrf >= 2826.66) and (base_irrf <= 3751.05):
    irrf = base_irrf * 0.15 - 354.80
if (base_irrf >= 3751.06) and (base_irrf <= 4664.68):
    irrf = base_irrf * 0.225 - 636.13
if base_irrf > 4664.68:
    irrf = base_irrf * 0.275 - 869.36

sind = sal_bruto * 0.05

sal_liq = sal_bruto - inss - irrf - sind

print("+Salário Bruto    R$ {:8.2f}".format(sal_bruto))
print("-INSS             R$ {:8.2f}".format(inss))
print("-IRRF             R$ {:8.2f}".format(irrf))
print("-Sindicato (5%)   R$ {:8.2f}".format(sind))
print("=Salário Líquido  R$ {:8.2f}".format(sal_liq))