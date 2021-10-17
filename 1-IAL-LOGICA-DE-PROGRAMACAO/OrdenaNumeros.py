print ("ordena vetor com 12 elementos em ordem crescente")
vet=[12,11,10,9,8,7,6,5,4,3,2,1]
x=y=aux=0

for x in range(11, 0, -1):
    for y in range(x):
        if vet[y] > vet[y+1]:
            aux = vet[y]
            vet[y] = vet[y+1]
            vet[y+1] = aux
print(vet)