P = 1;
Q = 10;
W = 14;

P = Q * 2 + W // 2 + W % 3 + (3 - 1)
W = P - Q // (Q - 4)
Q = Q + P - W

if Q != 11 :
    if (P > 31) and (Q < 6) or (W > 30):
        P = W + 4
    if (Q > 13) and ((P > 35) or (W < 25)):
        P = P + W + 5;
    elif P < 40:
        P = Q + P // 2
        Q = 20
else:
    if P == 31:
        P = Q + P * 2
        Q = 35 + W
    else:
        if Q == 13 :
            if P >= 20:
                W = 45
TOT = P + Q + W
print ('valor de TOT = ',TOT)

