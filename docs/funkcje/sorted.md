### sorted

Służy do sortowania tablic, zbiorów, słowników

```python
# Sortowanie tablicy liczb
tablica = [6, 99, 2, 3, 1, 8]
print(sorted(tablica))  # [1, 2, 3, 6, 8, 99]
# Odwrócone sortowanie tablicy liczb
print(sorted(tablica, reverse=True))  # [99, 8, 6, 3, 2, 1]

# Sortowanie tablicy tablic
tablica = [[5, 7], [7, 3], [8, 9], [5, 0]]
print(sorted(tablica))  # [[5, 0], [5, 7], [7, 3], [8, 9]]
# Jak widać domyślnie tablica jest sortowana po pierwszym elemencie wewnętrznej tablicy
# Sortowanie tablicy tablic po drugim elemencie wewnętrznej tablicy
print(sorted(tablica, key=lambda x: x[1]))  # [[5, 0], [7, 3], [5, 7], [8, 9]]
# Jeśli potrzebujemy posortować odwrotnie to dodajemy reverse=True jak wyżej

# Jeśli chcemy posortować słownik, musimy użyć funkcji items
gracze = {
    'gracz_xyz': 5,
    'gracz_zyx': 9,
    'gracz_yxz': 2
}
posortowani = sorted(gracze.items(), key=lambda x: x[1])
print(posortowani)  # [('gracz_yxz', 2), ('gracz_xyz', 5), ('gracz_zyx', 9)]
print(dict(posortowani))  # {'gracz_yxz': 2, 'gracz_xyz': 5, 'gracz_zyx': 9}
```