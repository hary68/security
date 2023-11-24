p = int(input("Enter the P value(largest prime number): "))
g = int(input("Enter the primitive root of P:"))

a = int(input("Enter the A's private key:"))
b = int(input("Enter the B's private key:"))

x = (g ** a) % p
y = (g ** b) % p

Ka = (x ** b) % p
Kb = (y ** a) % p

print("shared secret a:",Ka)
print("shared secret a:",Kb)