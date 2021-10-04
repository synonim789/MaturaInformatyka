# Number

```python
calkowita = 7  # int
rzeczywista = 8.5  # float

suma = calkowita + rzeczywista  # 15.5
roznica = calkowita - rzeczywista  # -1.5
iloczyn = calkowita * rzeczywista  # 59.5
iloraz = calkowita / rzeczywista  # 0.8235294117647058
potegowanie = rzeczywista ** calkowita  # 3205770.8828125
reszta = rzeczywista % calkowita  # 1.5
```

### Iteracja po cyfrach
```python
liczba = 1000500100900
for char in str(liczba):
    print(int(char))
```

### Suma cyfr
```python
liczba = 1000500100900
suma = 0
for char in str(liczba):
    suma += int(char)
print(suma)
```