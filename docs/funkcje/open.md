### dict

Pozwala otworzyć plik. Przykładowe otwarcia plików znajdziesz w folderze [rozwiązania](https://github.com/PanSzelescik/MaturaInformatyka/tree/python/rozwiazania).

```python
file = open('../resources/2021_maj/DANE_2105/przyklad.txt', 'r', encoding='utf8')  # Wczytanie pliku o podanej ścieżce do odczytu (r) w utf8
array = list(map(lambda x: x.strip().split(' '), file))  # Dzielenie pliku na tablicę tablic, strip usuwa zbędne \n (znak nowej linii) oraz spacje, split dzieli string na tablicę w podanym znaku
file.close()  # Zamknięcie pliku

print(array)  # [['DOPISZ', 'Z'], ['DOPISZ', 'U'], ['USUN', '1'], ['DOPISZ', 'L'], ['DOPISZ', 'A'], ['PRZESUN', 'Z'], ['DOPISZ', 'U'], ['PRZESUN', 'U'], ['ZMIEN', 'M'], ['PRZESUN', 'M'], ['DOPISZ', 'N'], ['USUN', '1'], ['DOPISZ', 'T'], ['DOPISZ', 'U'], ['DOPISZ', 'R'], ['DOPISZ', 'H'], ['DOPISZ', 'N'], ['PRZESUN', 'H'], ['DOPISZ', 'V'], ['ZMIEN', 'G']]
```