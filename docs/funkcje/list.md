### list

Pozwala zamienić iterator na listę, np.:
- string na listę
- rezultat funkcji pomocniczej na listę, np.:
  - [filter](https://github.com/PanSzelescik/MaturaInformatyka/blob/python/docs/funkcje/filter.md)
  - [map](https://github.com/PanSzelescik/MaturaInformatyka/blob/python/docs/funkcje/map.md)

```python
print(list('Hello world'))  # ['H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd']

tablica = [5, 6, 32, 2, 5]
print(list(map(lambda x: x + 1, tablica)))  # [6, 7, 33, 3, 6]
```