# Function

```python
# Deklaracja funkcji

# Słowo `def`
# spacja
# nazwa funkcji
# parametry w nawiasie
def nextLetter(char):  # Funkcja obliczająca następną literę, jeśli zostanie podany Z, zwraca A
    if char == 'Z':
        return chr(ord(char) - 25)
    else:
        return chr(ord(char) + 1)

print(nextLetter('B'))  # C

# Można także użyć lambdy dla deklaracji funkcji jednoliniowej
drugielement = lambda x: x[1]

tablica = [5, 7, 8]
print(drugielement(tablica))  # 7
```