def mapper(x):
    return x


def nextLetter(charac):
    if charac == "Z":
        return chr(ord(charac) - 25)

    else:
        change = ord(charac) + 1
        return chr(change)

file = open("../../resources/2021_maj/DANE_2105/instrukcje.txt", "r", encoding='utf8')
#file = open("../../resources/2021_maj/DANE_2105/przyklad.txt", "r", encoding='utf8')
array = list(map(lambda x: mapper(x.strip().split(' ')), file))
file.close()

#print(array)

# 4.1
string = ''
for value in array:
    if value[0] == 'DOPISZ':
        string += value[1]
    elif value[0] == 'ZMIEN':
        string = string[:-1]
        string += value[1]
    elif value[0] == 'USUN':
        string = string[:-1]
    elif value[0] == 'PRZESUN':
        for index, char in enumerate(string):
            if char == value[1]:
                chars = list(string)
                chars[index] = nextLetter(char)
                string = ''.join(chars)
                break
print(len(string))
print('')

# 4.2
powtorzenia = []
last_name = ''
last_count = 0
for value in array:
    if last_name == '' and last_count == 0:
        last_name = value[0]
        last_count = 1
    elif last_name == value[0]:
        last_count = last_count + 1
    else:
        powtorzenia.append([last_name, last_count])
        last_name = value[0]
        last_count = 1
powtorzenia.append([last_name, last_count])

sorter = lambda x: x[1]
sorted_powtorzenia = sorted(powtorzenia, key=sorter, reverse=True)
print(f'rodzaj instrukcji - {sorted_powtorzenia[0][0]}, długość ciągu - {sorted_powtorzenia[0][1]}')
print('')

# 4.3
dopisywania = {}
for value in array:
    if value[0] == 'DOPISZ':
        if value[1] in dopisywania:
            dopisywania[value[1]] = dopisywania[value[1]] + 1
        else:
            dopisywania[value[1]] = 1

sorted_dopisywania = sorted(dopisywania.items(), key=sorter, reverse=True)
print(f'litera {sorted_dopisywania[0][0]}, dopisywana {sorted_dopisywania[0][1]} razy')
print('')

# 4.4
print(string)