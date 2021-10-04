from datetime import datetime  # Import potrzebny do używania dat

date_format = '%Y-%m-%d'  # Format daty


def readfile(name, mapper):  # Funkcja wczytująca podany plik i tworząca tablicę tablic
    file = open(f'../../resources/2021_maj/DANE_2105/{name}', 'r', encoding='utf8')  # Wczytanie pliku do odczytu w utf8
    file.readline()  # Pomiń pierwsza linie z nazwami kolumn
    array = list(map(lambda x: mapper(x.strip().split('\t')),
                     file))  # Dzielenie pliku na tablicę tablic, strip usuwa zbędne \n oraz spacje, split dzieli linię, następnie utworzony string wrzuca do podanej funkcji mapper
    file.close()  # Zamknięcie pliku
    return array


def gracz(data):
    data[0] = int(data[0])  # Zamiana na liczbę
    data[2] = datetime.strptime(data[2], date_format).date()  # Zamiana stringa w date dla łatwiejszej analizy
    return data


def klasa(data):
    for j in range(1, 5):
        data[j] = int(data[j])  # Zamiana na liczbę
    return data


def jednostka(data):
    for k in [0, 1, 3, 4]:
        data[k] = int(data[k])  # Zamiana na liczbę
    return data


# Odczyt pliku
gracze = readfile('gracze.txt', gracz)  # id_gracza, kraj, data_dolaczenia
klasy = readfile('klasy.txt', klasa)  # nazwa, sila, strzal, magia, szybkosc
jednostki = readfile('jednostki.txt', jednostka)  # id_jednostki, id_gracza, nazwa, lok_x, lok_y

# Testowe wyprintowanie przygotowanych wczytanych plików
# print(gracze)
# print(klasy)
# print(jednostki)

# Zadanie 6.1
gracze_2018 = list(filter(lambda x: x[2].year == 2018, gracze))  # Filtrowanie graczy z 2018 roku
ilosc_graczy = {}  # Słownik który będziemy obliczać
for id_gracza, kraj, data_dolaczenia in gracze_2018:
    if kraj in ilosc_graczy:  # Jeśli kraj jest już w słowniku dodaj 1
        ilosc_graczy[kraj] = ilosc_graczy[kraj] + 1
    else:  # Jeśli kraju nie ma w słowniku, dodaj go i ustaw 1
        ilosc_graczy[kraj] = 1
posortowane = sorted(ilosc_graczy.items(), key=lambda x: x[1],
                     reverse=True)  # Funkcja sortująca, biorąca pod uwagę liczbę graczy
for i in range(0, 5):  # Pokaż 5 pierwszych elementów - 5 krajów, rozwiązanie 6.1
    print(f'{posortowane[i][0]} - {posortowane[i][1]}')
print('')


# Zadanie 6.2


def getstrzal(name):  # Funkcja pobierająca wartość strzału na podstawie podanej nazwy klasy
    for nazwa, sila, strzal, magia, szybkosc in klasy:
        if name == nazwa:
            return strzal
    return 0


elfy = list(filter(lambda x: 'elf' in x[2], jednostki))  # Filtrowanie jednostek z nazwą elf w nazwie
strzaly = {}  # Słownik który będziemy obliczać
for id_jednostki, id_gracza, nazwa, lok_x, lok_y in elfy:
    if nazwa in strzaly:  # Jeśli jednostka jest już w słowniku dodaj 1
        strzaly[nazwa] = strzaly[nazwa] + 1
    else:  # Jeśli jednostki nie ma w słowniku, dodaj ją i ustaw 1
        strzaly[nazwa] = 1
for nazwa, ilosc in strzaly.items():  # Pokaż sumę strzałów, rozwiązanie 6.2
    print(f'{nazwa} - {ilosc * getstrzal(nazwa)}')
print('')

# Zadanie 6.3
gracze_artylerzysci = set(map(lambda x: x[1], filter(lambda x: x[2] == 'artylerzysta',
                                                     jednostki)))  # Filtrowanie jednostek które są artylerzystami, następnie stwórz zbiór graczy, którzy mają chociaż 1 artylerzystę
