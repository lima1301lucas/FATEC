A = 10;
B = 11 ;
C = 12;
D = 13

if A <= 20 and (B == 10 or C > 12) and D != 13 or D ==13 and B < 11 or A == 10 and D < 11 or B == 11:
    print("1 - V")
else:
    print("1 - F")

if A == 10 and B == 12 or C >= 8 and D < 12 or A > 5 and C == 12:
    print("2 - V")
else:
    print("2 - F")

if C == 11 or B == 11 and D <= 11 and A == 11 or D == 12 or A > 9 and C < 12:
    print("3 - V")
else:
    print("3 - F")

if A == 11 or B == 10 and C == 12 or A ==10 and C < 12 and B == 11 or B == 10 or C == 12:
    print("4 - V")
else:
    print("4 - F")

if A > 8 and B < 11 or C == 12 and D == 11 and B == 11 or C == 12 and D < 10 or A == 8:
    print("5 - V")
else:
    print("5 - F")