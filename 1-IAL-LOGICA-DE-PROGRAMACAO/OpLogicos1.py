A = 0;
B = 1;
C = 2;

if A != 0 and C == 0 or B == 1:
    print("1 - V")
else:
    print("1 - F")

if (A == 0 or B == 2) and C > 2:
    print("2 - v")
else:
    print("2 - F")

if A == 0 or B == 2 and C > 2:
    print("3 - V")
else:
    print("3 - F")

if A == 1 and B == 1 and C == 2 or A == 0 and B > 0 and C < 3:
    print("4 - V")
else:
    print("4 - F")

if (A == 5 or C >= 0) and B == 2 or B == 1 and C != 0:
    print("5 - V")
else:
    print("5 - F")
