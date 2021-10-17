P=11;
Q = 12;
W = 13;

P = Q * 2 + W // 2 + W % 3 + (3 - 1)
W = P - Q // (Q - 4)
Q = Q + P - W

if Q != 11:
    if (P > 31) and ((Q < 13) or (W > 30)):
        P = W + 7
    if Q > 33 and P > 35 or W < 25:
        P = P + W + 5;
    elif P < 40:
        P = Q + P // 2
        Q = 20
else:
    P = Q + P * 2
    Q = 35

TOT = P + Q + W
print ('valor de TOT = ',TOT)