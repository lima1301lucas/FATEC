A = 8;
B = 10;
C = 15;
D = 20;

if A > 5 and C <= 16 or B == 3 or A + B > 17:
    print("1 - V")
else:
    print("1 - F")

if A < 10 and (B < C and B + C < 20) or 5 + 3 != A and D >= 20:
    print("2 - V")
else:
    print("2 - F")

if A - 5 + 1 > 4 and C + D == 25 or B + C < C + A or D + A < B + C:
    print("3 - V")
else:
    print("3 - F")

if not (A > 8 and B < 15 or C > 10) and C == 15 or C < 15:
    print("4 - V")
else:
    print("4 - F")
