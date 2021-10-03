def nextLetter(char):  # Funkcja obliczająca następną literę, jeśli zostanie podany Z, zwraca A
    if char == 'Z':
        return chr(ord(char) - 25)
    else:
        return chr(ord(char) + 1)



# Odczyt pliku
file = open('../../resources/2021_maj/DANE_2105/instrukcje.txt', 'r', encoding='utf8')  # Wczytanie pliku do odczytu w utf8
#file = open('../../resources/2021_maj/DANE_2105/przyklad.txt', 'r', encoding='utf8')  # Wczytanie pliku przykładowego do odczytu w utf8
array = list(map(lambda x: x.strip().split(' '), file))  # Dzielenie pliku na tablicę tablic, strip usuwa zbędne \n oraz spacje, split dzieli linię
file.close()  # Zamknięcie pliku

#print(array)  # Testowe wyprintowanie przygotowanego wczytanego pliku



# Zadanie 4.1
string = ''  # String który obliczamy
for instrukcja, litera in array:  # Taki for pozwala od razu pobierać dany element tablicy, skoro wiemy co tam siedzi
    if instrukcja == 'DOPISZ':
        string += litera  # Dopisz literę
    elif instrukcja == 'ZMIEN':
        string = string[:-1]  # Usuń ostatnią literę
        string += litera  # Dopisz literę
    elif instrukcja == 'USUN':
        string = string[:-1]  # Usuń ostatnią literę
    elif instrukcja == 'PRZESUN':
        for index, char in enumerate(string):  # Iteracja po literach w stringu, funkcja enumerate pozwala pobrać index w tablicy
            if char == litera:
                chars = list(string)  # Zamień string na tablicę znaków
                chars[index] = nextLetter(char)  # Użyj funkcji do zmiany litery na następną
                string = ''.join(chars)  # Złącz tablicę znaków na string
                break  # Break, bo mamy zamienić tylko jedną literę od lewej, więc nie ma sensu patrzeć dalej
print(len(string))  # Print długości stringa, rozwiązanie 4.1



# Zadanie 4.2
powtorzenia = []  # Tablica z powtórzeniami, którą będziemy obliczać
last_name = ''  # Ostatnia instrukcja
last_count = 0  # Ilość powtórzeń ostatniej instrukcji
for instrukcja, litera in array:  # Taki for pozwala od razu pobierać dany element tablicy, skoro wiemy co tam siedzi
    if last_name == '' and last_count == 0:  # Ten if spełnia się tylko przy pierwszej instrukcji
        last_name = instrukcja
        last_count = 1
    elif last_name == instrukcja:  # Jeśli instrukcja się powtarza dodaj 1
        last_count = last_count + 1
    else:  # Jeśli instrukcja nie powtarza się, dodaj do tablicy i ustaw nową instrukcję z 1 powtórzeniem
        powtorzenia.append([last_name, last_count])
        last_name = instrukcja
        last_count = 1
powtorzenia.append([last_name, last_count])  # Koniec instrukcji, dodaj do tablicy ostatnie powtórzenie

sorted_powtorzenia = sorted(powtorzenia, key=lambda x: x[1], reverse=True)  # Funkcja sortująca, biorąca pod uwagę 2 element tablicy w tablicy czyli liczbę
print(f'rodzaj instrukcji - {sorted_powtorzenia[0][0]}, długość ciągu - {sorted_powtorzenia[0][1]}')  # Print, rozwiązanie 4.2



# Zadanie 4.3
dopisywania = {}  # Słownik z dopisywaniami, który będziemy obliczać
for instrukcja, litera in array:  # Taki for pozwala od razu pobierać dany element tablicy, skoro wiemy co tam siedzi
    if instrukcja == 'DOPISZ':  # Sprawdzamy tylko instrukcje DOPISZ, inne nas nie obchodzą
        if litera in dopisywania:  # Jeśli litera jest już w słowniku dodaj 1
            dopisywania[litera] = dopisywania[litera] + 1
        else:  # Jeśli litery nie ma w słowniku, dodaj ją i ustaw 1
            dopisywania[litera] = 1

sorted_dopisywania = sorted(dopisywania.items(), key=lambda x: x[1], reverse=True)  # Funkcja sortująca, biorąca pod uwagę liczbę dopisań
print(f'litera {sorted_dopisywania[0][0]}, dopisywana {sorted_dopisywania[0][1]} razy')  # Print, rozwiązanie 4.3



# Zadanie 4.4
print(string)  # Print stringa, rozwiązanie 4.4, jego obliczenie następuje w trakcie zadania 4.1
