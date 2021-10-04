### set

Pozwala zamienić zbiór na listę, np.:
- string na zbiór
- rezultat funkcji pomocniczej na zbiór, np.:
  - [filter](https://github.com/PanSzelescik/MaturaInformatyka/blob/python/docs/funkcje/filter.md)
  - [map](https://github.com/PanSzelescik/MaturaInformatyka/blob/python/docs/funkcje/map.md)

```python
print(set('Hello world'))  # {'l', ' ', 'e', 'o', 'w', 'r', 'd', 'H'}

tablica = [5, 6, 32, 2, 5]
print(set(map(lambda x: x + 1, tablica)))  # {33, 3, 6, 7}
```