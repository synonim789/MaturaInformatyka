# String

```python
string = 'Hello world'
string2 = "Hello world"
string3 = "Tutaj możesz wpisać 'pojedynczy' cudzysłów"
string4 = 'Tutaj też możesz wpisać \'pojedynczy\' cudzysłów'

powitanie = 'Hello'
swiat = 'world'
string5 = f'{powitanie} {swiat}'  # Hello world
string6 = powitanie + ' ' + swiat  # Hello world
```

### Pobranie n litery od lewej
```python
string = 'Hello world'
print(string[3])  # l
```

### Pobranie n litery od prawej
```python
string = 'Hello world'
print(string[-3])  # r
```

### Pobranie ciągu liter
```python
string = 'Hello world'
# 3 pierwsze znaki
print(string[0:3])  # Hel
# 0 można pominąć przy zapisie
print(string[:3])  # Hel

# Wyrzucenie 3 ostatnich znaków
print(string[:-3])  # Hello wo

# Wyrzucenie 2 pierwszych znaków i 3 ostatnich znaków
print(string[2:-3])  # llo wo
```

### Pobranie co n znaku
```python
string = 'Hello world'
# Co 3 znak
print(string[::3])  # Hlwl
```

### Zamiana na tablicę znaków
```python
string = 'Hello world'
print(list(string))  # ['H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd']
```

### Zamiana na zbiór znaków (bez powtórzeń)
```python
string = 'Hello world'
print(set(string))  # {'e', 'H', 'l', ' ', 'r', 'd', 'w', 'o'}
```

### Sprawdzenie czy string zawiera string
```python
string = 'Hello world'
print('world' in string)  # True
print('wordl' in string)  # False
```

### Iteracja po literach
```python
string = 'Hello world'
for char in string:
    print(char)

# Jeśli potrzebujesz indexu:
for index, char in enumerate(string):
    print(index)
    print(char)
```