gracze_nie_artylerzysci = list(filter(lambda id_gracza: id_gracza not in gracze_artylerzysci, map(lambda x: x[0],
                                                                                                  gracze)))  # Iteracja po graczach, w celu sprawdzenia czy są w zbiorze gracze_artylerzysci, jeśli nie są, to znaczy że nie mają artylerzysty
print(', '.join(str(x) for x in
                gracze_nie_artylerzysci))  # Zmień liczby na stringi, aby móc użyć funkcji join w celu wyprintowania, rozwiązanie 6.3
print('')


# Zadanie 6.4


def warunek(x, y, szybkosc):  # Warunek z treści zadania, pod koordynaty 100, 100
    return abs(x - 100) + abs(y - 100) <= szybkosc


def getszybkosc(name):  # Funkcja pobierająca wartość szybkości na podstawie podanej nazwy klasy
    for nazwa, sila, strzal, magia, szybkosc in klasy:
        if name == nazwa:
            return szybkosc
    return 0


zgodne = list(filter(lambda x: warunek(x[3], x[4], getszybkosc(x[2])),
                     jednostki))  # Filtrowanie jednostek, które spełniają warunek podany w zadaniu
dojda_do_bramy = {}  # Słownik który będziemy obliczać
for nazwa, sila, strzal, magia, szybkosc in klasy:
    dojda_do_bramy[nazwa] = 0  # Dodajemy wszystkie klasy do słownika i ustawiamy 0 jednostek
for id_jednostki, id_gracza, nazwa, lok_x, lok_y in zgodne:  # Iteracja po liście zgodnych jednostek i dodajemy odpowiednio 1
    dojda_do_bramy[nazwa] = dojda_do_bramy[nazwa] + 1
for nazwa, ilosc in dojda_do_bramy.items():
    print(f'{nazwa} - {ilosc}')  # Print, rozwiązanie 6.4
print('')


# Zadanie 6.5


def czypolak(wbitwie):  # Funkcja sprawdzająca czy w tablicy jednostek znajduje się jednostka Polaka
    for id_jednostki, id_gracza_jednostki, nazwa, lok_x, lok_y in wbitwie:
        for id_gracza, kraj, data_dolaczenia in gracze:
            if id_gracza_jednostki == id_gracza:
                if kraj == 'Polska':
                    return True
                else:
                    break
    return False


pozycje = {}  # Słownik który będziemy obliczać
for dane_jednostki in jednostki:
    id_jednostki, id_gracza, nazwa, lok_x, lok_y = dane_jednostki
    coords = f'{lok_x},{lok_y}'  # Klucz słownika to string x,y
    if coords in pozycje:  # Jeśli jest klucz w słowniku dodaj do tablicy jednostkę
        pozycje[coords].append(dane_jednostki)
    else:  # Jeśli nie ma klucza w słowniku dodaj tablicę z tą jednostką
        pozycje[coords] = [dane_jednostki]

bitwy = dict(
    filter(
        lambda x: len(
            set(
                map(
                    lambda y: y[1],
                    x[1]
                )
            )
        ) > 1,
        filter(
            lambda x: len(x[1]) > 1,
            pozycje.items()
        )
    )
)  # Skomplikowana linia więc po kolei:
# pozycje.items() - zmienia słownik na tablicę tablic dwuelementowych
# następnie filtr sprawdzający czy w miejscu jest więcej niż 1 jednostka
# następnie w filtrze:
# lista jednostek jest zamieniana na zbiór id_gracza
# pobierana jest długość zbioru
# filtr sprawdza czy ten zbiór jest większy niż 1
print(len(bitwy))  # Ilość bitw, rozwiązanie 6.5a

polacy = dict(filter(lambda x: czypolak(x[1]), bitwy.items()))  # Filtrowanie bitw w których jest chociaż 1 Polak
print(f'{len(polacy)} z udziałem Polaków')  # Ilość bitw z Polakami, rozwiązanie 6.5b
