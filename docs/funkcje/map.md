### map

Pozwala zmienić każdy element tablicy, zbioru.
Na końcu należy użyć funkcji [list](https://github.com/PanSzelescik/MaturaInformatyka/blob/python/docs/funkcje/list.md) lub [set](https://github.com/PanSzelescik/MaturaInformatyka/blob/python/docs/funkcje/set.md), aby przekonwertować typ danych

```python
tablica = [5, 6, 32, 2, 5]

# Dodawanie 1 do każdego elementu za pomocą lambdy
print(list(map(lambda x: x + 1, tablica)))  # [6, 7, 33, 3, 6]

# Dodawanie 1 do każdego elementu za pomocą zdefiniowanej funkcji
def dodaj(liczba):
    return liczba + 1


print(list(map(dodaj, tablica)))  # [6, 7, 33, 3, 6]
```