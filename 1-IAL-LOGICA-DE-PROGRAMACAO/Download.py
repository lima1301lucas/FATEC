print("Calcula o tempo aproximado de download do arquivo")
tam_arq = float(input("Tamanho do arquivo em Mega Bytes (MiB): "))
vel_transm = float(input("Velocidade de transmissão em Mega Bits por segundo (Mbps): "))

tam_arq_bits = tam_arq * 8
tempo_em_seg = tam_arq_bits / vel_transm
tempo_em_min = tempo_em_seg / 60

print("O tempo de download do arquivo é", tempo_em_min, "minuto(s)")
