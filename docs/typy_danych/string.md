# String

```python
string = 'Hello world'
string2 = "Hello world"
string3 = "Tutaj możesz wpisać 'pojedynczy' cudzysłów"
string4 = 'Tutaj też możesz wpisać \'pojedynczy\' cudzysłów'
string5 = '''To
jest
tekst
wieloliniowy
'''

powitanie = 'Hello'
swiat = 'world'
string6 = f'{powitanie} {swiat}'  # Hello world
string7 = powitanie + ' ' + swiat  # Hello world
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

### Powtarzanie stringów
```python
string = 'Hello!'
print(string * 4)  # Hello!Hello!Hello!Hello!
```

### Zamiana na listę znaków
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

### Sprawdzenie czy string nie zawiera stringa
```python
string = 'Hello world'
print('world' not in string)  # False
print('wordl' not in string)  # True
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

## Funkcje wbudowane
### .capitalize()
```python
string = 'hEllO WORld'
print(string.capitalize())  # Hello world
```

### .lower()
```python
string = 'hEllO WORld'
print(string.lower())  # hello world
```

### .swapcase()
```python
string = 'hEllO WORld'
print(string.swapcase())  # HeLLo worLD
```

### .title()
```python
string = 'hEllO WORld'
print(string.title())  # Hello World
```

### .upper()
```python
string = 'hEllO WORld'
print(string.swapcase())  # HELLO WORLD
```

### .count()
```python
string = 'Hello world'
print(string.count('o'))  # 2
print(string.count('oo'))  # 0
print(string.count('h'))  # 0
```

### .endswith()
```python
string = 'Hello world'
print(string.endswith('d'))  # True
print(string.endswith('world'))  # True
print(string.endswith('hello'))  # False
print(string.endswith('x'))  # False
```

### .find()
```python
string = 'Hello world'
print(string.find('d'))  # 10
print(string.find('world'))  # 6
print(string.find('ll'))  # 2
print(string.find('x'))  # -1 - bo nie ma
```

### .endswith()
```python
string = 'Hello world'
print(string.startswith('H'))  # True
print(string.startswith('h'))  # False
print(string.startswith('Hello'))  # True
print(string.startswith('world'))  # False
```

### .center()
```python
string = 'Hello world'
print(string.center(20))  # '    Hello world     '
print(string.center(20, '-'))  # ----Hello world-----
print(string.center(21, '-'))  # -----Hello world-----
print(string.center(5, '-'))  # Hello world
```

### .replace()
```python
string = 'Hello world'
print(string.replace('Hello', 'Goodbye'))  # Goodbye world
print(string.replace('Dog', 'Cat'))  # Hello world
```

### .strip()
```python
string = '    Hello world   \n\t'
print(string.strip())  # Hello world
```

### .join()
```python
tablica = ['Ala', 'ma', 'kota']
print(''.join(tablica))  # Alamakota
print(' '.join(tablica))  # Ala ma kota
print(', '.join(tablica))  # Ala, ma, kota
```

### .split()
```python
string = 'Hello world'
print(string.split(' '))  # ['Hello', 'world']
print(string.split())  # ['Hello', 'world']
print(string.split('l'))  # ['He', '', 'o wor', 'd']
print(string.split('d'))  # ['Hello worl', '']
```

## Funkcje zewnętrzne

- [float](https://github.com/PanSzelescik/MaturaInformatyka/blob/python/docs/funkcje/float.md)
- [enumerate](https://github.com/PanSzelescik/MaturaInformatyka/blob/python/docs/funkcje/len.md)
- [int](https://github.com/PanSzelescik/MaturaInformatyka/blob/python/docs/funkcje/int.md)
- [len](https://github.com/PanSzelescik/MaturaInformatyka/blob/python/docs/funkcje/len.md)
- [str](https://github.com/PanSzelescik/MaturaInformatyka/blob/python/docs/funkcje/str.md)